package com.jbk.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jbk.dao.EmployeeDaoImpl;
import com.jbk.dao.EmployeeDaoi;
import com.jbk.entity.Employee;

public class EmployeeServiceImpl implements EmployeeServicei {
	
	private EmployeeDaoi dao=new EmployeeDaoImpl();
	
	@Override
	public ResponseEntity<String> addEmployee(Employee employee) {
		
		String msg= dao.addEmployee(employee);
		if (msg != "") {
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("ERROR !!! Something Went Wrong...", HttpStatus.NOT_IMPLEMENTED);
		}
		
	}

	@Override
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list=dao.getAllEmployees();
		if(list!=null) {
			return new ResponseEntity<>(list,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public ResponseEntity<String> updateEmployee(Employee employee) {
		String msg= dao.updateEmployee(employee);
		if (msg != "") {
			return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("ERROR !!! Something Went Wrong...", HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@Override
	public ResponseEntity<String> deleteEmployeeById(int id) {
		String msg= dao.deleteEmployeeById(id);
		if (msg != "") {
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("ERROR !!! Something Went Wrong...", HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(int id) {
		Employee employee=dao.getEmployeeById(id);
		if(employee!=null) {
			return new ResponseEntity<>(employee,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<Employee>> getEmployeeByName(String name) {
		List<Employee> employees=dao.getEmployeeByName(name);
		if(employees!=null) {
			return new ResponseEntity<>(employees,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<Employee>> employeeOrderedBySalaryAsc() {
		List<Employee> list=dao.employeeOrderedBySalaryAsc();
		if(list!=null) {
			return new ResponseEntity<>(list,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<Employee>> employeeOrderedBySalaryDesc() {
		List<Employee> list=dao.employeeOrderedBySalaryDesc();
		if(list!=null) {
			return new ResponseEntity<>(list,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public ResponseEntity<HashMap<String, Integer>> groupByDepartment() {
		HashMap<String, Integer> list=dao.groupByDepartment();
		if(list!=null) {
			return new ResponseEntity<>(list,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> getDistinctDepartmentCount() {
		int count=dao.getDistinctDepartmentCount();
		if(count!=0) {
			String msg="Total number of Departments : "+count;
			return new ResponseEntity<>(msg,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<Employee>> getEmployeeByDepartmentAndSalary(String department, double salary) {
		List<Employee> list=dao.getEmployeeByDepartmentAndSalary(department,salary);
		if(list!=null) {
			return new ResponseEntity<>(list,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
