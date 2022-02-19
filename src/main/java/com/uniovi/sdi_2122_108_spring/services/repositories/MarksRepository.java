package com.uniovi.sdi_2122_108_spring.services.repositories;

import com.uniovi.sdi_2122_108_spring.entities.Mark;
import org.springframework.data.repository.CrudRepository;
public interface MarksRepository extends CrudRepository<Mark, Long> {
}