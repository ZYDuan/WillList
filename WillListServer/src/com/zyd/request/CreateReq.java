/**
 * 
 */
package com.zyd.request;

import com.zyd.po.Createinfo;
import com.zyd.po.Itemsinfo;

/**
 * @author zyd
 * @date 2017年12月22日 上午10:51:44 
 * @ClassName: CreateReq 
 */
public class CreateReq {
	private Createinfo createinfo;
	private Itemsinfo itemsinfo;
	public Createinfo getCreateinfo() {
		return createinfo;
	}
	public void setCreateinfo(Createinfo createinfo) {
		this.createinfo = createinfo;
	}
	public Itemsinfo getItemsinfo() {
		return itemsinfo;
	}
	public void setItemsinfo(Itemsinfo itemsinfo) {
		this.itemsinfo = itemsinfo;
	}
	
	
	
}
