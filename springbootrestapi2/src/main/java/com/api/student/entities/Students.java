package com.api.student.entities;

public class Students {
	
	private int roll;
	private String name;
	private String sec;
	public Students(int roll, String name, String sec) {
		super();
		this.roll = roll;
		this.name = name;
		this.sec = sec;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	@Override
	public String toString() {
		return "Students [roll=" + roll + ", name=" + name + ", sec=" + sec + "]";
	}
	
	
	

}
