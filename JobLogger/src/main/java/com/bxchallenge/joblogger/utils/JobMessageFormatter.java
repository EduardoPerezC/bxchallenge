package com.bxchallenge.joblogger.utils;

import java.text.DateFormat;
import java.util.Date;
import com.bxchallenge.joblogger.enums.JobLoggerLevelEnum;


public class JobMessageFormatter {
	
	private static final DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
	
	public static String format(String message,String loggerLevelName) {
		
		StringBuilder builder = new StringBuilder(1000);
		builder.append(loggerLevelName).append("-");
		builder.append(df.format(new Date())).append("-");
		builder.append(message);
		builder.append("\n");
		
		return builder.toString();
	}

}
