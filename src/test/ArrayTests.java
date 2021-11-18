package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONArray;
import json.JSONFactory;
import json.JSONNull;
import json.JSONValue;

/**
 * Tests all functionality of the {@link JSONArray} class
 * @author James Davis - c3576413
 *
 */
public class ArrayTests {
	/**
	 * A default array of values
	 */
	private JSONArray testingArray;
	
	/**
	 * Builds a new {@link JSONArray} with values of all types
	 */
	ArrayTests() {
		JSONArray finishedA = JSONFactory.createArray(10);
		finishedA.addValue();
		finishedA.addValue(false);
		finishedA.addValue(true);
		finishedA.addValue(10.2);
		finishedA.addValue(22.3f);
		finishedA.addValue(JSONFactory.createArray());
		finishedA.addValue(JSONFactory.createObject());
		finishedA.addValue();
		finishedA.addValue(21475963l);
		finishedA.addValue("hello");
		this.testingArray = finishedA;
	}
	
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
		assertEquals(lastA, secondA);
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
	
	/**
	 * Provides testing functionality for the {@link JSONArray} .add() methods
	 */
	//TODO: FIX THIS!!!!
	@Test
	public void testAddValueMethods() {
		for(int index = 0; index < testingArray.size(); index++) {
			assertEquals(testingArray.get(index), JSONNull.JSON_NULL);
		}
	}
}
