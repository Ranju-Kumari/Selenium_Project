package com.mercurytoursflights.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author M1049131 
 * Purpose: Method to print the logs.
 *
 */

public class Log {

private static Logger Log = Logger.getLogger(Log.class.getName());
	
	public Log() {
		super();
	}

	public static void info(String message) {
		PropertyConfigurator.configure("Log4j.properties");
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}
}
