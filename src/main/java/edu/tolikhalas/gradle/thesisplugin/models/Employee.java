package edu.tolikhalas.gradle.thesisplugin.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    private String lastname;

    private Position position;

    private LocalDate dob;

    private String email;

    public Employee(String firstname, String lastname, Position position, LocalDate dob) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.dob = dob;
    }

    public Employee(String firstname, String lastname, Position position, LocalDate dob, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.dob = dob;
        this.email = email;
    }

    public Employee(Long id, String firstname, String lastname, Position position, LocalDate dob, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.dob = dob;
        this.email = email;
    }

    public void setPosition(String code) {
        this.position = Position.fromCode(code);
    }

    public void setDob(String datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.dob = LocalDate.parse(datetime, formatter);
    }

    public void setEmail(String email) {
        if (email.equals("")) {
            this.email = null;
        } else {
            this.email = email;
        }
    }
}
