package com.busticket.Controller;

import com.busticket.Entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TicketController.class)
class TicketControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private TicketController ticketController;
    @Test
    void ticketPurchase() throws Exception {
        Ticket ticket = new Ticket("63a2c5823590d06728c95749", "TestPayment");
        ticket.setId("TestTicketID");

        when(ticketController.ticketPurchase(any(), any())).thenReturn(ticket.getId());

        MvcResult result = mvc.perform(post("/ticket/buyTicket")
                        .param("route","63a2c5823590d06728c95749")
                        .header("fullName", "Test Name")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        Assertions.assertNotEquals(result.getResponse().getContentAsString(), "", "Empty Body");
    }

    @Test
    void getTicketInfo() throws Exception{
    }
}