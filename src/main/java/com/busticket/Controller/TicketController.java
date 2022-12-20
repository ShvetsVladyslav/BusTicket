package com.busticket.Controller;

import com.busticket.Entity.Route;
import com.busticket.Entity.Ticket;
import com.busticket.Service.RouteService;
import com.busticket.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    RouteService routeService;
    @Autowired
    TicketService ticketService;
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
    public String getTicketInfo(@RequestParam(value = "ticket") String ticketId){
        return ticketService.getPayState("63a245fe20f286578c521419");
    }
}
