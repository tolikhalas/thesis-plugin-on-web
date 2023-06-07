package edu.tolikhalas.gradle.thesisplugin.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private Position position;

    private LocalDate dob;

    private String email;

    public Employee(String firstName, String lastName, Position position, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.dob = dob;
    }

    public Employee(String firstName, String lastName, Position position, LocalDate dob, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.dob = dob;
        this.email = email;
    }

    public Employee(Long id, String firstName, String lastName, Position position, LocalDate dob, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.dob = dob;
        this.email = email;
    }
}
