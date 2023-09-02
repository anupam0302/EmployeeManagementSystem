package com.asr.employee.management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asr.employee.management.system.exception.ResourceNotFoundException;
import com.asr.employee.management.system.model.Employee;
import com.asr.employee.management.system.repository.EmployeeRepository;
import com.asr.employee.management.system.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The entered id is not valid."));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The entered id is not valid."));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		return saveEmployee(existingEmployee);
	}

	@Override
	public void deleteEmmployee(long id) {
		employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The entered id is not valid."));
		employeeRepository.deleteById(id);
	}

}
