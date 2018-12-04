/**
 * chenPeng
 * com.goodmanage.web
 * AddUser.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午6:23:44 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goodmanage.bean.Roles;
import com.goodmanage.service.user.AddUserDo;
import com.goodmanage.service.user.DetailUserDo;

/**
 * 
 * AddUser
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午6:23:44 
 * @version 1.0.0
 * 
 */
@Controller
public class AddUser {
	@Autowired
	private AddUserDo addUserDo;
	@Autowired
	private DetailUserDo detailUserDo;
	
	/**
	 * 初始化注册用户
	 * 方法名：initAddUser
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午7:39:49 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/userManager/addUser")
	public ModelAndView initAddUser(){
		ModelAndView andView = new ModelAndView();
		
		List<Roles> rolseList = detailUserDo.getRolesList();
		
		andView.addObject("rolseList", rolseList);
		andView.setViewName("content/userManager/addUser");
		return andView;
	}
	
	
	/**
	 * 注册用户
	 * 方法名：addUser
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午7:40:14 
	 * 手机:17673111810
	 * @param userName
	 * @param roleType
	 * @param passWord
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/content/userManager/addUser")
	public ModelAndView addUser(String userName,Integer roleType,String passWord){
		addUserDo.addUser(userName,roleType,passWord);
		
		return new ModelAndView("redirect:/content/userManager/userManager");
	}
}
