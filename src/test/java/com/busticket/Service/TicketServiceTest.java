package com.busticket.Service;

import com.busticket.Entity.PayCallback;
import com.busticket.Entity.Route;
import com.busticket.Entity.Ticket;
import com.busticket.Repository.TicketRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {
    @InjectMocks
    TicketService ticketService;
    @Autowired
    private MockMvc mvc;
    @Mock
    RouteService routeService;
    @Mock
    TicketRepository ticketRepository;
    @Test
    @Description("whenGetRouteData_shouldReturnDefaultTicketAmount")
    void getAvailableTicket() {
        when(ticketService.getRouteData(any())).thenReturn(new Route("Откуда-то","Куда-то","Когда-то", 1000, 10));
        int result = ticketService.getRouteData("test").getAvailableTicket();
        assertEquals(10, result);
    }

    @Test
    @Description("whenFindById_shouldntReturnNullObject")
    void getTicket() {
        when(ticketRepository.findById(any())).thenReturn(Optional.of(new Ticket("TestRoute", "TestPay")));
        assertNotNull(ticketService.getTicket("test"));
    }

    @Test
    @Description("whenTicketPurchase_shouldReturnTicketWithExpectedData")
    void ticketPurchase() {
    }

    @Test
    @Description("whenGetPayState_shouldReturnNewState")
    void getPayState() {
        when(ticketService.getPayState("Test")).thenReturn("DONE");
        PayCallback result = new PayCallback();
        result.setState(ticketService.getPayState("Test"));
        assertEquals("DONE", result.getState());
    }
}