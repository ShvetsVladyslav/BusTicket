package com.busticket.Service;

import com.busticket.Entity.Route;
import com.busticket.Repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Route> getAll(){
        return routeRepository.findAll();
    }
    public void addRoute(){
        Route newRoute = new Route("Откуда-то", "Куда-то", "Когда-то", 1000, 10);
        routeRepository.save(newRoute);
    }
}