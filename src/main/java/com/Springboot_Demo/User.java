package com.Springboot_Demo;

public class User {

	private String name;
	private String email;
	private String phoneno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phoneno=" + phoneno + "]";
	}
}
