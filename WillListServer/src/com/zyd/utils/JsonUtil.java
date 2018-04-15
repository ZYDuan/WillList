/**
 * 
 */
package com.zyd.utils;

import net.sf.json.JSONObject;

/**
 * @author zyd
 * @date 2017年12月17日 下午8:28:58 
 * @ClassName: JsonUtil 
 */
public class JsonUtil {
	public static String getJson(String key, Object value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}
}
