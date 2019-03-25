package com.zzh.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Classroom {

	private Integer classId;
	private String className;
	private Set<Student> students = new HashSet<>();

}
