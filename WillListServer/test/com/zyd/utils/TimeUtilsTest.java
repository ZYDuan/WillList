/**
 * 
 */
package com.zyd.utils;

import static org.junit.Assert.*;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * @author zyd
 * @date 2017年12月16日 下午7:46:23 
 * @ClassName: TimeUtilsTest 
 */
public class TimeUtilsTest {

	/**
	 * Test method for {@link com.zyd.utils.TimeUtils#getLeftTime(java.util.Date, java.util.Date)}.
	 * 测试得到剩余时间
	 */
	@Test
	public void testGetLeftTime() {
		Calendar c = new GregorianCalendar(2017,12,12);  
		Date date=c.getTime(); 
		 int t = TimeUtils.getLeftTime(date);
		 System.out.println(t+"   sadad  ");
	}

	/**
	 * Test method for {@link com.zyd.utils.TimeUtils#getUsedTime(java.util.Date)}.
	 * 测试已花费的时间
	 */
	@Test
	public void testGetUsedTime() {
		Calendar c = new GregorianCalendar(2017,10,23); 
		Date date = c.getTime();
		int t = TimeUtils.getUsedTime(date);
		 System.out.println(t+"   sadad  ");
	}

}
