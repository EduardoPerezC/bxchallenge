package com.bxchallenge.joblogger.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class DatabaseLogHandler extends Handler{

	private PreparedStatement prepInsert;
	
	private Connection connection;
	
	public DatabaseLogHandler(String driverString,
            String connectionString)
	{
		try {
			
			Class.forName(driverString);
			connection = DriverManager.getConnection(connectionString);
			prepInsert = connection.prepareStatement(insertSQL);
		} catch ( ClassNotFoundException e ) {
			System.err.println("Error on open: " + e);
		} catch ( SQLException e ) {
			System.err.println("Error on open: " + e);
		}
	}
	
	protected final static String insertSQL=
		"insert into Log_Values (LOGMESSAGE,LOGLEVEL)"
		+"values(?,?)";
	
	
	private String truncate(String str,int length)
	{
	    if ( str.length()<length )
	      return str;
	    return( str.substring(0,length) );
	}
	
	@Override
	public void publish(LogRecord record) {
		// TODO Auto-generated method stub
		try {
		      prepInsert.setString(1,truncate(record.getMessage(),255));
		      prepInsert.setString(2,record.getParameters()[0].toString());
		      prepInsert.executeUpdate();
		} catch ( SQLException e ) {
		      System.err.println("Error on open: " + e);
		}
		
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws SecurityException {
		
		try {
		  if ( connection!=null )
		      connection.close();
		} catch ( SQLException e ) {
		      System.err.println("Error on close: " + e);
		}
		
	}

}
