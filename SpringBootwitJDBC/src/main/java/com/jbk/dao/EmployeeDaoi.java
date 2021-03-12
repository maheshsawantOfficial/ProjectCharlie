package com.jbk.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jbk.entity.Employee;

public interface EmployeeDaoi {

	String addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	String updateEmployee(Employee employee);

	String deleteEmployeeById(int id);

	Employee getEmployeeById(int id);

	List<Employee> getEmployeeByName(String name);

	List<Employee> employeeOrderedBySalaryAsc();

	List<Employee> employeeOrderedBySalaryDesc();

	HashMap<String, Integer> groupByDepartment();

	int getDistinctDepartmentCount();

	List<Employee> getEmployeeByDepartmentAndSalary(String department, double salary);

}
