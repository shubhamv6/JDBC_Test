package com.ibm;

import java.sql.*;

public class JDBC_WorldExample {

		//JDBC drive name and database URL
		static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		static final String DB_URL="jdbc:mysql://localhost:3306/world";
		
		//db Credentials
		static final String USERNAME="root";
		static final String PASSWORD="admin";
		
		public static void main(String[] args) throws SQLException, ClassNotFoundException{
			JDBC_WorldExample j=new JDBC_WorldExample();
			j.getCityInformation();
	}
		
		private void getCityInformation() throws SQLException, ClassNotFoundException{
			Connection c=null;
			Statement stmt=null;
			
			try {
				//Register JDBC Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// Open a Connection
				System.out.println("Connecting to database...");
				c=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
				
				//Execute a query
				stmt=c.createStatement();
				
				String sql="Select ID,Name,CountryCode,District,Population from city where id<21";
				
				ResultSet rs=stmt.executeQuery(sql);
				
				//Extract data from resultset
				while(rs.next()) {
					int id=rs.getInt("ID");
					String name=rs.getString("Name");
					String countrycode=rs.getString("CountryCode");
					String district=rs.getString("District");
					int population=rs.getInt("Population");
					
					System.out.println("ID "+id) ;
					System.out.println("Name "+name);
					System.out.println("CountryCode "+countrycode);
					System.out.println("District "+district);
					System.out.println("Population "+population);
					
					System.out.println("\n\n");
				}
			
//			c.close();
			}
			catch(SQLException e) {	e.printStackTrace();	}
			finally {	c.close();	}
		}
}
