package com.busticket.Service;

import com.busticket.Entity.Route;
import com.busticket.Repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {
    @InjectMocks
    TicketService ticketService;
    @Mock
    RouteService routeService;
    @Mock
    TicketRepository ticketRepository;
    @Test
    void getAvailableTicket() {
        when(ticketService.getRouteData(any())).thenReturn(new Route("Откуда-то","Куда-то","Когда-то", 1000, 10));
        int result = ticketService.getRouteData("test").getAvailableTicket();
        assertEquals(10, result);
    }

    @Test
    void getTicket() {
    }

    @Test
    void ticketPurchase() {
    }

    @Test
    void getPayState() {
    }
}