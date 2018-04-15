package com.zyd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyd.po.Createinfo;
import com.zyd.po.Itemsinfo;
import com.zyd.request.CreateReq;
import com.zyd.request.UserWill;
import com.zyd.response.ProFromUrl;
import com.zyd.response.Product;
import com.zyd.response.ProductInfo;
import com.zyd.response.ProductInfoVo;
import com.zyd.response.ResponseData;
import com.zyd.service.WillListService;
import com.zyd.utils.CodeUtil;
import com.zyd.utils.DataFromUrl;
import com.zyd.utils.JsonUtil;

import net.sf.json.JSONObject;
import sun.nio.fs.MacOSXFileSystemProvider;

/**
 * @author zyd
 * @date 2017年12月14日 上午12:29:02 
 * @ClassName: WillListController 
 */
@Controller
@RequestMapping("/willList")
public class WillListController {
	@Autowired
	@Qualifier("willListServiceImpl")
	private WillListService willListService;
	
	
//	跳转到各个类型的愿望清单列表
	@ResponseBody
	@RequestMapping("/willListInfo")
	public ResponseData willListInfo(@RequestBody UserWill items) {
		List<Product> list= willListService.findByUserId(items);
		String listJson = JsonUtil.getJson("product", list);
		return new ResponseData(CodeUtil.SUCCESS, "跳转成功", listJson);
	}
	
	@ResponseBody
	@RequestMapping("/deleteItem")
	public ResponseData deleteItem(@RequestBody Map<String, Integer>id) {
		
		Itemsinfo itemsinfo = willListService.findCreateIdByItemId(id.get("id"));
		itemsinfo.setType(CodeUtil.WILL_CANCEL);
		willListService.updateItems(itemsinfo);
		return new ResponseData(CodeUtil.SUCCESS, "删除成功");
	}
//	显示愿望清单信息
	@ResponseBody
	@RequestMapping("/willItemInfo")
	public ResponseData willTtemInfo(@RequestBody Itemsinfo itemsinfo) {
		ProductInfoVo productInfoVo = willListService.findByItemId(itemsinfo.getId());
		String productJson = JsonUtil.getJson("productInfoVo", productInfoVo);
		return new ResponseData(CodeUtil.SUCCESS, "获得商品信息成功", productJson);
	}
	
//	输入url创建清单
	@ResponseBody
	@RequestMapping("/urlProCreate")
	public ResponseData urlProCreate(@RequestBody Map<String, String> url) throws IOException {
		DataFromUrl dataFromUrl = new DataFromUrl();
		ProFromUrl proFromUrl = dataFromUrl.getDataFromUrl(url.get("url"));
		String proUrlJson = JsonUtil.getJson("proFromUrl", proFromUrl);
		return new ResponseData(CodeUtil.SUCCESS, "获取链接信息成功", proUrlJson);
	}
	
//	手动添加信息创建清单
	@ResponseBody
	@RequestMapping("/createWillItems")
	public ResponseData createWillItems(@RequestBody CreateReq createReq) {
		Createinfo createinfo = createReq.getCreateinfo();
		Itemsinfo itemsinfo = createReq.getItemsinfo();
		
		willListService.insertCreateInfo(createinfo);
		int createid = willListService.findByCreate(createinfo);
		
		itemsinfo.setCreateid(createid);
		itemsinfo.setType(CodeUtil.WILL_DOING);
		willListService.insertItemsInfo(itemsinfo);
		
		return new ResponseData(CodeUtil.SUCCESS, "创建成功");
	}
}
