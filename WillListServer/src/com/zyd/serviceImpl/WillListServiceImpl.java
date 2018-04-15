package com.zyd.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zyd.mapper.CreateinfoMapper;
import com.zyd.mapper.ItemsinfoMapper;
import com.zyd.po.Createinfo;
import com.zyd.po.CreateinfoExample;
import com.zyd.po.Itemsinfo;
import com.zyd.request.UserWill;
import com.zyd.response.Product;
import com.zyd.response.ProductInfo;
import com.zyd.response.ProductInfoVo;
import com.zyd.service.WillListService;
import com.zyd.utils.CodeUtil;
import com.zyd.utils.TimeUtils;

/**
 * @author zyd
 * @date 2017年12月14日 上午12:31:32 
 * @ClassName: WillListServiceImpl 
 */
@Service
public class WillListServiceImpl implements WillListService {

	@Autowired
	private ItemsinfoMapper itemsinfoMapper;
	
	@Autowired
	private CreateinfoMapper createinfoMapper;
	
//	获得用户的愿望商品
	@Override
	public List<Product> findByUserId(UserWill userWilling) {
		List<Product> list = itemsinfoMapper.selectByIdAndType(userWilling);
		for(Product product : list) {
			int leftTime = TimeUtils.getLeftTime(product.getEndTime());
//			若完成时间已到，标识该愿望清单已完成
			if(leftTime <= 0) {
				Itemsinfo itemsInfo = itemsinfoMapper.selectByPrimaryKey(product.getId());
				itemsInfo.setType(CodeUtil.WILL_FINISH);
				product.setType(CodeUtil.WILL_FINISH);
				itemsinfoMapper.updateByPrimaryKey(itemsInfo);
			}
			product.setLeftTime(leftTime);
		}
		return list;
		
	}

	
//	显示愿望商品的信息
	@Override
	public ProductInfoVo findByItemId(Integer id) {
		ProductInfoVo productInfo = itemsinfoMapper.selectById(id);
		
		int leftTime = TimeUtils.getLeftTime(productInfo.getEndTime());
		int usedTime = TimeUtils.getUsedTime(productInfo.getStartTime());
		float usedMoney = productInfo.getMoneyDay() * usedTime;
		
		productInfo.setLeftTime(leftTime);
		productInfo.setUsedTime(usedTime);
		productInfo.setUsedMoney(usedMoney);
		return productInfo;
	}


//	创建愿望清单
	@Override
	public void insertCreateInfo(Createinfo createinfo) {
		createinfoMapper.insert(createinfo);
		
	}

//	创建愿望清单商品信息
	@Override
	public void insertItemsInfo(Itemsinfo itemsinfo) {
		itemsinfoMapper.insert(itemsinfo);
		
	}

	@Override
	public int findByCreate(Createinfo createinfo) {
		return createinfoMapper.selectByCreate(createinfo);
	}



	@Override
	public void deleteCreate(int id) {
		createinfoMapper.deleteByPrimaryKey(id);
		
	}


	
	@Override
	public Itemsinfo findCreateIdByItemId(int id) {
		
		return itemsinfoMapper.selectByPrimaryKey(id);
	}


	
	@Override
	public void updateItems(Itemsinfo itemsinfo) {
		itemsinfoMapper.updateByPrimaryKey(itemsinfo);
		
	}



}
