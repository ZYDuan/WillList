/**
 * 
 */
package com.zyd.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zyd
 * @date 2017年12月14日 上午12:56:30 
 * @ClassName: RequestCode 
 * 请求返回的
 */

public class ResponseData {
	private int code;
	private String message;
	private String data;
	
	public ResponseData() {
		
	}
	
	public ResponseData(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ResponseData(int code, String message, String data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

	
	
}
