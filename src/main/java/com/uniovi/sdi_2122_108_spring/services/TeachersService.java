package com.uniovi.sdi_2122_108_spring.services;

import com.uniovi.sdi_2122_108_spring.entities.Mark;
import com.uniovi.sdi_2122_108_spring.entities.Teacher;
import com.uniovi.sdi_2122_108_spring.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
public class TeachersService {
    private List<Teacher> teachersList = new LinkedList<>();


    @PostConstruct
    public void init() {
        teachersList.add(new Teacher(1L, "1", "name","surname","a"));
        teachersList.add(new Teacher(2L, "2", "name2","surname2","a2"));
    }
    public List<Teacher> getTeachers() {
        return teachersList;
    }
    public Teacher getTeacher(Long id) {
        return teachersList.stream()
                .filter(mark -> mark.getId().equals(id)).findFirst().get();
    }
    public void addTeacher(Teacher teacher) {
        // Si en Id es null le asignamos el ultimo + 1 de la lista
        if (teacher.getId() == null) {
            teacher.setId(teachersList.get(teachersList.size() - 1).getId() + 1);
        }
    }

    public void deleteTeacher(Long id) {
        teachersList.removeIf(teacher -> teacher.getId().equals(id));
    }

}
