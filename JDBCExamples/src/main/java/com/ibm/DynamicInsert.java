package com.ibm;

import java.io.*;
import java.sql.*;

public class DynamicInsert {

	public static void main(String[] args) {
			
		try
		{
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/jdbcexamplesschema";
			String username="root";
			String password="admin";
			
			Class.forName(driver);
			
			Connection conn= DriverManager.getConnection(url,username,password);
			String insertquery="insert into emp(empno,ename) value (?,?)";
			PreparedStatement ptst=conn.prepareStatement(insertquery);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			
			System.out.println("enter id : ");
			int id=Integer.parseInt(br.readLine());
			
			System.out.println("enter name : ");
			String name=(br.readLine());
			
//			ptst.setInt(1, id);
			ptst.setInt(1, id);
			ptst.setString(2, name);
			
			ptst.executeUpdate();
			System.out.println("inserted");
			conn.close();
			
		}
		
		catch (Exception e) {
		e.printStackTrace();
		}
		
		finally {
			
		}
	}

}
