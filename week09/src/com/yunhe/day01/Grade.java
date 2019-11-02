package com.yunhe.day01;

import java.io.*;
import java.util.*;

public class Grade implements Serializable {
	private double grade;

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	private String tid;

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	private String sid;

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Grade [grade" + this.grade + "tid" + this.tid + "sid" + this.sid + "]";
	}
}