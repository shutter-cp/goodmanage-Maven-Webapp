/**
 * chenPeng
 * com.goodmanage.bean
 * Roles.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-上午11:06:51 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.bean;

/**
 * 
 * Roles
 * 创建人:chenPeng
 * 时间：2018年12月4日-上午11:06:51 
 * @version 1.0.0
 * 
 */
public class Roles {
	private Integer id;
	private String roleName;
	private String roleDesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
