/**
 * 
 */
package com.zyd.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author zyd
 * @date 2017年12月17日 下午9:49:45
 * @ClassName: JsonResponse
 */
public class JsonResponse {
	// 返回报文的状态码
		private int code;
		// 返回报文的信息
		private String message;
		// 返回报文的数据
		private JSONObject data;

		public JsonResponse(String response) {
			JSONObject jsonObject = new JSONObject(response);
			code = Integer.parseInt((String) jsonObject.get("code"));
			message = jsonObject.getString("message");
			data = jsonObject.getJSONObject("data");
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public JSONObject getData() {
			return data;
		}

		public JSONObject getObject(String className) {
			return data.getJSONObject(className);
		}

		// 返回报文中某个对象的属性
		public String getParameter(String className, String key) {
			return data.getJSONObject(className).getString(key);
		}

		// 返回报文中的list数据流
		public List<HashMap<String, String>> getList(String listName) {
			List<HashMap<String, String>> list = new ArrayList();
			JSONArray array = data.getJSONArray(listName);

			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = array.getJSONObject(i);
				HashMap<String, String> map = new HashMap<>();

				Iterator<?> it = jsonObject.keys();
				while (it.hasNext()) {
					String key = it.next().toString();
					Object value = jsonObject.opt(key);
					map.put(key, value.toString());
				}

				list.add(map);
			}
			return list;
		}
}
