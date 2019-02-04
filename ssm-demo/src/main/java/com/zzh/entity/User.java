package com.zzh.entity;

import org.springframework.stereotype.Component;

//@Component
public class User {

	private String name;
	private int sex;
	private int age;
	private String email;

	public User(String name, int sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", age=" + age + ", email=" + email + "]";
	}

}
