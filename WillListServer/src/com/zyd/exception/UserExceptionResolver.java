/**
 * 
 */
package com.zyd.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zyd.utils.CodeUtil;

/**
 * @author zyd
 * @date 2017年12月14日 下午1:16:52 
 * @ClassName: UserExceptionResolver 
 */
public class UserExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception ex) {
		
		UserException userException = null;
		if(ex instanceof UserException) {
			userException = new UserException(ex.getMessage(),CodeUtil.ERROR);
		}else {
			userException = new UserException("未知错误", CodeUtil.ERROR);
		}
		
		response.setContentType("text/html;charset=utf-8");
		
		try {
			response.getWriter().append(userException.toString()).flush();
		} catch (IOException e) {
			System.out.println("与客户端通讯异常: "+ e.getMessage());  
			e.printStackTrace();
		};
		return null;
	}

}
