package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Employee;

public class EmployeDao {

	PreparedStatement pst;
	Connection con;

	public void connect() throws Exception {
		/*
  	Class.forName("org.postgresql.Driver");

        // Connect to PostgreSQL (update your DB name, username, password)
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tek", "postgres", "your_password");
        System.out.println("Connection Established with PostgreSQL!");
  */
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tek", "root", "8284");
		System.out.println("Connection Established..!");
	}

	public void insertRecord(Employee emp) throws Exception {
		pst = con.prepareStatement("insert into employee values(?,?,?)");
		pst.setInt(1, emp.getEid());
		pst.setString(2, emp.getEname());
		pst.setLong(3, emp.getMono());

		pst.executeUpdate();
		System.out.println("Record Inserted..!");
	}
	
	public void deleteRecord(Employee emp) throws Exception
	{
		pst = con.prepareStatement("delete from employee where eid="+emp.getEid());
		pst.executeUpdate();
		System.out.println("Record Deleted..!");
	}

	public void updateRecord(Employee emp) throws Exception
	{
		pst = con.prepareStatement("update employee set ename=?, mono=? where eid=?");
		pst.setInt(3, emp.getEid());
		pst.setString(1, emp.getEname());
		pst.setLong(2, emp.getMono());

		pst.executeUpdate();
		System.out.println("Record Updated..!");	
	}
}
