package com.bean;

import java.util.LinkedList;

public class Exam {
	private String examid;
	private String ename;
	private String schedule;
	private String duration;
	private String noofque;
	private String comp;
	private String questions_per_exam;
	private String minscore;
	private String semail;
	private String student;
	private LinkedList<Question> questions;
	private String score;
	public Exam()
	{
		questions=new LinkedList<Question>();
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getNoofque() {
		return noofque;
	}
	public void setNoofque(String noofque) {
		this.noofque = noofque;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public LinkedList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(LinkedList<Question> questions) {
		this.questions = questions;
	}
	public String getQuestions_per_exam() {
		return questions_per_exam;
	}
	public void setQuestions_per_exam(String questions_per_exam) {
		this.questions_per_exam = questions_per_exam;
	}
	public String getMinscore() {
		return minscore;
	}
	public void setMinscore(String minscore) {
		this.minscore = minscore;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
}
