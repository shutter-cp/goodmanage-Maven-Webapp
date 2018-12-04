/**
 * chenPeng
 * com.goodmanage.service
 * AddUserDo.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午6:23:53 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmanage.bean.Users;
import com.goodmanage.dao.user.AddUserDao;


/**
 * 
 * AddUserDo
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午6:23:53 
 * @version 1.0.0
 * 
 */
@Service
public class AddUserDo {
	@Autowired
	private AddUserDao addUserDao;
	
	/**
	 * 注册
	 * 方法名：addUser
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午7:43:10 
	 * 手机:17673111810
	 * @param userName
	 * @param roleType
	 * @param passWord void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addUser(String userName, Integer roleType, String passWord) {
		// TODO Auto-generated method stub
		Users user = new Users();
		user.setPwd(passWord);
		user.setUserName(userName);
		user.setRoles(roleType);
		
		addUserDao.addUser(user);
	}
	
}
