package com.module;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class editRecord
 */
@WebServlet("/editRecord")
public class editRecord extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollno=request.getParameter("rollno");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/school";
			String uname="root";
			String password="aladipillaiyar";
			Connection con=DriverManager.getConnection(url, uname, password);
			String query1="select * from marklist inner join student where student.rollno=\""+rollno+"\" and marklist.rollno=\""+rollno+"\"";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query1);
			PrintWriter out=response.getWriter();
			if(rs.next())
			{
				student stud=new student(rs);
				HttpSession session=request.getSession();
				session.setAttribute("student", stud);
				response.sendRedirect("editPage.jsp");
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("status", "updated");
				response.sendRedirect("noRecord.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
