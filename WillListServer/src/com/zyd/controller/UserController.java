/**
 * 
 */
package com.zyd.controller;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyd.exception.UserException;
import com.zyd.po.User;
import com.zyd.po.Userinfo;
import com.zyd.request.Password;
import com.zyd.response.ResponseData;
import com.zyd.service.UserService;
import com.zyd.utils.CodeUtil;
import com.zyd.utils.JWTUtil;
import com.zyd.utils.JsonUtil;

/**
 * @author zyd
 * @date 2017年12月14日 上午12:28:40
 * @ClassName: UserController
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	// 用户登陆
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseData login(@RequestBody User user) throws UserException {

		User user2 = userService.findByUser(user);
		if (user2 != null) {

			// 把用户信息生成token放进session
			// 设置token存活时间
			long livingTime = 1000 * 60 * 60 * 24 * 7;
			
			// 生成token并放于session中
			String sessionId = JWTUtil.createJWT(String.valueOf(user2.getId()), "WillList", livingTime);

			HashMap <String,String> loginMsg = new HashMap<>();
			loginMsg.put("sessionId", sessionId);
			loginMsg.put("userId", String.valueOf(user2.getId()));
			// 返回登陆成功的报文并将生成的t
			return new ResponseData(CodeUtil.SUCCESS, "登陆成功！", JsonUtil.getJson("loginMsg", loginMsg));
		} else {
			// 返回登陆失败的报文
			throw new UserException("密码错误", CodeUtil.ERROR);
		}
		
	}

	// 用户注册
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseData register(@RequestBody User user) {
		if (userService.findByUser(user) != null) {
			return new ResponseData(CodeUtil.FORBIDDEN, "用户名已被注册！");
		} else {
			userService.insertUser(user);
			return new ResponseData(CodeUtil.SUCCESS, "注册成功");
		}
	}

	// 跳转到用户显示界面
	@ResponseBody
	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
	public ResponseData userInformation(@RequestBody Userinfo userinfo) {
		Userinfo userInfo = userService.findUserInfoById(userinfo.getId());
		ResponseData responseData = new ResponseData(CodeUtil.SUCCESS, "跳转成功");
		if (userInfo != null) {
			responseData.setData(JsonUtil.getJson("userInfo", userInfo));
		}
		return responseData;
	}

	// 用户更新个人信息
	@ResponseBody
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public ResponseData updateUserInfo(@RequestBody Userinfo userInfo) {
		userService.updateUserInfo(userInfo);
		return new ResponseData(CodeUtil.SUCCESS, "更新成功");
	}

	// 重设密码
	@ResponseBody
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ResponseData resetPassword(@RequestBody Password password) {
		User user = new User();
		user.setPassword(password.getOldPassword());
		System.out.println(user.getPassword());
		user.setId(password.getId());
		User users = userService.findByUser(user);
		if (users != null) {
			users.setPassword(password.getNewPassword());
			userService.updateUser(users);
			return new ResponseData(CodeUtil.SUCCESS, "修改密码成功");
		} else {
			return new ResponseData(CodeUtil.ERROR, "旧密码输入错误");
		}
	}
}
