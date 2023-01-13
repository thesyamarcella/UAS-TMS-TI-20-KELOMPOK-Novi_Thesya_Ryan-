package com.acarainservices.acarainservices.orders;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrdersServices {

    @Autowired
    private OrdersRepo eventsRepo;

    public Orders save(Orders events){
        return eventsRepo.save(events);
    }

    public Orders findOne(int id){
        return eventsRepo.findById(id).get();
    }

    public Iterable<Orders> findAll(){
        return eventsRepo.findAll();
    }

    public void removeOne(int id){
        eventsRepo.deleteById(id);
    }

    public Iterable<Orders> findbyname(String searchKey) {
        return null;
    }
    
}

