package com.acarainservices.acarainservices.ticket;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketServices {

    @Autowired
    private TicketRepo ticketRepo;

    public Ticket save(Ticket events) {
        return ticketRepo.save(events);
    }

    public Ticket findOne(int id) {
        return ticketRepo.findById(id).get();
    }

    public Iterable<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    public void removeOne(int id) {
        ticketRepo.deleteById(id);
    }

    public List<Ticket> getIdTicket(int id) {
        return null;
    }

}
