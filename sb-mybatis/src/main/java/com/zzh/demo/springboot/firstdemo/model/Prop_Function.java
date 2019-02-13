package com.zzh.demo.springboot.firstdemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "functions")
@Data
public class Prop_Function {

	private List<Map<String, String>> function = new ArrayList<>();
}
