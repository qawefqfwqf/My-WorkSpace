package com.zzh.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class User {

	// hibernate建议不要用基本数据类型
	private Integer userId;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<>();

}
