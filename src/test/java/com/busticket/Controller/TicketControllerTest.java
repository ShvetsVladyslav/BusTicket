package com.busticket.Controller;

import com.busticket.Service.RouteService;
import com.busticket.Service.TicketService;
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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TicketController.class)
class TicketControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TicketService ticketService;
    @MockBean
    private RouteService routeService;
    @Test
    void ticketPurchase() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.
                post("http://localhost:2020/ticket/buyTicket?route=63a2c5823590d06728c95749").
                header("fullName", "Test Name").
                accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertNotNull(result, "Result is Null");
    }

    @Test
    void getTicketInfo() throws Exception{
    }
}