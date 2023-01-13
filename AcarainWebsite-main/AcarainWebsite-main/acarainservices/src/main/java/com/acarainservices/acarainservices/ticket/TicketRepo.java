package com.acarainservices.acarainservices.ticket;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TicketRepo extends CrudRepository<Ticket, Integer> {

    @Query(value = "SELECT a.* FROM ticket a WHERE a.event_id  = :id", nativeQuery = true)
    public Iterable<Ticket> getIdTicket(@Param("id") int id);

    @Query(value = "SELECT a.* FROM ticket a WHERE a.event_id  = :id", nativeQuery = true)
    public List<Ticket> getIdbyEvent(@Param("id") int id);
}