/**
 * 
 */
package com.zyd.response;

import java.util.Date;


/**
 * @author zyd
 * @date 2017年12月15日 下午6:16:06 
 * @ClassName: ProductInfo 
 * 用于接收前端返回的创建愿望清单的信息
 * 
 */
public class ProductInfo extends ProFromUrl{
	
	private Date startTime;
	private Date endTime;
	private float moneyDay;
	private int leftTime;
	private int usedTime;
	private float usedMoney;
	
	
	
	public int getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(int usedTime) {
		this.usedTime = usedTime;
	}
	public float getUsedMoney() {
		return usedMoney;
	}
	public void setUsedMoney(float usedMoney) {
		this.usedMoney = usedMoney;
	}
	public int getLeftTime() {
		return leftTime;
	}
	public void setLeftTime(int leftTime) {
		this.leftTime = leftTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public float getMoneyDay() {
		return moneyDay;
	}
	public void setMoneyDay(float moneyDay) {
		this.moneyDay = moneyDay;
	}
	
	
	
	
	
	
	
	
}
