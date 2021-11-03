package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONFactory;

public class ArrayTests {

	@Test
	public void testArrayInits() {
		JSONArray firstA = JSONFactory.createArray();
		JSONArray secondA = JSONFactory.createArray(10);
		JSONArray lastA = JSONFactory.createArray(secondA);
		
		assertTrue(firstA instanceof JSONArray);
		assertTrue(secondA instanceof JSONArray);
		assertTrue(lastA instanceof JSONArray);
	}
}
