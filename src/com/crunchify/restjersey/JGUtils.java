/**
 * 
 */
package com.crunchify.restjersey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author johngold
 *
 */
public class JGUtils {
	static Logger log = Logger.getLogger(JGUtils.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jg.utils.IJGUtils#returnPrettyPrint(java.lang.String)
	 */
	public static String returnPrettyPrint(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(json);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jg.utils.IJGUtils#formatThisDate(java.lang.String)
	 */
	public static String formatThisDate(String formatPattern) {
		String workingPattern = formatPattern;
		final Date now = new Date();
		if (workingPattern == null) {
			workingPattern = JGConstants.getDatetimeformatpattern();
		}
		final DateFormat format = new SimpleDateFormat(workingPattern);
		return format.format(now);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jg.utils.IJGUtils#formatThisDate()
	 */
	public static String formatThisDate() {
		final Date now = new Date();
		final DateFormat format = new SimpleDateFormat(JGConstants.getDatetimeformatpattern());
		return format.format(now);
	}

}
