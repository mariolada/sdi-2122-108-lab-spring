package com.uniovi.sdi_2122_108_spring.controllers;

import com.uniovi.sdi_2122_108_spring.entities.Teacher;
import com.uniovi.sdi_2122_108_spring.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired //Inyectar el servicio
    private TeachersService teachersService;

    @RequestMapping("/teacher/list")
    public String getList() {
        return teachersService.getTeachers().toString();
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String setTeacher(@ModelAttribute Teacher teacher) {
        teachersService.addTeacher(teacher);
        return "profesor añadido";
    }

    @RequestMapping("/teacher/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return teachersService.getTeacher(id).toString();
    }


    @RequestMapping("/teacher/edit/{id}")
    public String getEdit(@PathVariable Long id) {
        return teachersService.getTeacher(id).toString();
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        teachersService.deleteTeacher(id);
        return "Profesor borrado correctamente";
    }


}
