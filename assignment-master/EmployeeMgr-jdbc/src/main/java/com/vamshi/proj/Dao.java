package com.vamshi.proj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Dao {

	private static Connection con;
	private static final String INSERT = "insert into employee_manager(first_name,last_name,age,gender,date_of_joining)"
			+ " values(?,?,?,?,?)";

	private Dao() {

	}

	static {
		try {
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres1", "psql1", "psql1");
		}  catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static int save(List<Employee> employees) {
		int result = 0;

		try (PreparedStatement pst = con.prepareStatement(INSERT)) {
			for (Employee employee : employees) {
				pst.setString(1, employee.getFirstName());
				pst.setString(2, employee.getLastName());
				pst.setInt(3, employee.getAge());
				pst.setString(4, employee.getGender().toString());
				pst.setDate(5, Date.valueOf(employee.getDateOfJoining()));
				pst.addBatch();
				result = pst.executeBatch().length;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
