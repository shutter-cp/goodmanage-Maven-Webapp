/**
 * chenPeng
 * com.goodmanage.service
 * UserManager.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午1:58:06 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmanage.bean.Users;
import com.goodmanage.dao.user.UserManagerDao;

/**
 * 
 * UserManager
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午1:58:06 
 * @version 1.0.0
 * 
 */
@Service
public class UserManagerDo {
	@Autowired
	private UserManagerDao userManagerDao;
	
	/**
	 * 
	 * 得到全部的的用户信息
	 * 方法名：getUserList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午2:05:16 
	 * 手机:17673111810
	 * @return List<Users>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Users> getUserList(){
		return userManagerDao.getUserList();
	}
}
