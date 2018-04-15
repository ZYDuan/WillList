/**
 * 
 */
package com.zyd.service;

import java.util.List;

import com.zyd.po.Createinfo;
import com.zyd.po.Itemsinfo;
import com.zyd.request.UserWill;
import com.zyd.response.Product;
import com.zyd.response.ProductInfo;
import com.zyd.response.ProductInfoVo;

/**
 * @author zyd
 * @date 2017年12月14日 上午12:30:49 
 * @ClassName: WillListService 
 */
public interface WillListService {

	/**
	 * @param userid
	 * @return 
	 */
	List<Product> findByUserId(UserWill userWilling);

	/**
	 * @param id
	 * @return 
	 */
	ProductInfoVo findByItemId(Integer id);

	/**
	 * @param createinfo
	 */
	void insertCreateInfo(Createinfo createinfo);

	/**
	 * @param itemsinfo
	 */
	void insertItemsInfo(Itemsinfo itemsinfo);

	/**
	 * @param createinfo
	 * @return
	 */
	int findByCreate(Createinfo createinfo);

	/**
	 * @param id
	 */
	void deleteCreate(int id);

	/**
	 * @param id
	 * @return
	 */
	Itemsinfo findCreateIdByItemId(int id);

	/**
	 * @param itemsinfo
	 */
	void updateItems(Itemsinfo itemsinfo);

	

}
