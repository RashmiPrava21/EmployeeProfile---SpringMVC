package com.daoprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.beanprograms.EmployeeInfo;

@Repository
public class EmployeeDao {

	@Value ("${db.url}")
	private String url;
	
	@Value ("${db.username}")
	private String username;
	
	@Value ("${db.password}")
	private String password;
	
	public List<EmployeeInfo> getAll() throws SQLException{
		
		EmployeeInfo empInfo = new EmployeeInfo();
		List<EmployeeInfo> rows = new ArrayList<EmployeeInfo>();
		Connection con = getConnection();
		System.out.println("Connection Established");
		
		Statement stmt = null;
		String query = "select * from employees";
		stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			empInfo.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			empInfo.setFirst_name(rs.getString("FIRST_NAME"));
			empInfo.setLast_name(rs.getString("LAST_NAME"));
			empInfo.setEmail(rs.getString("EMAIL"));
			empInfo.setPhone_number(rs.getString("PHONE_NUMBER"));
			empInfo.setHire_date(rs.getDate("HIRE_DATE"));
			empInfo.setJob_id(rs.getString("JOB_ID"));
			empInfo.setSalary(rs.getInt("SALARY"));
			empInfo.setCommission_pct(rs.getLong("COMMISSION_PCT"));
			empInfo.setManager_id(rs.getInt("MANAGER_ID"));
			empInfo.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			rows.add(empInfo);
//			System.out.println(rows);
			empInfo = new EmployeeInfo();
		}
		
//		return empInfo;
		System.out.println(rows);
		System.out.println("Sending data!!");
		return rows;
	}
	
	private Connection getConnection() {
		
		Connection con = null;
		try {
			
			System.out.println("Connection details: ");
			System.out.println(url + " " + username+" "+ password);
			Class.forName(url);
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", username, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
