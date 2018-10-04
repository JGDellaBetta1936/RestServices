package com.crunchify.restjersey;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTokenzierExample {
	 
	public  List<String> tokenizeThis(String splitThis) {
		String tempString;
		List<String> rtnList = new LinkedList<>();
		StringTokenizer ste = new StringTokenizer(splitThis, ",");
		while (ste.hasMoreTokens()) {
			tempString = ste.nextToken(",");
			rtnList.add(tempString);
		}
		return rtnList;
	}
	
}
