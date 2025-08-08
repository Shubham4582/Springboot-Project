package com.Springboot_Demo;

import java.util.List;

public class Mobile {

	private String brand;
	private String ram;
	private String price;

	private List<App> app;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<App> getApp() {
		return app;
	}

	public void setApp(List<App> app) {
		this.app = app;
	}
	
	@Override
	public String toString() {
		return "Mobile [brand=" + brand + ", ram=" + ram + ", price=" + price + ", app=" + app + "]";
	}
}
