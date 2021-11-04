package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONFactory;

/**
 * Tests all functionality of the {@link JSONArray} class
 * @author James Davis - c3576413
 *
 */
public class ArrayTests {
	
	/**
	 * Tests the constructors of the {@link JSONArray} class
	 */
	@Test
	public void testArrayInits() {
		JSONArray firstA = JSONFactory.createArray();
		JSONArray secondA = JSONFactory.createArray(10);
		secondA.addValue(false);
		JSONArray lastA = JSONFactory.createArray(secondA);
		
		assertTrue(firstA instanceof JSONArray);
		assertTrue(secondA instanceof JSONArray);
		assertTrue(lastA instanceof JSONArray);
	}
	
	/**
	 * Tests some of the basic functions of the {@link JSONArray} class
	 */
	@Test
	public void testArrayMethods() {
		JSONArray firstA = JSONFactory.createArray();
		JSONArray copyA = firstA.copy();
		JSONArray thirdA = JSONFactory.createArray();
		thirdA.addValue(false);
		
		assertTrue(firstA.isArray());
		assertEquals(firstA, copyA);
		assertTrue(firstA.equals(copyA));
		assertEquals(firstA.hashCode(), copyA.hashCode());
		
		assertEquals(firstA.toString(), "[]");
		assertEquals(thirdA.toString(), "[false]");
	}
}
