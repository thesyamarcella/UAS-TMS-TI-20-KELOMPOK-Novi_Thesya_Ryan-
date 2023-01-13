package com.acarainservices.acarainservices.orders;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders, Integer> {
    //function query JPAQL atau Mysql QUERY
}



