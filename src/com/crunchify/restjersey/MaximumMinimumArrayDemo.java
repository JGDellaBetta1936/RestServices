package com.crunchify.restjersey;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class MaximumMinimumArrayDemo {
	private static Logger log = Logger.getLogger(MaximumMinimumArrayDemo.class.getName());

	private MaximumMinimumArrayDemo() {

	}

	public static void main(String [] args) {
		largestAndSmallest(new int[] { -20, 34, 21, -87, 92, Integer.MAX_VALUE });
		largestAndSmallest(new int[] { 10, Integer.MIN_VALUE, -2 });
		largestAndSmallest(new int[] { Integer.MAX_VALUE, 40, Integer.MAX_VALUE });
		largestAndSmallest(new int[] { 1, -1, 0 });
	}

	public static void largestAndSmallest(int[] numbers) {
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		for (int number : numbers) {
			if (number > largest) {
				largest = number;
			} else if (number < smallest) {
				smallest = number;
			}
		}

		log.info("Given integer array : " + Arrays.toString(numbers));
		log.info("Largest number in array is : " + largest);
		log.info("Smallest number in array is : " + smallest);
	}

}
