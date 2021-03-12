package com.jbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jbk.config.DBConnection;
import com.jbk.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDaoi {

	Connection connection = DBConnection.getConnection();

	@Override
	public String addEmployee(Employee employee) {
		String msg = "";
		String sql = "INSERT INTO employee (firstName,lastName,department,salary) values (?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getDepartment());
			preparedStatement.setDouble(4, employee.getSalary());

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				msg = "Employee '" + employee.getFirstName() + "' added SUCCESSFULLY !!!";
			} else {
				msg = "";
				System.out.println(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

			System.out.println(1);
			list = new ArrayList<>();
			System.out.println(2);
			while (resultSet.next()) {
				System.out.println(3);
				Employee employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("department"),
						resultSet.getDouble("salary"));
				System.out.println(employee);

				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String msg = "";
		String sql = "UPDATE employee SET firstName=?,lastName=?,department=?,salary=? WHERE employeeId=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getDepartment());
			preparedStatement.setDouble(4, employee.getSalary());
			preparedStatement.setInt(5, employee.getEmployeeId());

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				msg = "Employee with ID (" + employee.getEmployeeId() + ") updated SUCCESSFULLY !!!";
			} else {
				msg = "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteEmployeeById(int id) {
		String msg = "";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM employee WHERE employeeId=?");
			preparedStatement.setInt(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				msg = "Employee with ID (" + id + ") updated SUCCESSFULLY !!!";
			} else {
				msg = "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Employee getEmployeeById(int id) {

		Employee employee = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM employee WHERE employeeId=?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("department"),
						resultSet.getDouble("salary"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> list = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM employee WHERE firstName=?");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			list = new ArrayList<>();

			while (resultSet.next()) {

				Employee employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("department"),
						resultSet.getDouble("salary"));
				System.out.println(employee);

				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Employee> employeeOrderedBySalaryAsc() {
		List<Employee> list = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee ORDER BY salary ASC");

			list = new ArrayList<>();
			System.out.println(list);

			while (resultSet.next()) {
				System.out.println(3);
				Employee employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("department"),
						resultSet.getDouble("salary"));
				System.out.println(employee);

				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Employee> employeeOrderedBySalaryDesc() {
		List<Employee> list = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee ORDER BY salary DESC");

			list = new ArrayList<>();
			System.out.println(list);

			while (resultSet.next()) {
				System.out.println(3);
				Employee employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("department"),
						resultSet.getDouble("salary"));
				System.out.println(employee);

				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	

	
	@Override
	public HashMap<String,Integer> groupByDepartment() {
		HashMap<String, Integer> hashMap=new HashMap<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select department,count(*) from employee group by department");

			

			while (resultSet.next()) {
				
				hashMap.put(resultSet.getString(1), resultSet.getInt(2));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hashMap;
	}

	@Override
	public int getDistinctDepartmentCount() {
		int count=0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT  COUNT(DISTINCT department) FROM employee;");

			

			while (resultSet.next()) {
				
				count=resultSet.getInt(1);
				System.out.println(count);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Employee> getEmployeeByDepartmentAndSalary(String department, double salary) {
		List<Employee> list = null;

		try {
	
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM employee WHERE department=? AND salary>=:?");
			preparedStatement.setString(1, department);
			preparedStatement.setDouble(2, salary);
			
			ResultSet resultSet=preparedStatement.executeQuery();

			System.out.println(1);
			list = new ArrayList<>();
			System.out.println(2);
			while (resultSet.next()) {
				System.out.println(3);
				Employee employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("department"),
						resultSet.getDouble("salary"));
				System.out.println(employee);

				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
