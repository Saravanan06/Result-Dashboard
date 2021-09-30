package com.module;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addRecord
 */
@WebServlet("/addRecord")
public class addRecord extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String rollno=request.getParameter("rollno").toString();
		String dob=request.getParameter("dob");
		int tamil=Integer.parseInt(request.getParameter("tamil"));
		int english=Integer.parseInt(request.getParameter("english"));
		int maths=Integer.parseInt(request.getParameter("maths"));
		int science=Integer.parseInt(request.getParameter("science"));
		int social=Integer.parseInt(request.getParameter("social"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/school";
			String uname="root";
			String password="aladipillaiyar";
			Connection con=DriverManager.getConnection(url, uname, password);
			String query1="select * from student where rollno=\""+rollno+"\"";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(query1);
			System.out.println(query1);
			PrintWriter out=response.getWriter();
			if(rs1.next()==false)
			{
				System.out.println("Inside If");
				String query="insert into student values (?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, rollno);
				pst.setString(2, name);
				pst.setString(3, dob);
				pst.executeUpdate();
				
				query="insert into marklist values (?,?,?,?,?,?)";
				pst=con.prepareStatement(query);
				pst.setString(1, rollno);
				pst.setInt(2, tamil);
				pst.setInt(3,english);
				pst.setInt(4, maths);
				pst.setInt(5, science);
				pst.setInt(6, social);
				pst.executeUpdate();
				HttpSession session=request.getSession();
				session.setAttribute("status", "added");
				response.sendRedirect("success.jsp");
			
			}
			else
			{
				HttpSession session=request.getSession();
				response.sendRedirect("dataExists.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
