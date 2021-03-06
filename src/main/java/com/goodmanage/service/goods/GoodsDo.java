/**
 * chenPeng
 * com.goodmanage.service.goods
 * Goods.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午8:38:28 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmanage.bean.Fond;
import com.goodmanage.bean.Goods;
import com.goodmanage.bean.GoodsLi;
import com.goodmanage.bean.Goodstype;
import com.goodmanage.dao.goods.GoodDao;

/**
 * 
 * Goods
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午8:38:28 
 * @version 1.0.0
 * 
 */
@Service
public class GoodsDo {
	@Autowired
	private GoodDao goodDao;
		
	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getGoodsTyep
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午8:57:30 
	 * 手机:17673111810
	 * @return List<Goodstype>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Goodstype> getGoodsTyep() {
		// TODO Auto-generated method stub
		return goodDao.getGoodsTyep();
	}

	/**
	 * 添加商品
	 * 方法名：addGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午9:14:32 
	 * 手机:17673111810
	 * @param productName
	 * @param productPrice
	 * @param productNumber
	 * @param description
	 * @param goodsType void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addGoods(String productName, String productPrice,
								String productNumber, String description,
														Integer goodsType) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		goods.setGoodsCount(Integer.parseInt(productNumber));
		goods.setGoodsDep(description);
		goods.setGoodsName(productName);
		goods.setGoodsPrice(Double.valueOf(productPrice));
		goods.setGoodsType(goodsType);
		goodDao.addGoods(goods);
	}

	/**
	 * 得到商品
	 * 方法名：getGoodsList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午9:42:30 
	 * 手机:17673111810
	 * @return List<GoodsLi>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<GoodsLi> getGoodsList() {
		// TODO Auto-generated method stub
		return goodDao.getGoodsList();
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：fondGoodsList
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午10:07:40 
	 * 手机:17673111810
	 * @param productID
	 * @param productName
	 * @return List<GoodsLi>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<GoodsLi> fondGoodsList(String productID, String productName) {
		// TODO Auto-generated method stub
		String id;
		String name;
		
		if (productID=="") {
			id = "%";
		}else{
			id = productID+"";
		}
		
		if (productName=="") {
			name = "%";
		}else{
			name = "%"+productName+"%";
		}
		
		Fond fond = new Fond();
		fond.setId(id);
		fond.setName(name);
		return goodDao.fondGoodsList(fond);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午11:28:24 
	 * 手机:17673111810
	 * @param goodsid
	 * @return Goods
	 * @exception 
	 * @since  1.0.0
	*/
	public Goods getGoods(Integer goodsid) {
		// TODO Auto-generated method stub
		return goodDao.getGoods(goodsid);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：upDate
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午11:47:26 
	 * 手机:17673111810
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @param productCount
	 * @param productType
	 * @param productDep void
	 * @exception 
	 * @since  1.0.0
	*/
	public void upDate(Integer productId, String productName, Double productPrice, Integer productCount,
			Integer productType, String productDep) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		goods.setGoodsCount(productCount);
		goods.setGoodsDep(productDep);
		goods.setGoodsID(productId);
		goods.setGoodsName(productName);
		goods.setGoodsPrice(productPrice);
		goods.setGoodsType(productType);
		
		goodDao.upDate(goods);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：deletGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午11:56:48 
	 * 手机:17673111810
	 * @param goodsid void
	 * @exception 
	 * @since  1.0.0
	*/
	public void deletGoods(Integer goodsid) {
		// TODO Auto-generated method stub
		goodDao.deletGoods(goodsid);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addGoodsType
	 * 创建人：chenPeng
	 * 时间：2018年12月5日-上午12:08:12 
	 * 手机:17673111810
	 * @param typeID
	 * @param typeName
	 * @param typeDec void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addGoodsType(Integer typeID, String typeName, String typeDec) {
		// TODO Auto-generated method stub
		Goodstype goodstype = new Goodstype();
		goodstype.setId(typeID);
		goodstype.setTypedes(typeDec);
		goodstype.setTypename(typeName);
		
		goodDao.addGoodsType(goodstype);
	}

}
