/**
 * chenPeng
 * com.goodmanage.dao.goods
 * GoodDao.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午8:38:37 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.dao.goods;

import java.util.List;

import com.goodmanage.bean.Fond;
import com.goodmanage.bean.Goods;
import com.goodmanage.bean.GoodsLi;
import com.goodmanage.bean.Goodstype;

/**
 * 商品
 * GoodDao
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午8:38:37 
 * @version 1.0.0
 * 
 */
public interface GoodDao {
	/**
	 * 查出全部的商品屬性
	 * 方法名：getGoodsTyep
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午8:48:30 
	 * 手机:17673111810
	 * @return List<Goodstype>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Goodstype> getGoodsTyep();

	/**
	 * 添加商品
	 * 方法名：addGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午9:20:21 
	 * 手机:17673111810
	 * @param goods void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addGoods(Goods goods);

	/**
	 * 查询出全部的商品
	 * 方法名：getGoodsList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午9:43:17 
	 * 手机:17673111810
	 * @return List<GoodsLi>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<GoodsLi> getGoodsList();

	/**
	 * 模糊查詢
	 * 方法名：fondGoodsList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午10:09:13 
	 * 手机:17673111810
	 * @param fond 
	 * @return List<GoodsLi>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<GoodsLi> fondGoodsList(Fond fond);
}
