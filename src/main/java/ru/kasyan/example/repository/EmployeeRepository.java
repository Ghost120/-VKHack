package ru.kasyan.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.kasyan.example.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
