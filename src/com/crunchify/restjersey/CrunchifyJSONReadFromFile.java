package com.crunchify.restjersey;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 

public class CrunchifyJSONReadFromFile {
	static Logger log = Logger.getLogger(CrunchifyJSONReadFromFile.class.getName() );
	String currentStatus = "notRun";
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ParseException {
    	CrunchifyJSONReadFromFile temp = new CrunchifyJSONReadFromFile();
    	temp.setThePropertyStart();
        JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("/Users/johngold/tools/JSONfile1.txt"));
            String name = (String) jsonObject.get("Name");
            String author = (String) jsonObject.get("Author");
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
 
            log.info("Name: " + name);
            log.info("Author: " + author);
            log.info("Company List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                log.info(iterator.next());
            }
            temp.setThePropertyDone();
    }
    
    private void setThePropertyDone() {
    	System.setProperty("ReadFromFileStatus", "complete");
    }
    
    private void setThePropertyStart() {
    	System.setProperty("ReadFromFileStatus", "Not complete");
    }
}
