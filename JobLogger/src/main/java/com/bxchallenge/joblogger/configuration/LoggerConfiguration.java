package com.bxchallenge.joblogger.configuration;

import java.util.logging.Handler;
import java.util.Map;

public interface LoggerConfiguration {

	Handler getHandler();
	void setParams(Map params);
}
