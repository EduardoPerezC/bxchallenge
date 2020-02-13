package com.bxchallenge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.bxchallenge.joblogger.JobLogger;
import com.bxchallenge.joblogger.utils.JobMessageFormatter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.bxchallenge.joblogger.utils.*")
public class JobLoggerTest {
	
	
	
	@Test
	public void whenLevelLogIsInvalid() throws Exception {
		
		 mockStatic(JobMessageFormatter.class);
		
	}

}
