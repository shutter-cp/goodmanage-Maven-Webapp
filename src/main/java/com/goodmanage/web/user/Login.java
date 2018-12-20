/**
 * chenPeng
 * com.goodmanage.web
 * Login.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午12:57:28 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goodmanage.service.user.LoginDo;

/**
 * 登陆
 * Login
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午12:57:28 
 * @version 1.0.0
 * 
 */
@Controller
public class Login {
	@Autowired
	private LoginDo loginDo;
	
	/**
	 * 登陆
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午1:43:32 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("login")
	public ModelAndView login(String username,
									String password){
		
		ModelAndView andView = new ModelAndView();
		
		boolean temp = loginDo.loginDo(username,password);
		if (temp) {
			return new ModelAndView("redirect:/main");
		}else{
			andView.addObject("errorMsgs", "用户名或密码错误");
			andView.setViewName("index");
			return andView;
		}
	}
	
	@GetMapping("/main")
	public ModelAndView initMain(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("main");
		return andView;
	}
	
}
