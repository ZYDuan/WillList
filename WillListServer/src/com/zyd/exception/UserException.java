/**
 * 
 */
package com.zyd.exception;

/**
 * @author zyd
 * @date 2017年12月14日 下午1:14:28 
 * @ClassName: UserException 
 */
public class UserException extends Exception {
	private String message;
	private int code;
	
	public UserException(String message,int code) {
		super(message);
		this.message = message;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "{\"message\":\"" + message + "\",\"code\":\"" + code + "\"}  ";
	}
	
}
