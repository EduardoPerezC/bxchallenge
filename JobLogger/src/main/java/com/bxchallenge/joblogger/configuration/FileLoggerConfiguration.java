package com.bxchallenge.joblogger.configuration;


import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class FileLoggerConfiguration implements LoggerConfiguration{
	
	static {
		JobLoggerConfigurationManager.getInstance().registerConfiguration("File", FileLoggerConfiguration.class);
	}
	
	private final static String LOGFILENAMEPROP = "logFileName";
	private final static String LOGFILEDIRPROP = "logFileFolder";
	
	private String logFileName;
	private String logFileFolder;
	
	public String getLogFileFolder() {
		return logFileFolder;
	}

	public void setLogFileFolder(String logFileFolder) {
		this.logFileFolder = logFileFolder;
	}
	
	public String getLogFileName() {
		return logFileName;
	}
	
	private String getFullPathLogFile() {
		return logFileFolder + File.separator + logFileName;
		
	}

	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}
	
	
	@Override
	public Handler getHandler() {
		
		try {
			
			File logFile = new File(getFullPathLogFile());
			if (!logFile.exists()) {
				logFile.createNewFile();
			}
			
			return new FileHandler(getFullPathLogFile());
		}catch(IOException e) {
			System.out.println(e.getMessage()); //TODO : Improve exception handling
		}
		return null;
		
	}

	@Override
	public void setParams(Map params) {
		
		if(params == null || params.isEmpty()) {
			throw new IllegalArgumentException("Missing logFileName and logFileFolder property");
		}
		
		if(!params.containsKey(LOGFILENAMEPROP)) {
			throw new IllegalArgumentException("Missing logFileName property");
		}
		
		if(!params.containsKey(LOGFILEDIRPROP)) {
			throw new IllegalArgumentException("Missing logFileFolder property");
		}
		
		this.logFileName = params.get(LOGFILENAMEPROP).toString();
		this.logFileFolder = params.get(LOGFILEDIRPROP).toString();
		
		
	}
	

}
