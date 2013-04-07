package com.bean;

import java.util.LinkedList;

public class Company {
	private String email;
	private String name;
	private String des;
	private LinkedList<Exam> exams;
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public LinkedList<Exam> getExams() {
		return exams;
	}
	public void setExams(LinkedList<Exam> exams) {
		this.exams = exams;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
}
