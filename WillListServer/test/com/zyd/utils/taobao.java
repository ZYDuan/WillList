/**
 * 
 */
package com.zyd.utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.zyd.response.ProFromUrl;

/**
 * @author zyd
 * @date 2017年12月20日 上午10:25:53 
 * @ClassName: taobao 
 */
public class taobao {
	
	@Test
	public void testTaobao() throws IOException{
		DataFromUrl dataFromUrl = new DataFromUrl();
		dataFromUrl.getDataFromUrl
		("【我剁手都要买的宝贝（加绒休闲裤运动裤韩版潮流2017新款小脚秋冬款男士修身裤子男冬季），快来和我一起瓜分红I包】http://m.tb.cn/h.BKHOL6 点击链接，再选择浏览器打开；或复制这条信息￥JkIm0jNdHj2￥后打开👉手淘👈");
		
	}
}
