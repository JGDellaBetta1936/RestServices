package com.crunchify.restjersey;

public class JGConstants {
	private static final String DATETIMEFORMATPATTERN = "yyyy/MM/dd HH:mm:ss a z";
	private static final String USERNAME = "john_gold@comcast.net";
	private static final String PAZZWORD = "DellaBetta1936";
	private static final String EMAILADDRESS = "john_gold@comcast.net";
	private static final String EMAILSUBJECT = "Dear Partner, available consultants near you!";
	private static final String EMAILTEXT = "Dear Mail Crawler," + "\n\n No spam to my email, please!";
	private static final String OUTPUTFILELOCATION = "/Users/johngold/Documents/workspace/Testing/src/main/java/com/jg/testing/sendToValues.txt";
	private static final String URLCONNECTION = "jdbc:mysql://localhost:3306/test";
	private static final String JGFILELOCATION = "/Users/johngold/tools/JSONfile1.txt";
	private JGConstants () {
		//to make sonar happy
	}
	
	public static  String getDatetimeformatpattern() {
		return DATETIMEFORMATPATTERN;
	}
	public static   String getUsername() {
		return USERNAME;
	}
	public static  String getPassword() {
		return PAZZWORD;
	}
	public static  String getEmailaddress() {
		return EMAILADDRESS;
	}
	public static  String getEmailsubject() {
		return EMAILSUBJECT;
	}
	public static  String getEmailtext() {
		return EMAILTEXT;
	}
	public static  String getOutputfilelocation() {
		return OUTPUTFILELOCATION;
	}

	public static String getUrlconnection() {
		return URLCONNECTION;
	}

	public static String getJgfilelocation() {
		return JGFILELOCATION;
	}
}
