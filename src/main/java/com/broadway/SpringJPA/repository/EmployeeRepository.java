package com.broadway.SpringJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.SpringJPA.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
