/**
 * 
 */
package com.crunchify.restjersey;

import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author johngold
 *
 */
@Path("/primenumbers")

public class PrimeNumbers {
	static Logger log = Logger.getLogger(PrimeNumbers.class.getName());
	
	
	@GET
	@Produces("application/json")
	public Response showPrimeNumbers() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		
		Random r = new Random();
	
		for (int i=0; i<1000; i++) {
			int tempInt = r.nextInt(52);
			jsonObject.increment(String.valueOf(tempInt));
		}
		
		String result = JGUtils.returnPrettyPrint(jsonObject.toString());;
		log.info("PrimeNumbers() returning with results.");
		return Response.status(200).entity(result).build();

	}


	
}
