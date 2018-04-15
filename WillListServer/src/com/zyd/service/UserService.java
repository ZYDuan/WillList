/**
 * 
 */
package com.zyd.service;

import org.springframework.stereotype.Service;

import com.zyd.po.User;
import com.zyd.po.Userinfo;

/**
 * @author zyd
 * @date 2017年12月14日 上午12:30:05 
 * @ClassName: UserService 
 */
public interface UserService {

	/**
	 * @param id
	 * 用户根据id查询
	 */
	User findById(Integer id);

	/**
	 * @param user
	 * 查询是否存在该用户
	 */
	User findByUser(User user);

	/**
	 * @param userInfo
	 * 更新用户信息
	 */
	void updateUserInfo(Userinfo userInfo);

	/**
	 * @param user
	 * 注册新的用户
	 */
	void insertUser(User user);

	/**
	 * @param id
	 * 查询用户信息
	 */
	Userinfo findUserInfoById(int id);

	/**
	 * @param user
	 */
	void updateUser(User user);

	
}
