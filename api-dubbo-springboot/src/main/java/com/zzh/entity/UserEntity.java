package com.zzh.entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = -5809782578272943999L;
	private Integer sid;
	private String id;
	private String name;
	private String label;
	private String code;
	private Date createdate;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "UserEntity [sid=" + sid + ", id=" + id + ", name=" + name + ", label=" + label + ", code=" + code
				+ ", createdate=" + createdate + "]";
	}

}
