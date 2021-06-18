package com.ibm.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

public class InsertFile {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {
		try {	
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/jdbcexamplesschema";
			String username="root";
			String password="admin";
			
			Class.forName(driver);
			
			Connection conn= DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps=conn.prepareStatement("insert into filedb values(?,?)");
			
			File f=new File("E:\\Program Files\\Eclipse\\Workspace\\JavaWorkspace\\JDBCExamples\\src\\main\\resources\\text.txt");
			
			FileReader fr=new FileReader(f);
			
			ps.setInt(1, 106);
			ps.setCharacterStream(2, fr,(int)f.length());
			
			int i=ps.executeUpdate();
			
			System.out.println(i+" records affected");
		}
		catch(SQLException e) {		e.printStackTrace();    }
	}
}
