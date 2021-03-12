package com.jbk.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jbk.entity.Employee;

public interface EmployeeServicei {

	ResponseEntity<String> addEmployee(Employee employee);

	ResponseEntity<List<Employee>> getAllEmployees();

	ResponseEntity<String> updateEmployee(Employee employee);

	ResponseEntity<String> deleteEmployeeById(int id);

	ResponseEntity<Employee> getEmployeeById(int id);

	ResponseEntity<List<Employee>> getEmployeeByName(String name);

	ResponseEntity<List<Employee>> employeeOrderedBySalaryAsc();

	ResponseEntity<List<Employee>> employeeOrderedBySalaryDesc();

	ResponseEntity<HashMap<String, Integer>> groupByDepartment();

	ResponseEntity<String> getDistinctDepartmentCount();

	ResponseEntity<List<Employee>> getEmployeeByDepartmentAndSalary(String department, double salary);

}
