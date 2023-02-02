package com.busticket;

import com.busticket.Controller.TicketController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BusTicketApplicationTests {
    @Autowired
    TicketController ticketController;
    @Test
    void contextLoads() {
        Assertions.assertThat(ticketController).isNot(null);
    }

}
