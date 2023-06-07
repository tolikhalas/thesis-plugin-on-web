package edu.tolikhalas.gradle.thesisplugin.controllers;

import edu.tolikhalas.gradle.thesisplugin.models.Employee;
import edu.tolikhalas.gradle.thesisplugin.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    EmployeeRepository repository;

    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String renderIndexPage(Model model) {
        List<Employee> employees = repository.findAll();
        model.addAttribute("employees", employees);
        return "index";
    }
}
