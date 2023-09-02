package com.asr.employee.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asr.employee.management.system.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
