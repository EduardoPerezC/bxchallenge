package com.bxchallenge.joblogger.enums;

public enum JobLoggerLevelEnum {

	ERROR("2","error"),
	WARNING("3","warning"),
	INFO("1","message");
	
	private String levelCode;
	
	private String levelName;
	
	JobLoggerLevelEnum(String levelCode,String levelName){
		this.levelCode = levelCode;
		this.levelName = levelName;
	}
	
	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	
	public static JobLoggerLevelEnum valueFromLevelName(String name) {
		
		for(JobLoggerLevelEnum eachValue : JobLoggerLevelEnum.values()) {
			if(eachValue.levelName.equalsIgnoreCase(name)) {
				return eachValue;
			}
		}
		return null;
		
	}
	
	
	
	/*public static String getFormattedMessage(String name,String messageText) {
		return   valueFromLevelName(name).levelName DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

	}i*/
	
	
	
}
