/**
 * chenPeng
 * com.goodmanage.web
 * DetailUser.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午2:26:28 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.web.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.goodmanage.bean.Roles;
import com.goodmanage.bean.Users;
import com.goodmanage.service.user.DetailUserDo;

/**
 * 
 * DetailUser
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午2:26:28 
 * @version 1.0.0
 * 
 */
@Controller
public class DetailUser {
	@Autowired
	private DetailUserDo detailUserDo;
	
	/**
	 * 
	 * 找到某个用户的 信息
	 * 方法名：initUserMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午2:34:03 
	 * 手机:17673111810
	 * @param userName
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/userManager/detailUser")
	public ModelAndView initUserMsg(String userName){
		ModelAndView andView = new ModelAndView();
		
		Users user = detailUserDo.getUserMsg(userName);
		
		andView.addObject("user", user);
		andView.setViewName("content/userManager/detailUser");
		return andView;
	}
	
	
	/**
	 * 
	 * 修改数据
	 * 方法名：upDataMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午2:47:47 
	 * 手机:17673111810
	 * @param userName
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/userManager/updataUser")
	public ModelAndView initUpDataMsg(String userName){
		ModelAndView andView = new ModelAndView();
		
		Users user = detailUserDo.getUserMsg(userName);
		Integer roId = user.getRoles();
		//拿到全部的用户类型
		List<Roles> rolseList = detailUserDo.getRolesList();
		Roles temp = new Roles();
		int i = 0;
		for (Roles roles : rolseList) {
			if (roles.getId()==roId) {
				temp = rolseList.get(0);
				rolseList.set(0, roles);
				rolseList.set(i,temp);
				roles.getId();
			}
			i++;
		}
		
		andView.addObject("user", user);
		andView.addObject("rolseList", rolseList);
		andView.setViewName("/content/userManager/updataUser");
		return andView;
	}
	
	/**
	 * 
	 * 修改
	 * 方法名：upData
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午3:25:32 
	 * 手机:17673111810
	 * @return Stirng
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,
			value="/content/userManager/updataUserDo",
				produces = "application/String; charset=utf-8")
	@ResponseBody
	public String upData(HttpServletRequest re){
		String username = re.getParameter("username");
		String password = re.getParameter("password");
		Integer validateFlag = Integer.parseInt(re.getParameter("validateFlag"));
		Integer roleType = Integer.parseInt(re.getParameter("roleType"));
		
		detailUserDo.upDate(username,password,validateFlag,roleType);
		
		return "sccess";
	}
	
	/**
	 * 
	 * 修改状态
	 * 方法名：upDo
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午4:21:02 
	 * 手机:17673111810
	 * @param re
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,
			value="/content/userManager/upDo",
				produces = "application/String; charset=utf-8")
	@ResponseBody
	public String upDo(HttpServletRequest re){
		String username = re.getParameter("username");
		Integer temp = Integer.parseInt(re.getParameter("temp"));
		detailUserDo.upDo(username,temp);
		return "sccess";
	}
}
