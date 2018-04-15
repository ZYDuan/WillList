/**
 * 
 */
package com.zyd.request;

/**
 * @author zyd
 * @date 2017年12月15日 上午12:18:06 
 * @ClassName: Password 
 */
public class Password {
	private Integer id;
	private String oldPassword;
	private String newPassword;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
