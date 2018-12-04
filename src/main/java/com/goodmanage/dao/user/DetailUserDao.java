/**
 * chenPeng
 * com.goodmanage.dao
 * DetailUserDao.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午2:26:49 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.dao.user;

import java.util.List;

import com.goodmanage.bean.Roles;
import com.goodmanage.bean.Users;

/**
 * 
 * DetailUserDao
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午2:26:49 
 * @version 1.0.0
 * 
 */
public interface DetailUserDao {

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getUserMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午2:39:15 
	 * 手机:17673111810
	 * @param userName
	 * @return Users
	 * @exception 
	 * @since  1.0.0
	*/
	public Users getUserMsg(String userName);

	/**
	 * 修改数据
	 * 方法名：upDate
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午3:51:14 
	 * 手机:17673111810
	 * @param user
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public void upDate(Users user);

	/**
	 * 启用与注销
	 * 方法名：upDo
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午4:31:28 
	 * 手机:17673111810
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	*/
	public void upDo(Users user);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getRolesList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午7:07:38 
	 * 手机:17673111810
	 * @return List<Roles>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Roles> getRolesList();
	
}
