package com.acarainservices.acarainservices.user;

// import javax.websocket.server.PathParam;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    // // @Query(value = "SELECT a.* FROM users a WHERE a.firstname = :name ",
    // // nativeQuery = true)
    // @Query("SELECT a FROM Users a WHERE (a.firstName like %:name% or a.middlename
    // like %:name% or a.lastname like %:name%) or a.npm like %:name% ")
    // // @Query("SELECT a FROM Users a WHERE (a.firstname like %:name% or
    // a.middlename
    // // like %:name% or a.lastname like %:name%) or a.npm like %:name% ")
    // public Iterable<User> findUserByName(@PathParam("firstName") String
    // firstName);

}
