package com.jbk.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Employee;
import com.jbk.service.EmployeeServiceImpl;
import com.jbk.service.EmployeeServicei;

@RestController
@RequestMapping("employee")
public class EmployeeController {
 
	private EmployeeServicei service = new EmployeeServiceImpl();

	@PostMapping(value="/add-employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> msg = service.addEmployee(employee);
		
		return msg;
	}
	
	@GetMapping("/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		ResponseEntity<List<Employee>> list = service.getAllEmployees();
		
		return service.getAllEmployees();
	}
	
	@PutMapping("/update-employee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> msg = service.updateEmployee(employee);
		
		return msg;
	}
	
	@DeleteMapping("/delete-employee-by-id/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
		ResponseEntity<String> msg = service.deleteEmployeeById(id);
		
		return msg;
	}
	
	@GetMapping("/get-employee-by-id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		ResponseEntity<Employee> employee = service.getEmployeeById(id);
		
		return employee;
	}
	
	@GetMapping("/get-employee-by-name/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name ) {
		ResponseEntity<List<Employee>> employees = service.getEmployeeByName(name);
		
		return employees;
	}
	
	@GetMapping("/employees-ordered-by-salary-asc")
	public ResponseEntity<List<Employee>> employeeOrderedBySalaryAsc() {
		ResponseEntity<List<Employee>> employees = service.employeeOrderedBySalaryAsc();
		
		return employees;
	}
	
	@GetMapping("/employees-ordered-by-salary-desc")
	public ResponseEntity<List<Employee>> employeeOrderedBySalaryDesc() {
		ResponseEntity<List<Employee>> employees = service.employeeOrderedBySalaryDesc();
		
		return employees;
	}
	
	
	@GetMapping("/group-by-department-with-count")
	public ResponseEntity<HashMap<String, Integer>> groupByDepartment() {
		ResponseEntity<HashMap<String, Integer>> list = service.groupByDepartment();
		
		return list;
	}
	
	@GetMapping("/get-distinct-department-count")
	public ResponseEntity<String> getDistinctDepartmentCount() {
		ResponseEntity<String> count = service.getDistinctDepartmentCount();
		
		return count;
	}
	
	@GetMapping("/get-employee-by-department-and-salary-condition/{department}{salary}")
	public ResponseEntity<List<Employee>> getEmployeeByDepartmentAndSalary(@PathVariable("department") String department,@PathVariable("salary") double salary) {
		ResponseEntity<List<Employee>> employees = service.getEmployeeByDepartmentAndSalary(department,salary);
		
		return employees;
	}
	
}
