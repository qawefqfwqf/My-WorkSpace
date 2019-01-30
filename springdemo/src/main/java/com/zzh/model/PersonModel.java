package com.zzh.model;

import java.util.List;

public class PersonModel {

	private int id;

	private String name;

	private int age;

	private List<String> call;

	private String work;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getCall() {
		return call;
	}

	public void setCall(List<String> call) {
		this.call = call;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

}
