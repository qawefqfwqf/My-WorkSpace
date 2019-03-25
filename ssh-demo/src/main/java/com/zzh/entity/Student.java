package com.zzh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

	private Integer studentId;
	private String studentName;
	private Classroom classroom;

}
