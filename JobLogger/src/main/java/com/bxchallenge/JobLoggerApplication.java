package com.bxchallenge;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.bxchallenge.joblogger.JobLogger;


@SpringBootApplication
public class JobLoggerApplication {
	
	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(JobLoggerApplication.class, args);
		testJobLoggerLogToFile();
		
	}
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}
	
	public static void testJobLoggerLogToFile() {
		
		Map properties = new HashMap<>();
		properties.put("logFileName", "fileLog01.txt");
		properties.put("logFileFolder", "/Users/eduardoperez/Documents");
		
		JobLogger.changeConfiguration("File",properties);
		JobLogger.Info("Info Message ");
		JobLogger.Warn("Warning Message");
		JobLogger.error("Error Message");
	}
	
	public static void testJobLoggerLogToDatabase() {
		
		String connectionString="jdbc:h2:mem:testdb;"
			    +"user=sa;password=sa";
		
		Map properties = new HashMap<>();
		properties.put("driverName", "org.h2.Driver");
		properties.put("connectionString", connectionString);
		
		JobLogger.changeConfiguration("Database",properties);
		JobLogger.Info("Info Message ");
		JobLogger.Warn("Warning Message");
		JobLogger.error("Error Message");
	}
	
	public static void testJobLoggerLogToConsole() {
		JobLogger.changeConfiguration("Console");
		JobLogger.Info("Info Message ");
		JobLogger.Warn("Warning Message");
		JobLogger.error("Error Message");
	}
	
	
	public static void testJobLogger(String configuration) {
		
		
		JobLogger.changeConfiguration(configuration);
		JobLogger.Info("Info Message ");
		JobLogger.Warn("Warning Message");
		JobLogger.error("Error Message");
		
		//JobLogger.LogMessage(null, configuration);
	}
	
	
	public void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }

}
