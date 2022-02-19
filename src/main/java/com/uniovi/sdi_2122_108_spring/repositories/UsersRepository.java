package com.uniovi.sdi_2122_108_spring.repositories;

import com.uniovi.sdi_2122_108_spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
