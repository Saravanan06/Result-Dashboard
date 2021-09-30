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
 * Servlet implementation class recordDelete
 */
@WebServlet("/recordDelete")
public class recordDelete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student stud=(student) request.getSession().getAttribute("student");
		String rollno=stud.rollno;
		System.out.println(stud.rollno);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/school";
			String uname="root";
			String password="aladipillaiyar";
			Connection con=DriverManager.getConnection(url, uname, password);
			HttpSession session=request.getSession();
			String query="delete from student where rollno=(?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,rollno);
			System.out.println(query);
			pst.executeUpdate();
			query="delete from marklist where rollno=(?)";
			pst=con.prepareStatement(query);
			pst.setString(1,rollno);
			pst.executeUpdate();
			
			session.setAttribute("status", "deleted");
			response.sendRedirect("success.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
