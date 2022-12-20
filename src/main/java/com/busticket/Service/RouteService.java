package com.busticket.Service;

import com.busticket.Entity.Route;
import com.busticket.Repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    public Route getRoute(String id){
        if (routeRepository.findById(id).isPresent()){
            return routeRepository.findById(id).get();
        }
        else {
            return null;
        }
    }
    public Route ticketPurchase(String id){
        if (routeRepository.findById(id).isPresent()){
            Route updatedRoute = routeRepository.findById(id).get();
            updatedRoute.setAvailableTicket(updatedRoute.getAvailableTicket() - 1);
            routeRepository.save(updatedRoute);
            return updatedRoute;
        }
        else {
            return null;
        }
    }
}
