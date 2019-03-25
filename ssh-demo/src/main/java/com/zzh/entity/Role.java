package com.zzh.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Role {

	private Integer roleId;
	private String roleName;
	private Set<User> users = new HashSet<>();

}
