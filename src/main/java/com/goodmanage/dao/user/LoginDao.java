/**
 * chenPeng
 * com.goodmanage.dao
 * LoginDao.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午1:16:29 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.dao.user;

import java.util.List;

import com.goodmanage.bean.Users;

/**
 * 登陆
 * LoginDao
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午1:16:29 
 * @version 1.0.0
 * 
 */
public interface LoginDao {

	/**
	 * 登陆
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午1:30:10 
	 * 手机:17673111810
	 * @param users void
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Users> login(Users users);

}
