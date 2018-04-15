/**
 * 
 */
package com.zyd.utils;

import io.jsonwebtoken.Claims;

/**
 * @author zyd
 * @date 2017年12月14日 下午4:39:29 
 * @ClassName: CheckResult 
 */
public class CheckResult {
	private int checkCode;
	private Claims chaims;
	
	public int getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(int checkCode) {
		this.checkCode = checkCode;
	}

	public Claims getChaims() {
		return chaims;
	}

	public void setChaims(Claims chaims) {
		this.chaims = chaims;
	}
	
	
}
