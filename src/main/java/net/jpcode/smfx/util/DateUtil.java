/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Billy Zhang
 *
 */
public class DateUtil {

	public static String getDateStr() {
		return getDateStr(new Date());
	}
	
	public static String getDateStr(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(date);
	}
	
	public static String getDateTimeStr() {
		return getDateTimeStr(new Date());
	}
	
	public static String getDateTimeStr(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fmt.format(date);
	}
	
	/**
	 */
	public static String toString(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date == null) {
			return "";
		}
		return fmt.format(date);

	}

	/**
	 */
	public static String toString(Date date, DateFormat df) {
		if (date == null) {
			return "";
		}
		return df.format(date);

	}
}
