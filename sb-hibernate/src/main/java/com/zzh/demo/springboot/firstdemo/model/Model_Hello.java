package com.zzh.demo.springboot.firstdemo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder(toBuilder=true)

public class Model_Hello {
	
	private String date;
	private String weekday;
	private String wheather;
	private String position;

}
