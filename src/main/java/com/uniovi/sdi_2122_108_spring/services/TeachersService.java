package com.uniovi.sdi_2122_108_spring.services;

import com.uniovi.sdi_2122_108_spring.entities.Teacher;
import com.uniovi.sdi_2122_108_spring.services.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class TeachersService {

    @Autowired
    private TeacherRepository teachersRepository;

    @PostConstruct
    public void init() {
        teachersRepository.save(new Teacher(1L, "1", "name","surname","a"));
        teachersRepository.save(new Teacher(2L, "2", "name2","surname2","a2"));
    }
    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachersRepository.findAll().forEach(teachers::add);
        return teachers;
    }
    public Teacher getTeacher(Long id) {
        return teachersRepository.findById(id).get();
    }

    public void addTeacher(Teacher teacher) {
        teachersRepository.save(teacher);
    }
    public void deleteTeacher(Long id) {
        teachersRepository.deleteById(id);

    }

}
