/**
 * 
 */
package com.zyd.serviceImpl;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zyd.mapper.UserMapper;
import com.zyd.mapper.UserinfoMapper;
import com.zyd.po.User;
import com.zyd.po.Userinfo;
import com.zyd.service.UserService;

/**
 * @author zyd
 * @date 2017年12月14日 上午12:30:29
 * @ClassName: UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserinfoMapper userInfoMapper;

	@Override
	public User findById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	// 登陆查询用户
	public User findByUser(User user) {
		return userMapper.selectByUser(user);
	}

	// 用户信息完善
	@Override
	public void updateUserInfo(Userinfo userInfo) {
		userInfoMapper.updateByPrimaryKey(userInfo);

	}

	// 用户注册
	@Override
	public void insertUser(User user) {
		userMapper.insert(user);
		Userinfo userinfo = new Userinfo();
		userinfo.setId(user.getId());
		userInfoMapper.insert(userinfo);
	}

	// 显示用户信息
	@Override
	public Userinfo findUserInfoById(int id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	// 重设用户密码
	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);

	}

}
