package com.ysbn.videotrain.managesystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.lang3.time.DateUtils;

import com.google.gson.Gson;


/**
 * 工具类
 * 
 */
public final class TVUtility {

	private static ResourceBundle rb = PropertyResourceBundle.getBundle("sys");
	//TODO 读取properties
	public static String getProperty(String proName){
		
		return rb.getString(proName);
	
	}

	public static String toJson(Object o){
		Gson gson = new Gson();
		return gson.toJson(o);
	}
	
	//TODO 自动获取查询时间范围(一年)，0startTime，1endTime
	public static String[] autoGetTime() {
		String[] queryTime=new String[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		queryTime[0]=sdf.format(DateUtils.addYears(new Date(), -1));
		queryTime[1]=sdf.format(new Date());
		return queryTime;
	}
	//格式化BOSS日期
	public static String formatBossTime(String waitFormatTime) {
		StringBuffer buf = new StringBuffer(waitFormatTime);
		buf.insert(4, "-");
		buf.insert(7, "-");
		return buf.substring(0, 10).toString();
	}

	
}