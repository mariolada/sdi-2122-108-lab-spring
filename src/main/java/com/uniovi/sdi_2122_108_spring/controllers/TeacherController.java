package com.uniovi.sdi_2122_108_spring.controllers;

import com.uniovi.sdi_2122_108_spring.entities.Mark;
import com.uniovi.sdi_2122_108_spring.entities.Teacher;
import com.uniovi.sdi_2122_108_spring.entities.User;
import com.uniovi.sdi_2122_108_spring.services.RolesService;
import com.uniovi.sdi_2122_108_spring.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired //Inyectar el servicio
    private TeachersService teachersService;

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/professor/list")
    public String getList(Model model) {
        model.addAttribute("teacherList", teachersService.getTeachers());
        return "professor/list";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setTeacher(@ModelAttribute Teacher teacher) {
        teachersService.addTeacher(teacher);
        return "redirect:/professor/list";
    }
    @RequestMapping(value = "/professor/add")
    public String getTeacher(Model model) {
        model.addAttribute("rolesList", rolesService.getRoles());
        model.addAttribute("teachersList", teachersService.getTeachers());
        return "professor/add";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", teachersService.getTeacher(id));
        return "professor/details";
    }


    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        Teacher teacher = teachersService.getTeacher(id);
        model.addAttribute("teacher", teacher);
        return "professor/edit";
    }

    @RequestMapping("/professor/delete/{id}")
    public String delete(@PathVariable Long id) {
        teachersService.deleteTeacher(id);
        return "redirect:/professor/list";
    }


}
