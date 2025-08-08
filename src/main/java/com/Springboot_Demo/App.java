package com.Springboot_Demo;

import java.util.Map;

public class App {

	private String name;
	private String version;
	private String company;

	private Map<String, User> user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Map<String, User> getUser() {
		return user;
	}

	public void setUser(Map<String, User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "App [name=" + name + ", version=" + version + ", company=" + company + ", user=" + user + "]";
	}

}
