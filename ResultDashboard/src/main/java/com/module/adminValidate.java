package com.module;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminValidate
 */
@WebServlet("/adminValidate")
public class adminValidate extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username").toString();
		String password=request.getParameter("password").toString();
		adminDAO admin=new adminDAO();
		System.out.println(uname+" "+password);
		boolean status=admin.validate(uname,password);
		System.out.println(status);
		HttpSession session=request.getSession();
		if(status)
		{
			session.setAttribute("admin",admin.adm);
			response.sendRedirect("adminMain.jsp");
		}
		else
		{
			session.setAttribute("errormsg","Invalid Username or Password");
			response.sendRedirect("invalidCredientials.jsp");
		}
	}

}
