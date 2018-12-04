/**
 * chenPeng
 * com.goodmanage.web
 * UserManager.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午1:47:20 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.web.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goodmanage.bean.Users;
import com.goodmanage.service.user.UserManagerDo;

/**
 * 查询出全部的用不
 * UserManager
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午1:47:20 
 * @version 1.0.0
 * 
 */
@Controller
public class UserManager {
	@Autowired
	private UserManagerDo userManagerDo;
	
	/**
	 * 得到全部的用户信息
	 * 方法名：initManager
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午2:07:35 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/userManager/userManager")
	public ModelAndView initManager(){
		ModelAndView andView = new ModelAndView();
		
		List<Users> userList = userManagerDo.getUserList();
		
		andView.addObject("userList", userList);
		andView.setViewName("content/userManager/userManager");
		return andView;
	}
}
