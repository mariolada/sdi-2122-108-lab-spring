package com.uniovi.sdi_2122_108_spring.services;


import java.util.*;
import javax.annotation.PostConstruct;

import com.uniovi.sdi_2122_108_spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.sdi_2122_108_spring.entities.*;
import com.uniovi.sdi_2122_108_spring.services.UsersService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }
    public User getUserByDni(String dni) {
        return usersRepository.findByDni(dni);
    }


    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    public void updateUser(User user) {
        usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}