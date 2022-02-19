package com.uniovi.sdi_2122_108_spring.services;


import java.util.*;
import javax.annotation.PostConstruct;

import com.uniovi.sdi_2122_108_spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.sdi_2122_108_spring.entities.*;
import com.uniovi.sdi_2122_108_spring.services.UsersService;
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }

    public void addUser(User user) {
        usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}