package edu.tolikhalas.gradle.thesisplugin.configurations;

import edu.tolikhalas.gradle.thesisplugin.models.Employee;
import edu.tolikhalas.gradle.thesisplugin.models.Position;
import edu.tolikhalas.gradle.thesisplugin.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class EmployeeConfig {

    final EmployeeRepository repository;

    public EmployeeConfig(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Bean
    public CommandLineRunner addMockEmployees() {
        return args -> {
            Employee john = new Employee("John", "Smith", Position.DEVELOPER, LocalDate.of(2000, 1, 1), "john@mail.com");

            Employee alexa = new Employee("Alexa", "Smith", Position.DESIGNER, LocalDate.of(2002, 10, 10));

            repository.save(john);
            repository.save(alexa);
        };
    }
}
