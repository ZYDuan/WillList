/**
 * 
 */
package com.zyd.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * @author zyd
 * @date 2017年12月17日 下午8:54:56 
 * @ClassName: JsonRequset 
 */
public class JsonRequset {
	 //	请求报文的json数据
    public HashMap<String, Object> data;


    public HashMap<String, Object> getData() {
        return data;
    }
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    //	将请求报文封装成json数据流
    public String parseJson() throws JSONException{
        JSONObject jsonObject = new JSONObject();

         //获得data的key值集合
        Set set = data.keySet();
        Iterator<String> keys = set.iterator();
        while(keys.hasNext()) {
//            将hashmap的数据放进json对象中
        	String s = keys.next();
        jsonObject.put(s,data.get(s));
        }
        return jsonObject.toString();
    }

}
