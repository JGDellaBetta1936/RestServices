package com.crunchify.restjersey;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/showsysprops")
public class ReadSystemProperties {
	static Logger log = Logger.getLogger(ReadSystemProperties.class.getName());
	@GET
	@Produces("application/json")
	public Response showSystemProperties() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		Properties sysProps = System.getProperties();
		Set<Object> keySet = sysProps.keySet();
		Iterator<Object> keyIter = keySet.iterator();
		while (keyIter.hasNext()) {
			String key = keyIter.next().toString();
			String value = System.getProperty(key);
			jsonObject.put(key,value);
		}
		String result = JGUtils.returnPrettyPrint(jsonObject.toString());;
		log.info("showSystemProperties returning results.");
		return Response.status(200).entity(result).build();
		
	}
}
