/**
 * 
 */
package com.zyd.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import com.zyd.response.ProFromUrl;

/**
 * @author zyd
 * @date 2017年12月17日 下午11:32:17
 * @ClassName: urlTest
 */
public class urlTest {

	// 获得指定链接的商品信息
	public ProFromUrl getProduct(String url) throws IOException {
		ProFromUrl proFromUrl = new ProFromUrl();
		// 获得url的源代码
		String urlData = getUrl(url);
		// 提取源代码中的商品信息
		String proData = getData(urlData);
		JSONObject jsonObject = new JSONObject(proData);

		proFromUrl.setName(jsonObject.getString("title"));
		proFromUrl.setPrice(Integer.parseInt(jsonObject.getString("priceL")));
		proFromUrl.setPic(jsonObject.getString("pic"));

		return proFromUrl;
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
