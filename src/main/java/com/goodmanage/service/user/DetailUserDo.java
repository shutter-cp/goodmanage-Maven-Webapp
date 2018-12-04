/**
 * chenPeng
 * com.goodmanage.service
 * DetailUserDo.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午2:26:40 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmanage.bean.Roles;
import com.goodmanage.bean.Users;
import com.goodmanage.dao.user.DetailUserDao;

/**
 * 
 * DetailUserDo
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午2:26:40 
 * @version 1.0.0
 * 
 */
@Service
public class DetailUserDo {
	@Autowired
	private DetailUserDao detailUserDao;

	/**
	 * 找到某个用户的信息
	 * 方法名：getUserMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午2:33:00 
	 * 手机:17673111810
	 * @param userName
	 * @return Users
	 * @exception 
	 * @since  1.0.0
	*/
	public Users getUserMsg(String userName) {
		// TODO Auto-generated method stub
		return detailUserDao.getUserMsg(userName);
	}
	
	
	
	/**
	 * 得到用户类型
	 * 方法名：getRolesList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午7:06:33 
	 * 手机:17673111810
	 * @return List<Roles>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Roles> getRolesList(){
		return detailUserDao.getRolesList();
	}
	
	
	/**
	 * 修改信息
	 * 方法名：upDate
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午3:49:40 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @param validateFlag
	 * @param roleType
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public void upDate(String username, String password, 
						Integer validateFlag, Integer roleType) {
		// TODO Auto-generated method stub
		
		Users user = new Users();
		user.setPwd(password);
		user.setRoles(roleType);
		user.setUserName(username);
		user.setValidateFlag(validateFlag);
		
		detailUserDao.upDate(user);
	}
	
	/**
	 * 启用与注销
	 * 方法名：upDo
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午4:27:52 
	 * 手机:17673111810
	 * @param username
	 * @param temp void
	 * @exception 
	 * @since  1.0.0
	*/
	public void upDo(String username, Integer temp) {
		// TODO Auto-generated method stub
		Users user = new Users();
		user.setUserName(username);
		user.setValidateFlag(temp==1? 0:1);
		
		detailUserDao.upDo(user);
	}
}
