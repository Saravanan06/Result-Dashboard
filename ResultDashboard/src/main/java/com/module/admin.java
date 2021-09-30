package com.module;

import java.sql.*;

public class admin {
	String username;
	String password;
	String name;
	String desgination;
	int age;
	String salutation;
	int id;
	
	public admin(ResultSet rs) throws SQLException
	{
		this.username=rs.getString("cred.username");
		this.password=rs.getString("cred.password");
		this.name=rs.getString("admin.name");
		this.desgination=rs.getString("admin.designation");
		this.salutation=rs.getString("admin.salutation");
		this.age=rs.getInt("admin.age");
		this.id=rs.getInt("cred.id");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
