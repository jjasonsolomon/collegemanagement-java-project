package com.jas.bean;

public class Department {
	private String d_name,location,hod;

	public Department() {
	}



	public Department(String d_name, String location, String hod) {
		super();
		this.d_name = d_name;
		this.location = location;
		this.hod = hod;
	}


	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	@Override
	public String toString() {
		return "Department [d_name=" + d_name + ", location=" + location + ", hod=" + hod + "]";
	}

}
