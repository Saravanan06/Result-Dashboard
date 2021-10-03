package com.module;

import java.sql.ResultSet;
import java.sql.SQLException;

public class student {

	String rollno;
	String name;
	int tamil,english,maths,science,social;
	int total;
	String dob;
	String result;
	public student(ResultSet rs) throws SQLException
	{
		rollno=rs.getString("marklist.rollno");
		name=rs.getString("student.name");
		tamil=rs.getInt("marklist.Tamil");
		english=rs.getInt("marklist.English");
		maths=rs.getInt("marklist.Maths");
		science=rs.getInt("marklist.Science");
		social=rs.getInt("marklist.Social");
		dob=rs.getString("student.dob");
		total=tamil+english+maths+science+social;
		if(total>250)result="Pass";
		else result="Fail";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "student [rollno=" + rollno + ", name=" + name + ", tamil=" + tamil + ", english=" + english + ", maths="
				+ maths + ", science=" + science + ", social=" + social + ", total=" + total + "]";
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTamil() {
		return tamil;
	}

	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public String[] getAllString()
	{
		String[] result= {this.name,this.dob,this.rollno,this.result};
		return result;
	}
	
	public int[] getAllInt()
	{
		int[] marks= {this.tamil,this.english,this.maths,this.science,this.social,this.social,this.total};
		return marks;
	}
	
	
	

}
