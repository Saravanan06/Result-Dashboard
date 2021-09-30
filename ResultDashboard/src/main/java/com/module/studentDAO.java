package com.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;

public class studentDAO extends HttpServlet {
	
	static student stud;
	public boolean validate(String rollno,String dob) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school";
		String uname="root";
		String password="aladipillaiyar";
		Connection con=DriverManager.getConnection(url,uname,password);
		//System.out.println(rollno+" "+dob);
		Statement st= con.createStatement();
		String query="select * from marklist inner join student where student.rollno=marklist.rollno and student.rollno='"+rollno+"' and student.dob="+dob;
		//System.out.println(query);
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
			//System.out.println("Inside True");
			stud=new student(rs);
			return true;
		}
		return false;

	}
	public boolean validate(String rollno) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school";
		String uname="root";
		String password="aladipillaiyar";
		Connection con=DriverManager.getConnection(url,uname,password);
		//System.out.println(rollno+" "+dob);
		Statement st= con.createStatement();
		String query="select * from marklist inner join student where student.rollno=marklist.rollno and student.rollno=\""+rollno+"\"";
		//System.out.println(query);
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
			System.out.println("Inside True");
			stud=new student(rs);
			return true;
		}
		return false;

	}

}
