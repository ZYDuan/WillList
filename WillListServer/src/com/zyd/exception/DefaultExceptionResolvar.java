/**
 * 
 */
package com.zyd.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zyd.response.ResponseData;
import com.zyd.utils.CodeUtil;

/**
 * @author zyd
 * @date 2017年12月14日 下午1:34:30 
 * @ClassName: DefaultExceptionResolvar 
 */
public class DefaultExceptionResolvar implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType  
		response.setContentType("text/html;charset=utf-8");
		
		ResponseData res = new ResponseData(CodeUtil.ERROR, ex.getMessage());
		try {
			response.getWriter().append(res.toString()).flush();
		} catch (IOException e) {
			System.out.println("与客户端通讯异常: "+ e.getMessage());  
		};
		return null;
	}

}
