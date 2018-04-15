/**
 * 
 */
package com.zyd.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.zyd.po.User;
import com.zyd.po.Userinfo;

/**
 * @author zyd
 * @date 2017年12月17日 下午9:13:23 
 * @ClassName: jsonTest 
 */
public class jsonTest {

	@Test
	public void requestTest() {
		JsonRequset jsonRequset = new JsonRequset();
		List<String> key = new ArrayList();
		HashMap<String, Object> data = new HashMap<>();
		
		List<User> user = new ArrayList<User>();
		for(int i = 0;i<2;i++) {
			User e =new User();
			e.setId(i);
			user.add(e);
		}
		
		List<Userinfo> userinfos = new ArrayList<>();
		for(int i = 0;i<2;i++) {
			Userinfo e =new Userinfo();
			e.setId(i);
			userinfos.add(e);
		}
		data.put("user","123");
		data.put("userInfo", "23");
		
		jsonRequset.setData(data);
		
		System.out.println(jsonRequset.parseJson());
	}

	@Test
	public void responseTest() {
		String response = "{\"code\": \"200\",\"message\": \"登陆成功！\", \"data\": \"\"}";
		JsonResponse jsonRequset = new JsonResponse(response);
		System.out.println(jsonRequset.getParameter("sessionId", "endTime"));
	}
	
}
