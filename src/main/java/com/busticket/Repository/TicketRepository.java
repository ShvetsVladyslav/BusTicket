package com.busticket.Repository;

import com.busticket.Entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TicketRepository extends MongoRepository<String, Ticket> {
}
