/**
 * chenPeng
 * com.goodmanage.web
 * Test.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-上午11:14:23 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.goodmanage.bean.Users;
import com.goodmanage.dao.TestDao;

/**
 * 
 * Test
 * 创建人:chenPeng
 * 时间：2018年12月4日-上午11:14:23 
 * @version 1.0.0
 * 
 */
@RestController
public class Test {
	@Autowired
	private TestDao testDao;
	
	@GetMapping("/test")
	public ModelAndView myTest(){
		ModelAndView andView =new ModelAndView();
		System.out.println(1111);
		List<Users> userList = testDao.test();
		for (Users users : userList) {
			System.out.println(users.getUserName());
		}
		return andView;
	}
}
