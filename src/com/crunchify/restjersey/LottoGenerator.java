/**
 * 
 */
package com.crunchify.restjersey;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.prefs.Preferences;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.apache.commons.jcs.access.exception.CacheException;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author johngold
 *
 */
@Path("/lottoGenerate")
public class LottoGenerator  {
	private static Logger log = Logger.getLogger(LottoGenerator.class.getName());
	Map<Integer, Integer> counterHashMap = new HashMap<>();
	CacheAccess<String, Counter> cache = JCS.getInstance( "default" );
	static Random r = new Random();
	JSONObject jsonObject = new JSONObject();
	
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response getForNumberOfTimes (@PathParam("f") int numtimes) throws JSONException {
		log.info("Starting to gen->" + numtimes);
		
		int counter = 0;
		while (counter <= numtimes) {

			int tempInt = getRandomInteger();
			if (counterHashMap.containsKey(tempInt)) {
				counterHashMap.replace(tempInt, counterHashMap.get(tempInt)+1);
				System.out.println("Bumping key up.");
			}
			else {
				counterHashMap.put(tempInt, 1);
				System.out.println("initializing.");
			}
			counter ++;
		}
		
		Set<Integer> keySet = counterHashMap.keySet();
		Iterator<Integer> myIter = keySet.iterator();
		int myInt;
		int mapValue;
		while (myIter.hasNext()) {
			 myInt= (int) myIter.next();
			 mapValue = counterHashMap.get(myInt);
			 jsonObject.put(Integer.toString(myInt), Integer.toString(mapValue));
		}
		String result = JGUtils.returnPrettyPrint(jsonObject.toString());
		log.info("getForNumberOfTimes done.");
		putInCache(counterHashMap);
		return Response.status(200).entity(result).build() ;
	}

	/*
	 * returns random integer between minimum and maximum range
	 */
	public static int getRandomInteger() {
		
		return r.nextInt(53);
	}
	
	
	public void putInCache( Map<Integer, Integer> counterHashMap2 ) 
    {
        Counter counter = new Counter();
        counter.setTheMap(counterHashMap2);
        try 
        {
            cache.put( "key", counter );
        }
        catch ( CacheException e ) 
        {
            System.out.println(e.getMessage());
        }
    }
}
