package com.yunhe.day01;

import java.io.*;
import java.util.*;

public class Student implements Serializable {
	private String sword;

	public String getSword() {
		return this.sword;
	}

	public void setSword(String sword) {
		this.sword = sword;
	}

	private int isTrue;

	public int getIsTrue() {
		return this.isTrue;
	}

	public void setIsTrue(int isTrue) {
		this.isTrue = isTrue;
	}

	private String sname;

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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
		return "Student [sword" + this.sword + "isTrue" + this.isTrue + "sname" + this.sname + "sid" + this.sid + "]";
	}
}