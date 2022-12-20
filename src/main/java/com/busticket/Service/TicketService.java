package com.busticket.Service;

import com.busticket.Entity.PayCallback;
import com.busticket.Entity.Payer;
import com.busticket.Entity.Ticket;
import com.busticket.Repository.TicketRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

import java.net.URI;
import java.net.http.*;

@Service
public class TicketService {
    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);
    @Autowired
    private RouteService routeService;
    @Autowired
    private TicketRepository ticketRepository;
    public int getAvailableTicket(String routeId){
        return routeService.getRoute(routeId).getAvailableTicket();
    }
    private Ticket getTicket(String id){
        if (ticketRepository.findById(id).isPresent()){
            return ticketRepository.findById(id).get();
        }
        else {
            return null;
        }
    }
    public Ticket ticketPurchase(String fullName, String routeId){
        Ticket response;
        if (getAvailableTicket(routeId)>0){
            try {
                ObjectMapper mapper = new ObjectMapper();
                String requestBody = mapper.writeValueAsString(new Payer(fullName, routeService.getRoute(routeId).getPrice()));
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().
                        uri(URI.create("http://localhost:8080/payment/create"))
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
                HttpResponse<String> apiCall = client.send(request,
                        HttpResponse.BodyHandlers.ofString());
                PayCallback callback = mapper.convertValue(apiCall, PayCallback.class);
                if (callback.isResponse()){
                    response = new Ticket(routeId, callback.getPayId());
                    ticketRepository.save(response);
                    routeService.ticketPurchase(routeId);
                }
                else {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Unsuccessful payment");
                }
            }
            catch (IOException ioException){
                throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, "Get TIMEOUT from payment");
            } catch (InterruptedException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Какая-то хуйня"); //TODO: поправить ошибку
            }

        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "No tickets available");
        }
        return response;
    }
    public String getPayState(String payId){
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().
                    uri(URI.create("http://localhost:8080/payment/find?id=" + payId))
                    .GET().build();
            HttpResponse<String> apiCall = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            logger.info(apiCall.toString());
            PayCallback callback = mapper.convertValue(apiCall, PayCallback.class);
            if (callback.getState()!=null) {
                return callback.getState();
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "State not found");
            }
        }
        catch (InterruptedException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Какая-то хуйня"); //TODO: поправить ошибку
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, "Get TIMEOUT from payment");
        }
    }
}
