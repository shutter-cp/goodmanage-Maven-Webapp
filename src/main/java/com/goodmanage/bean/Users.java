/**
 * chenPeng
 * com.goodmanage.bean
 * Users.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-上午11:04:41 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.bean;

/**
 * 
 * Users
 * 创建人:chenPeng
 * 时间：2018年12月4日-上午11:04:41 
 * @version 1.0.0
 * 
 */
public class Users {
	private String userName;
	private String pwd;
	private Integer validateFlag;
	private Integer roles;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getValidateFlag() {
		return validateFlag;
	}
	public void setValidateFlag(Integer validateFlag) {
		this.validateFlag = validateFlag;
	}
	public Integer getRoles() {
		return roles;
	}
	public void setRoles(Integer roles) {
		this.roles = roles;
	}
	
}
