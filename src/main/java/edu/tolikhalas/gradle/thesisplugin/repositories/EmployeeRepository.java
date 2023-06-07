package edu.tolikhalas.gradle.thesisplugin.repositories;

import edu.tolikhalas.gradle.thesisplugin.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
