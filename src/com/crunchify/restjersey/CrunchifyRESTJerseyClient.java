package com.crunchify.restjersey;
/**
 * ONLY WORKS IF THE SERVER IS UP AND RUNNING
 * ONLY WORKS IF THE SERVER IS UP AND RUNNING
 * ONLY WORKS IF THE SERVER IS UP AND RUNNING
 */
import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
 
public class CrunchifyRESTJerseyClient {
	static Logger log = Logger.getLogger(CrunchifyRESTJerseyClient.class.getName() );
	public static void main(String[] args) {
 
		CrunchifyRESTJerseyClient crunchifyClient = new CrunchifyRESTJerseyClient();
		crunchifyClient.getCtoFResponse();
		crunchifyClient.getFtoCResponse();
	}
 
	private void getFtoCResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ftocservice/90");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
 
			String output2 = response.getEntity(String.class);
			log.info("\n============getFtoCResponse============");
			log.info(output2);
 
		} catch (Exception e) {
			log.error("Caught Exception when creating client for FtoCService.", e);
		}
	}
 
	private void getCtoFResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ctofservice/40");
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
 
			String output = response.getEntity(String.class);
			log.info("============getCtoFResponse============");
			log.info(output);
 
		} catch (Exception e) {
			log.error("Caught exception when creating client for CtFService.",e);
		}
	}
}