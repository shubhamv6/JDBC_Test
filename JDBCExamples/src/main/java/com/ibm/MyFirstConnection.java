package com.ibm;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class MyFirstConnection {
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		String username="root",password="admin";
		Connection con=null;
		try {
			//Loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Creating Connection");
			
			//Creating Connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexamplesschema",username,password);
			
			PreparedStatement pst=con.prepareStatement("Insert into emp values(?,?)");
			pst.setInt(1, 101);
			pst.setString(2, "Adam");
			
//			pst.executeUpdate();
			(con.prepareStatement("Insert into emp values(?,?)")).executeUpdate();
			System.out.println("Inserted");
		}
		catch(SQLException e) {	System.out.println(e.getMessage());		}
		finally {	con.close();		}
	}
}
