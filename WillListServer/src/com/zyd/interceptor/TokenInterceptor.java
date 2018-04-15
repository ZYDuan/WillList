/**
 * 
 */
package com.zyd.interceptor;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.zyd.response.ResponseData;
import com.zyd.utils.CheckResult;
import com.zyd.utils.CodeUtil;
import com.zyd.utils.JWTUtil;



/**
 * @author zyd
 * @date 2017年12月14日 上午12:40:13
 * @ClassName: TokenInterceptor 验证是否已经登陆
 */

public class TokenInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if (url.indexOf("login") >= 0 || url.indexOf("register") >= 0) {
			return true;
		}
		response.setContentType("text/html;charset=utf-8");

		
		String token = request.getHeader("token");
		System.out.println(token);
		// 发送请求无token
		if (token.equals("") || token.equals("null")) {
			ResponseData responseData = new ResponseData(CodeUtil.ERROR, "身份验证失败");
			String res = (net.sf.json.JSONObject.fromObject(responseData)).toString();
			response.getWriter().append(res).flush();
			return false;
		}

		// 验证token
		CheckResult checkResult = JWTUtil.verifyJWT(token);
		
		int code = checkResult.getCheckCode();
		if (code == CodeUtil.JWT_SUCCESS) {
			return true;
		} else if (code == CodeUtil.JWT_ERRCODE_EXPIRE || code == CodeUtil.JWT_ERRCODE_FAIL) {
			ResponseData responseData = new ResponseData(CodeUtil.ERROR, "身份验证失败");
			String res = (net.sf.json.JSONObject.fromObject(responseData)).toString();
			response.getWriter().append(res).flush();
			return false;
		}

		return false;
	}

}
