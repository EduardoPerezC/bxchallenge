package com.bxchallenge.joblogger;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.bxchallenge.JobLoggerApplication;
import com.bxchallenge.joblogger.configuration.JobLoggerConfigurationManager;
import com.bxchallenge.joblogger.configuration.LoggerConfiguration;
import com.bxchallenge.joblogger.enums.JobLoggerLevelEnum;
import com.bxchallenge.joblogger.utils.JobMessageFormatter;


public class JobLogger {
	
	private static String currentConfig = "Console";
	private static Logger logger;
	
	static void configureLogger(Map params) {
		
		if(logger == null) {
			 System.out.println("chaning to " + currentConfig);
			logger = Logger.getLogger("MyLog");  
			LoggerConfiguration config = JobLoggerConfigurationManager.getInstance().getConfiguration(JobLoggerApplication.getContext(), currentConfig);
			config.setParams(params);
			logger.addHandler(config.getHandler());
		}
	}
	
	public static void changeConfiguration(String config) {
		changeConfiguration(config,null);
	}
	
	public static void changeConfiguration(String config,Map params) {
		
		logger = null;
		currentConfig = config;
		configureLogger(params);
		
	}
	
	public static void Info(String message) {
		LogMessage(message,"message");
	}
	

	public static void Warn(String message) {
		LogMessage(message,"warning");
	}
	
	public static void error(String message) {
		LogMessage(message,"error");
	}
	
	
	
	public static void LogMessage(String message,String level) {
		
		if(message==null || message.length()== 0) {
			throw new IllegalArgumentException("no message to log");
		}
		
		JobLoggerLevelEnum loggerLevel =  JobLoggerLevelEnum.valueFromLevelName(level.toUpperCase());
		if(loggerLevel == null) {
			throw new IllegalArgumentException("Error or Warning or Message must be specified"); //TODO get enum options, dinamyc
		}
		
		String formattedMessage =  JobMessageFormatter.format(message, loggerLevel.getLevelName());
		logger.log(Level.INFO, formattedMessage,loggerLevel.getLevelCode());
		
		
	}
	

}
