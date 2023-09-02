package com.asr.employee.management.system.service;

import java.util.List;

import com.asr.employee.management.system.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	Employee updateEmployee(Employee employee, long id);

	void deleteEmmployee(long id);
}
