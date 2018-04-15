/**
 * 
 */
package com.zyd.request;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.zyd.response.ResponseData;

import net.sf.json.JSONObject;
import sun.launcher.resources.launcher;

/**
 * @author zyd
 * @date 2017年12月17日 下午12:16:06 
 * @ClassName: RequestData 
 */
public class RequestData {
	private JSONObject param;
	private ArrayList<JSONObject> paramList;
	public JSONObject getParam() {
		return param;
	}

	public void setParam(JSONObject param) {
		this.param = param;
		ResponseData res = new ResponseData();
		ResponseData res1 = new ResponseData();
		param.put("Res", res);
		param.put("Res1", res1);
		System.out.println(param.toString());
	}
	
	@Test
	public void test() {
		JSONObject jsonObject = new JSONObject();
		setParam(jsonObject);
	}
	
}
