package com.crunchify.restjersey;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

public class RandomNumberGenerator {
	static Logger log = Logger.getLogger(RandomNumberGenerator.class.getName());
	
	private  RandomNumberGenerator () {
		
	}
	/**
	 * getRandomNumberInRange - generates random number
	 * @param min
	 * @param max
	 * @return Map
	 */
	public static Map<Integer, Integer> getRandomNumberInRange(int min, int max) {
		Map<Integer, Integer> counterHashMap = new LinkedHashMap<>();
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		for (int i = 1; i< 10000; i++) {
			int rtnValue = r.nextInt(50); 
			if (counterHashMap.containsKey(rtnValue)) {
				log.debug("key of " + rtnValue + " found, updating.");
				int tempInt = counterHashMap.get(rtnValue);
				tempInt ++;
				log.debug( "Original value after return -> " + counterHashMap.put(rtnValue, tempInt) );
			} else {
				log.debug("Key of: " + rtnValue + " not found adding to map");
				counterHashMap.put(rtnValue, 1);
			}	
		}
		
		return counterHashMap;
	}

}
