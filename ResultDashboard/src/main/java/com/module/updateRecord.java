package com.module;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class updateRecord
 */
@WebServlet("/updateRecord")
public class updateRecord extends HttpServlet {
	Connection con;
	public void establishConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school";
		String uname="root";
		String password="aladipillaiyar";
		con=DriverManager.getConnection(url,uname,password);
		
	}
	public int checkRoll(String rollno)throws SQLException
	{
		String query="select * from student where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,rollno);
		ResultSet rs=st.executeQuery();
		if(rs.next())
			return 1;
		return 0;
		
	}
	public boolean updateRoll(String value,String where) throws SQLException
	{
		int status=checkRoll(value);
		if(status==1)
		{
			System.out.println("Rollno Already Exists");
			return false;
		}
		String query="update student set rollno=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
		System.out.println("Next");
		String query1="update marklist set rollno=(?) where rollno=(?);";
		PreparedStatement st1=con.prepareStatement(query1);
		st1.setString(1,value);
		st1.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st1.executeUpdate());
		return true;
		
	}
	
	public void updateName(String value,String where) throws SQLException
	{
		String query="update student set name=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
	}
	
	public void updateDOB(String value,String where)throws SQLException
	{
		String query="update student set dob=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
	}
	
	public void updateTamil(int value,String where)throws SQLException
	{
		String query="update marklist set Tamil=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
	}
	public void updateEnglish(int value,String where)throws SQLException
	{
		String query="update marklist set English=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
	}
	public void updateMaths(int value,String where)throws SQLException
	{
		String query="update marklist set Maths=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
	}
	public void updateScience(int value,String where)throws SQLException
	{
		String query="update marklist set Science=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
	}
	public void updateSocial(int value,String where)throws SQLException
	{
		String query="update marklist set Social=(?) where rollno=(?);";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,value);
		st.setString(2, where);
		System.out.println(value+" "+where);
		System.out.println(st.executeUpdate());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am here");
		try {
			establishConnection();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		student stud=(student) session.getAttribute("student");
		String masterno=stud.rollno;
		String roll=request.getParameter("roll");
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String tamil=request.getParameter("tamil").toString();
		String english=request.getParameter("english").toString();
		String maths=request.getParameter("maths").toString();
		String science=request.getParameter("science").toString();
		String social=request.getParameter("social").toString();
		boolean status=true;
		if(!roll.equals(""))
		{
			try {
				status=updateRoll(roll,masterno);
				if(!status)
				{
					System.out.println("Returned False");
					PrintWriter out=response.getWriter();
				    out.println("<script type=\"text/javascript\">");
				    out.println("alert('The entered rollno is already exist. Please try giving unique number')");
				    out.println("</script>");
				    System.out.println("Poda dei");
				}
				else
				{
				System.out.println(roll+" ----- ");
				System.out.println("Successfully Updated");
				masterno=roll;
				}
			} catch (SQLException e) {	
			}
			
		}
		if(!name.equals(""))
		{
			try {
				System.out.println(name+" ---- ");
				updateName(name,masterno);
				System.out.println("Successfully Updated");
			} catch (SQLException e) {
				
			}
			
		}
		if(!dob.equals(""))
		{
			try {
				System.out.println(dob+" ---- ");
				updateDOB(dob,masterno);System.out.println("Successfully Updated");
			} catch (SQLException e) {
				
			}
		}
		if(!tamil.equals(""))
		{
			try {
				int tamil1=Integer.parseInt(tamil);
				updateTamil(tamil1,masterno);System.out.println("Successfully Updated");
			} catch (SQLException e) {
				
			}
			
		}
		if(!english.equals(""))
		{
			try {
				int english1=Integer.parseInt(english);
				updateEnglish(english1,masterno);System.out.println("Successfully Updated");
			} catch (SQLException e) {
				
			}
			
		}
		if(!maths.equals(""))
		{
			try {
				int maths1=Integer.parseInt(maths);
				updateMaths(maths1,masterno);System.out.println("Successfully Updated");
			} catch (SQLException e) {
				
			}
		}
		if(!science.equals(""))
		{
			try {
				int science1=Integer.parseInt(science);
				updateScience(science1,masterno);System.out.println("Successfully Updated");
			} catch (SQLException e) {
				
			}
		}
		if(!social.equals(""))
		{
			try {
				int social1=Integer.parseInt(social);
				updateSocial(social1,masterno);System.out.println("Successfully Updated");
			} catch (SQLException e) {
				
			}
		}
		if(status)
		{
				session.setAttribute("status", "updated");
				response.sendRedirect("success.jsp");
			}
		else
		{
			PrintWriter out=response.getWriter();
			response.sendRedirect("misMatch.jsp");
		}
	}
}
