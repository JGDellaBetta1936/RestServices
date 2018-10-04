package com.crunchify.restjersey;

import static org.junit.Assert.*;

import org.junit.Test;

public class LottoGeneratorTest {

	@Test
	public final void testGetForNumberOfTimes() {
		LottoGenerator myLG = new LottoGenerator();
		assertNotNull("Nope", myLG.getForNumberOfTimes(2));
	}

	@Test
	public final void testGetRandomInteger() {
		assertNotNull("Nope", LottoGenerator.getRandomInteger());
	}

}
