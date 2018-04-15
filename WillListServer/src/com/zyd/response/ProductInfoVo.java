/**
 * 
 */
package com.zyd.response;

import java.util.Date;

/**
 * @author zyd
 * @date 2017年12月16日 下午2:18:23 
 * @ClassName: ProductInfoVo 
 */
public class ProductInfoVo extends ProductInfo{
	private int usedTime;
	private int leftTime;
	private float usedMoney;
	
	
	public float getUsedMoney() {
		return usedMoney;
	}
	public void setUsedMoney(float usedMoney) {
		this.usedMoney = usedMoney;
	}
	public int getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(int usedTime) {
		
//		int usedTime = getStartTime();
		
		this.usedTime = usedTime;
	}
	public int getLeftTime() {
		return leftTime;
	}
	public void setLeftTime(int leftTime) {
		this.leftTime = leftTime;
	}
	
	
	
	
}
