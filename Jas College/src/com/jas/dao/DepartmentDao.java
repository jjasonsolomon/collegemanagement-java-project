package com.jas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jas.bean.Department;

public class DepartmentDao {
	private static final String INSERT_DEP_SQL = "INSERT INTO department VALUES " + " (?,?,?)";

	private static final String SELECT_DEP_BY_NAME = "select d_name,location,hod from department where d_name =?";
	private static final String SELECT_ALL_DEP = "select * from department";
	private static final String DELETE_DEP_SQL = "delete from department where d_name = ?";
	private static final String UPDATE_DEP_SQL = "update department set location= ?, hod =? where d_name = ?";

	
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = ConConnect.getConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	
	public void insertDep(Department dep) throws SQLException {
		System.out.println(INSERT_DEP_SQL);
		// try-with-resource statement will auto close the connection.
		try {Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement
													(INSERT_DEP_SQL);
			preparedStatement.setString(1,dep.getD_name());
			preparedStatement.setString(2,dep.getLocation() );
			preparedStatement.setString(3, dep.getHod());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Department selectDep(String dname) {
		Department department = null;
		// Step 1: Establishing a Connection
		try {Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement
													(SELECT_DEP_BY_NAME);
			preparedStatement.setString(1, dname);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String d_name = rs.getString("d_name");
				String location= rs.getString("location");
				String hod = rs.getString("hod");
				department = new Department(d_name, location, hod);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return department;
	}

	public List<Department> selectAllDep() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Department> department = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement
					(SELECT_ALL_DEP);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String d_name = rs.getString("d_name");
				String location= rs.getString("location");
				String hod = rs.getString("hod");
				department.add(new Department(d_name, location, hod));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return department;
	}

	
	public boolean updateDep(Department dep) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DEP_SQL);) {
			statement.setString(1,dep.getLocation());
			statement.setString(2, dep.getHod());
			statement.setString(3, dep.getD_name());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		
				ex.printStackTrace();
				
				}




	public boolean deleteDep(String dname) throws SQLException {
		// TODO Auto-generated method stub
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DEP_SQL);) {
			statement.setString(1, dname);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}





}
