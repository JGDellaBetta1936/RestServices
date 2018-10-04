package com.crunchify.restjersey;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONObject;

@Path("/agebydate")
public class AgeByDate {
	static Logger log = Logger.getLogger(AgeByDate.class.getName() );

	@Path("{day}")
	@GET
	@Produces("application/json")
	public Response calcAgeByDOB(@PathParam("day") String stringDOB) {	
		log.debug("String in->" + stringDOB);
		ArrayList<Integer> tempArray = new ArrayList<>();
		//reformat the input to MM/DD/YYYY
		StringTokenizer st = new StringTokenizer(stringDOB,"-");
		while (st.hasMoreElements()) {
			String temp = (String) st.nextElement();
			tempArray.add(Integer.valueOf(temp));
		}	
		//set the current date to current year, month and d.o.m.
		Calendar tempCal = Calendar.getInstance();
		int currentMonth = tempCal.get(Calendar.MONTH);
		int currentYear = tempCal.get(Calendar.YEAR);
		int currentDay = tempCal.get(Calendar.DAY_OF_MONTH);
		LocalDate tempDate = LocalDate.of(currentYear, currentMonth, currentDay) ;
		//set the date from the input (mm-dd-yyyy)
		int month = tempArray.get(0);
		int day = tempArray.get(1);
		int year = tempArray.get(2);
		log.debug(month + "-" + day + "-" + year);
		LocalDate birthday = LocalDate.of(year, month, day);	 
		Period p = Period.between(birthday, tempDate);	
		
		LinkedHashMap<String, Integer> jsonOrderedMap = new LinkedHashMap<>();

		jsonOrderedMap.put("year",p.getYears());
		jsonOrderedMap.put("month",p.getMonths());
		jsonOrderedMap.put("day",p.getDays());

		JSONObject orderedJson = new JSONObject(jsonOrderedMap);
				
		String result = JGUtils.returnPrettyPrint(orderedJson.toString());
	
		return Response.status(200).entity(result).build();
		
	}
}
