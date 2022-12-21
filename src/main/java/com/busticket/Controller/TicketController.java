package com.busticket.Controller;

import com.busticket.Entity.Route;
import com.busticket.Entity.Ticket;
import com.busticket.Service.RouteService;
import com.busticket.Service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    @Autowired
    RouteService routeService;
    @Autowired
    TicketService ticketService;
    @PutMapping("/addRoute")
    public void insertRoute(){
        routeService.addRoute();
    }
    @GetMapping("/getRoute")
    public List<Route> getAllRoute(){
        return routeService.getAll();
    }
    @PostMapping("/buyTicket")
    public String ticketPurchase(@RequestHeader(value = "fullName") String fullName, @RequestParam(value = "route") String routeId){
        Ticket ticket = ticketService.ticketPurchase(fullName, routeId);
        return ticket.getId();
    }
    @GetMapping("/getTicketInfo")
    public String getTicketInfo(@RequestParam(value = "ticket")String ticketId){
        Ticket ticket = ticketService.getTicket(ticketId);
        StringBuilder result = new StringBuilder();
        result.append("{\n\"paymentState\":\"");
        result.append(ticketService.getPayState(ticket.getPayId()));
        result.append("\",\n");
        result.append(routeService.getRoute(ticket.getRouteId()).toString());
        result.append("\n}");
        return result.toString();
    }
}
