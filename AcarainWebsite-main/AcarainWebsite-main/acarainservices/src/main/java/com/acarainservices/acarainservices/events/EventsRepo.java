package com.acarainservices.acarainservices.events;

import org.springframework.data.repository.CrudRepository;

public interface EventsRepo extends CrudRepository<Events, Integer> {
    //function query JPAQL atau Mysql QUERY
}



