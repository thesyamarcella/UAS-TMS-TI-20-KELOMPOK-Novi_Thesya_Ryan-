package com.acarainservices.acarainservices.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepo usersRepo;

    public User save(User users) {
        return usersRepo.save(users);
    }

    public User findOne(int id) {
        return usersRepo.findById(id).get();
    }

    public Iterable<User> findAll() {
        return usersRepo.findAll();
    }

    public void removeOne(int id) {
        usersRepo.deleteById(id);
    }

    // public Iterable<User> findByName(String name){
    // return usersRepo.findUserByName(name);
    // }
}
