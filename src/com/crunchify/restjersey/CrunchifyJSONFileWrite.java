package com.crunchify.restjersey;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
/**
 * @author Crunchify.com
 */
 
public class CrunchifyJSONFileWrite {
	static Logger log = Logger.getLogger(CrunchifyJSONFileWrite.class.getName() );
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
 
		JSONObject obj = new JSONObject();
		obj.put("Name", "crunchify.com");
		obj.put("Author", "BillE Bob");
 
		JSONArray company = new JSONArray();
		company.add("Company: eBay");
		company.add("Company: Paypal");
		company.add("Company: Google");
		obj.put("Company List", company);
 
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("/Users/johngold/tools/JSONfile1.txt")) {
			file.write(obj.toJSONString());
			log.info("Successfully Copied JSON Object to File...");
			log.info("JSON Object: " + obj);
		}
	}
}