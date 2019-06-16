package com.qa.internal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.model.Trick;
import com.qa.repository.TrickDB;

public class GetsAndSets {

	Trick myTrick;

	@Before
	public void setup() {
		myTrick = new Trick();
	}
	
	@Test
	public void setTrickName() {
		myTrick.setTrick("lateflip");
		assertEquals("Set trick test failed", "lateflip", myTrick.getTrick());
	}
	
	@Test
	public void setTrickDesc() {
		myTrick.setDesc("some text");
		assertEquals("Set trick description test failed", "some text", myTrick.getDesc());
	}
	
	
	@Test
	public void setProgress() {
		myTrick.setProgress(2);
		assertEquals("Set trick progress test failed", 2, myTrick.getProgress());
	}
	 
	
	@Test
	public void setDifficulty() {
		myTrick.setDifficulty(5);
		assertEquals("Set trick difficulty test failed", 5, myTrick.getDifficulty());
	}
	
	
}
