package com.busticket.Controller;

import com.busticket.Service.RouteService;
import com.busticket.Service.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONParser;
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
@WebMvcTest(TicketController.class)
class TicketControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TicketController ticketController;
    @Test
    void ticketPurchase() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.
                post("/ticket/buyTicket?route=63a2c5823590d06728c95749").
                header("fullName", "Test Name").
                contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();
        System.out.println(result.getRequest().getRequestURI());
        Assertions.assertNotEquals(result.getResponse().getContentAsString(), "", "Empty Body");
    }

    @Test
    void getTicketInfo() throws Exception{
    }
}