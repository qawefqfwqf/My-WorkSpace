package com.zzh.demo.springboot.firstdemo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
//不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "myProps")
//配置文件中的前缀
@Data
public class Prop_MyProps {

	private String simpleProp;
	private String[] arrayProps;
	private List<Map<String, String>> listProp1 = new ArrayList<>(); // 接收prop1里面的属性值
	private List<String> listProp2 = new ArrayList<>(); // 接收prop2里面的属性值
	private Map<String, String> mapProps = new HashMap<>(); // 接收prop1里面的属性值
}
