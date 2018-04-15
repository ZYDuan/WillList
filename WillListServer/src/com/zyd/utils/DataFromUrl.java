/**
 * 
 */
package com.zyd.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import com.zyd.response.ProFromUrl;

/**
 * @author zyd
 * @date 2017年12月16日 下午6:21:40
 * @ClassName: DataFromUrl
 */
public class DataFromUrl {
	// 获得指定链接的商品信息
	public ProFromUrl getDataFromUrl(String url) throws IOException {
		ProFromUrl proFromUrl = new ProFromUrl();
		String urls = parseUrl(url);
		System.out.print(url+"\n"+urls);
		// 获得url的源代码
		String urlData = getUrl(urls);
		// 提取源代码中的商品信息
		String proData = getData(urlData);
		JSONObject jsonObject = new JSONObject(proData);

		String name = jsonObject.getString("title");
		String n =null;
		if(!jsonObject.has("priceL")) {
			proFromUrl.setPrice(0);
			n = name.substring(name.indexOf("（")+1, name.lastIndexOf("）"));
		}else{
			proFromUrl.setPrice(Integer.parseInt(jsonObject.getString("priceL")));
			n = name;
		}
		proFromUrl.setName(n);
		proFromUrl.setPic(jsonObject.getString("pic"));
		
		System.out.println(proFromUrl.getName()+proFromUrl.getPic()+"  "+proFromUrl.getPrice());
		return proFromUrl;
	}

	/**
	 * @param url
	 * @return
	 * 解析传递的字符串，获得含有商品信息的url
	 */
	private String parseUrl(String url) {
		Pattern pattern = Pattern.compile("http:\\/\\/([^/:]+)(:\\d*)?([^# ]*)");
		Matcher matcher = pattern.matcher(url);
		String urls = null;
		while(matcher.find()) {
			urls = matcher.group();
		}
		return urls;
	}

	// 获得页面源码
	public String getUrl(String proUrl) throws IOException {
		StringBuffer sb = new StringBuffer();
		URL url = new URL(proUrl);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		// 得到输入流获得网页的内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		// 读取输入流的数据
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	// 获得源代码中的商品信息数据
	public String getData(String urlData) {
		List<String> list = new ArrayList<>();
		Pattern pattern = Pattern.compile("(?=var extraData =).*?(?=;)");
		Matcher matcher = pattern.matcher(urlData);
		while (matcher.find()) {
			list.add(matcher.group());
		}
		return list.get(0).replaceAll("var extraData = ", "");
	}
}
