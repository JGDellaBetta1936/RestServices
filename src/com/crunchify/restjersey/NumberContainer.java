/**
 * 
 */
package com.crunchify.restjersey;

import java.io.Serializable;

/**
 * @author johngold
 *
 */
public class NumberContainer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4443281324116940328L;
	private Integer theNumber = 0;
	private Integer theCount = 0;
	/**
	 * 
	 */
	public NumberContainer() {
		// TODO Auto-generated constructor stub
	}
	public Integer getTheNumber() {
		return theNumber;
	}
	public void setTheNumber(Integer theNumber) {
		this.theNumber = theNumber;
	}
	public Integer getTheCount() {
		return theCount;
	}
	public void setTheCount(Integer theCount) {
		this.theCount = theCount;
	}

}
