/**
 * chenPeng
 * com.goodmanage.dao
 * UserManagerDao.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午1:58:42 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.dao.user;

import java.util.List;

import com.goodmanage.bean.Users;

/**
 * 
 * UserManagerDao
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午1:58:42 
 * @version 1.0.0
 * 
 */
public interface UserManagerDao {
	/**
	 * 
	 * 得到全部的用户
	 * 方法名：getUserList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午2:00:01 
	 * 手机:17673111810
	 * @return List<Users>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Users> getUserList();
}
