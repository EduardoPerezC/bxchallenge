package com.bxchallenge.joblogger.configuration;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;


public final class JobLoggerConfigurationManager {
	
	static JobLoggerConfigurationManager instance;
	
	private static final Map<String,Class<? extends LoggerConfiguration>> configurations = new HashMap<>();
	
	public static JobLoggerConfigurationManager getInstance() {
		if(instance == null) {
			instance = new JobLoggerConfigurationManager();
		}
		
		return instance;
	}
	
	public void registerConfiguration(String configName,Class<? extends LoggerConfiguration> config) {
		
		if(configName != null  && config!= null) {
			configurations.put(configName, config);
		}
	}
	
	
	public LoggerConfiguration getConfiguration(ApplicationContext context, String configuration) {
		
		if(!configurations.containsKey(configuration)) {
			throw new IllegalArgumentException("Invalid Configuration");
		}
		
		return context.getBean(configurations.get(configuration));
	}
	
	
	
	
	

}
