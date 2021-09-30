package com.module;

import java.sql.*;

import javax.servlet.http.HttpServlet;


public class adminDAO extends HttpServlet{
	admin adm;
	public boolean validate(String uname,String password)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/school";
			Connection con=DriverManager.getConnection(url,"root","aladipillaiyar");
			
			//String query="select cred.id,cred.username,cred.password,name,age,designation,salutation from admin inner join admincredentials as cred on admin.id=cred.id where cred.username=\""+uname+"\" and cred.password=\""+password+"\"";
			String query="select * from admin inner join admincredentials as cred on cred.id=admin.id where cred.username=\""+uname+"\" and cred.password=\""+password+"\"";
			System.out.println(query);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				adm=new admin(rs);
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
