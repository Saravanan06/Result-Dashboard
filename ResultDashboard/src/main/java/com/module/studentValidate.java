package com.module;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class studentValidate
 */
@WebServlet("/studentValidate")
public class studentValidate extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollno=request.getParameter("rollno").toString();
		String dob="\""+request.getParameter("dob")+"\"".toString();
		studentDAO stud=new studentDAO();

		boolean status=false;
		try {
			status = stud.validate(rollno,dob);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(status);
		if(status)
		{
			HttpSession session=request.getSession();
			session.setAttribute("student",stud.stud);
			response.sendRedirect("displayMarklist.jsp");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("invalidCredientials.jsp");
			rd.forward(request, response);
		}
		
	}

}
