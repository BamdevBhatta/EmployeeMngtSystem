package com.broadway.SpringJPA.service;

import java.util.List;

import com.broadway.SpringJPA.model.Employee;

public interface IemployeeService {
	void addEmployee(Employee employee);

	Employee editEmployee(Long index);

	void deleteEmployee(Long index);

	void updateEmployee(Employee employee);
	List<Employee> getEmpList();
}
