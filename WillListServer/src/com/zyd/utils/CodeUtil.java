/**
 * 
 */
package com.zyd.utils;

import javax.print.attribute.standard.Finishings;

/**
 * @author zyd
 * @date 2017年12月14日 上午12:56:52
 * @ClassName: CodeUtils
 */
public class CodeUtil {
	// 请求成功
	public static int SUCCESS = 200;

	// 请求参数不匹配
	public static int UNMAPPER = 400;

	// 请求用户名被占用
	public static int FORBIDDEN = 403;

	// 请求异常错误
	public static int ERROR = 500;

	// token时间过期
	public static int JWT_ERRCODE_EXPIRE = 701;

	// token验证失败
	public static int JWT_ERRCODE_FAIL = 702;

	// token验证成功
	public static int JWT_SUCCESS = 600;
	
	//跳转清单类型
	public static int WILL_DOING = 0;
	public static int WILL_FINISH = 1;
	public static int WILL_CANCEL = 3;
}

