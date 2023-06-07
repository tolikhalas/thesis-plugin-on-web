package edu.tolikhalas.gradle.thesisplugin.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tolikhalas.gradle.thesisplugin.models.Employee;
import edu.tolikhalas.gradle.thesisplugin.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeRepository repository;
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

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

    @PostMapping
    public String addEmployee(@RequestBody String json, Model model) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info(String.format("New employee: [%s]", json));
        System.out.println(json);

        Employee newEmployee = objectMapper.readValue(json, Employee.class);

        repository.save(newEmployee);
        return renderIndexPage(model);
    }
}
