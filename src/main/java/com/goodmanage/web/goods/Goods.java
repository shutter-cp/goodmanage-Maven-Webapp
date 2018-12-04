/**
 * chenPeng
 * com.goodmanage.web.goods
 * AddGoods.java
 * 创建人:chenpeng
 * 时间：2018年12月4日-下午8:37:41 
 * 2018陈鹏-版权所有
 */
package com.goodmanage.web.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.goodmanage.bean.GoodsLi;
import com.goodmanage.bean.Goodstype;
import com.goodmanage.service.goods.GoodsDo;

import net.sf.json.JSONArray;

/**
 * 
 * AddGoods
 * 创建人:chenPeng
 * 时间：2018年12月4日-下午8:37:41 
 * @version 1.0.0
 * 
 */
@Controller
public class Goods {
	@Autowired
	private GoodsDo goodsDo;
	
	/**
	 * 
	 * 初始化增加商品
	 * 方法名：initAddGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午9:04:06 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/goodsManager/addGoods")
	public ModelAndView initAddGoods(){
		ModelAndView andView = new ModelAndView();
		
		List<Goodstype> goodsTyepList = goodsDo.getGoodsTyep();
		
		andView.addObject("goodsTyepList",goodsTyepList );
		andView.setViewName("content/goodsManager/addGoods");
		return andView;
	}
	
	/**
	 * 
	 * 执行添加商品
	 * 方法名：addGodds
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午9:14:10 
	 * 手机:17673111810
	 * @param ProductName
	 * @param productPrice
	 * @param productNumber
	 * @param description
	 * @param goodsType
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/content/goodsManager/addGoodsDo")
	public ModelAndView addGodds(
				String ProductName,
				String productPrice,
				String productNumber,
				String description,
			    Integer goodsType
			){
		goodsDo.addGoods(ProductName,productPrice,productNumber,description,goodsType);
		return new ModelAndView("redirect:/content/goodsManager/searchGoods");
	}
	
	
	/**
	 * 
	 * 初始化商品查询页面
	 * 方法名：searchGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午9:29:53 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/goodsManager/searchGoods")
	public ModelAndView searchGoods(){
		ModelAndView andView = new ModelAndView();
		
		List<GoodsLi> goodsList = goodsDo.getGoodsList();
		
		andView.addObject("goodsList", goodsList);
		andView.setViewName("content/goodsManager/searchGoods");
		return andView;
	}
	
	/**
	 * 
	 * 查询功能
	 * 方法名：fondGoodsMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午10:00:03 
	 * 手机:17673111810
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method = RequestMethod.POST, 
			value = "/content/goodsManager/searchGoods/fond", 
				produces = "application/String; charset=utf-8")
	@ResponseBody
	public String fondGoodsMsg(HttpServletRequest re) {
		JSONArray jsonArray = new JSONArray();
		String productID =  re.getParameter("productID");
		String productName = re.getParameter("productName");
		//拿到信息列表
		List<GoodsLi> goodsList = goodsDo.fondGoodsList(productID,productName);
		
		for (GoodsLi goodsLi : goodsList) {
			System.out.println(goodsLi.getGoodsName());
			jsonArray.add(goodsLi);
		}
		
		return jsonArray.toString();
	}
	
	/**
	 * 修改商品
	 * 方法名：initUpDateGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午11:02:29 
	 * 手机:17673111810
	 * @param goodsid
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/goodsManager/update")
	public ModelAndView initUpDateGoods(String goodsid){
		ModelAndView andView = new ModelAndView();
		System.out.println(goodsid);
		Goods goods = goodsDo.getGoods(goodsid);
		andView.setViewName("content/goodsManager/updateGoods");
		return andView;
	}
	
	/**
	 * 刪除商品
	 * 方法名：initDeleteGoods
	 * 创建人：chenPeng
	 * 时间：2018年12月4日-下午11:02:43 
	 * 手机:17673111810
	 * @param goodsid
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/content/goodsManager/delete")
	public ModelAndView initDeleteGoods(String goodsid){
		ModelAndView andView = new ModelAndView();
		System.out.println(goodsid);
		return andView;
	}
}
