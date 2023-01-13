package com.acarainservices.acarainservices.events;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EventsServices {

    @Autowired
    private EventsRepo eventsRepo;

    public Events save(Events events) {
        return eventsRepo.save(events);
    }

    public Events findOne(int id) {
        return eventsRepo.findById(id).get();
    }

    public Iterable<Events> findAll() {
        return eventsRepo.findAll();
    }

    public void removeOne(int id) {
        eventsRepo.deleteById(id);
    }

    public Iterable<Events> findbyname(String searchKey) {
        return null;
    }

}
