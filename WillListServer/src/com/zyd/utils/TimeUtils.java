/**
 * 
 */
package com.zyd.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

/**
 * @author zyd
 * @date 2017年12月16日 下午7:20:27 
 * @ClassName: TimeUtils 
 */
public class TimeUtils {

	/**
	 * @param startTime
	 * @return
	 */
	public static int getLeftTime(Date endTime) {
		
		long val =endTime.getTime() - (new Date()).getTime();  
		int day = (int) (val / (1000 * 60 * 60 * 24));  
		return day;
	}
	
	public static int getUsedTime(Date startTime) {
		long val =(new Date()).getTime() - startTime.getTime();
		int day = (int) (val / (1000 * 60 * 60 * 24)) + 1; 
		return day;
	}
	
}
