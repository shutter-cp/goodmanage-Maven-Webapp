/**
 * chenPeng
 * com.goodmanage.service
 * LoginDo.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午1:16:16 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmanage.bean.Users;
import com.goodmanage.dao.user.LoginDao;

/**
 * 登陆
 * LoginDo
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午1:16:16 
 * @version 1.0.0
 * 
 */
@Service
public class LoginDo {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 登陆
	 * 方法名：loginDo
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午1:43:53 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean loginDo(String username, String password){
		Users users = new Users();
		users.setUserName(username);
		users.setPwd(password);
		
		List<Users> userList = loginDao.login(users);
		if (userList.size()==0) {
			re.getSession().setAttribute("errorMsg", "登陆失败！请检查用户名与密码");
			return false;
		}
		
		re.getSession().setAttribute("user", userList.get(0));
		
		return true;
	}
}
