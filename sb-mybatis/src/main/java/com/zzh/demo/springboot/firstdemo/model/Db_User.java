package com.zzh.demo.springboot.firstdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class Db_User {

	@Id
	@GeneratedValue
	private Integer Id;
	@NotNull(message = "名字不能为空")
	@Pattern(regexp = "^[\\u4E00-\\u9FFF]+$", message = "是不是中国人？")
	private String username;
	@NotNull(message = "密码不能为空")
	private String password;

}
