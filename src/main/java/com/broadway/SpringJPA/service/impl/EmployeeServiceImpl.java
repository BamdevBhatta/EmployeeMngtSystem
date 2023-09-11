package com.broadway.SpringJPA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.SpringJPA.model.Employee;
import com.broadway.SpringJPA.repository.EmployeeRepository;
import com.broadway.SpringJPA.service.IemployeeService;

@Service
public class EmployeeServiceImpl implements IemployeeService {
	@Autowired
	private EmployeeRepository erepo;

	@Override
	public void addEmployee(Employee employee) {
        erepo.save(employee);
	}

	@Override
	public Employee editEmployee(Long index) {
		//Employee emp = erepo.getById(index);
		return erepo.getById(index);
	}

	@Override
	public void deleteEmployee(Long index) {
		erepo.deleteById(index);
	}

	@Override
	public void updateEmployee(Employee employee) {
		erepo.save(employee);

	}

	@Override
	public List<Employee> getEmpList() {
	// List<Employee> list= erepo.findAll();
		return erepo.findAll();
		
	}

}
