package com.bxchallenge.joblogger.configuration;

import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import org.springframework.stereotype.Component;


@Component
public class ConsoleLoggerConfiguration implements LoggerConfiguration{
	
	static {
		JobLoggerConfigurationManager.getInstance().registerConfiguration("Console", ConsoleLoggerConfiguration.class);
	}
	
	@Override
	public Handler getHandler() {
		return new ConsoleHandler();
	}

	@Override
	public void setParams(Map params) {
		// TODO Auto-generated method stub
		
	}
	

}
