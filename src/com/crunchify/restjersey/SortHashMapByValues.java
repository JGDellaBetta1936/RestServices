package com.crunchify.restjersey;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class SortHashMapByValues {

	static Logger log = Logger.getLogger(SortHashMapByValues.class.getName());
	
	private  SortHashMapByValues() {
	
	}

	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<>();
		hmap.put(5, "A");
		hmap.put(11, "C");
		hmap.put(4, "Z");
		hmap.put(77, "Y");
		hmap.put(9, "P");
		hmap.put(66, "Q");
		hmap.put(0, "R");
		log.info("Before Sorting:");
		Set<?> set = hmap.entrySet();
		Iterator<?> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<?, ?> me = (Map.Entry<?, ?>) iterator.next();
			log.info(me.getKey() + ":" + me.getValue());

		}
		Map<Integer, String> map = new TreeMap<>(hmap); 
        log.info("After Sorting:");
        Set<?> set2 = map.entrySet();
        Iterator<?> iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
             Map.Entry<?, ?> me2 = (Map.Entry<?, ?>)iterator2.next();
             log.info(me2.getKey() + ":" + me2.getValue());

        }
		
	}

	

	
}
