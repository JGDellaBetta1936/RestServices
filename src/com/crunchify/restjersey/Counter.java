package com.crunchify.restjersey;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Counter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1062420212916398013L;
	Map<Integer, Integer> counterHashMap = new HashMap<>();
	
	public Counter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setTheMap(Map<Integer, Integer> mapIn) {
		this.counterHashMap = mapIn;
	}

	

}
