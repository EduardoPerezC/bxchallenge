package com.bxchallenge.joblogger.configuration;

import java.util.logging.Handler;
import org.springframework.stereotype.Component;
import java.util.Map;
import com.bxchallenge.joblogger.handlers.DatabaseLogHandler;


@Component
public class DatabaseLoggerConfiguration implements LoggerConfiguration{

	static {
		JobLoggerConfigurationManager.getInstance().registerConfiguration("Database", DatabaseLoggerConfiguration.class);
	}
	
	private final static String DRIVERNAME = "driverName";
	private final static String CONNSTRING = "connectionString";
	
	private String driverName;
	private String connectionString;

	@Override
	public Handler getHandler() {
		// TODO Auto-generated method stub
		return new DatabaseLogHandler(driverName,connectionString);
	}

	@Override
	public void setParams(Map params) {
		
		if(params == null || params.isEmpty()) {
			throw new IllegalArgumentException("Missing driverName and connectionString property");
		}
		
		if(!params.containsKey(DRIVERNAME)) {
			throw new IllegalArgumentException("Missing driverName");
		}
		
		if(!params.containsKey(CONNSTRING)) {
			throw new IllegalArgumentException("Missing connectionString");
		}
		
		this.driverName = params.get(DRIVERNAME).toString();
		this.connectionString = params.get(CONNSTRING).toString();
		
		
	}
	

}
