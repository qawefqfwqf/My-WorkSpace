package com.zzh.entity;

public class User {
	private Integer userId;

	private String userPwd;

	private String userName;

	private Integer userDeptId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public Integer getUserDeptId() {
		return userDeptId;
	}

	public void setUserDeptId(Integer userDeptId) {
		this.userDeptId = userDeptId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userDeptId="
				+ userDeptId + "]";
	}

}