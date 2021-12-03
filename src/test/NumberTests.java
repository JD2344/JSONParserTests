package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;

/**
 * Tests the {@link JSONNumber} class functionality
 * @author James Davis - c3576413
 *
 */
public class NumberTests {
	
	@DisplayName("Test the number constructors")
	@Test
	public void testConstructors() {
		JSONNumber withDouble = JSONFactory.createNumber(10.2);
		JSONNumber withLongDec = JSONFactory.createNumber(43.192929393948);
		JSONNumber withFloat = JSONFactory.createNumber(22.412312343f);
		JSONNumber withLong = JSONFactory.createNumber(213425245l);
		JSONNumber withLongovMax = JSONFactory.createNumber(9913425245l);
		
		assertTrue(withDouble instanceof JSONNumber);
		assertTrue(withLongDec instanceof JSONNumber);
		assertTrue(withFloat instanceof JSONNumber);
		assertTrue(withLong instanceof JSONNumber);
		assertTrue(withLongovMax instanceof JSONNumber);
	}
	
	@DisplayName("Test Equals method of Number classes")
	@Test
	public void testEquals() {
		JSONNumber firstNum = JSONFactory.createNumber(10.2);
		JSONNumber firstNumCopy = JSONFactory.createNumber(10.2);
		
		assertTrue(firstNum.equals(firstNumCopy));
		assertEquals(firstNum.equals(null), false);
	}
	
	@DisplayName("Test hashcodes of numbers")
	@Test
	public void testHashcode() {
		JSONNumber testVal = JSONFactory.createNumber(10.21f);
		JSONNumber testValCopy = JSONFactory.createNumber(10.21f);
		assertEquals(testVal.hashCode(), testValCopy.hashCode());
	}
	
	@DisplayName("Test to string functionality of numbers")
	@Test
	public void testToString() {
		JSONNumber numberVal = JSONFactory.createNumber(1234567890);
		assertTrue(numberVal.toString() instanceof String);
		assertEquals(numberVal.toString(), "1234567890");
	}
	
	@DisplayName("Test get number method")
	@Test
	public void testGetNumber() {
		JSONNumber nVal = JSONFactory.createNumber(10.3);
		assertEquals(nVal.getNumber(), (Object)10.3);
	}
	
	@DisplayName("Check item is a number")
	@Test
	public void testIsNumber() {
		JSONNumber nVal = JSONFactory.createNumber(10.3);
		assertTrue(nVal.isNumber());
	}
	
	@DisplayName("Test the number types")
	@Test
	public void testAsType() {
		JSONNumber withInt = JSONFactory.createNumber(1);
		JSONNumber withDouble = JSONFactory.createNumber(10.2);
		JSONNumber withFloat = JSONFactory.createNumber(22.412312343f);
		JSONNumber withLong = JSONFactory.createNumber(213425245l);
		
		try {
			assertEquals(withInt.asInteger(), 1);
			
			assertTrue(withDouble.asDouble() == 10.2);
			assertTrue(withDouble.asDouble() == 10.2);
			assertTrue(withFloat.asDouble() == 22.412312343f);
			assertTrue(withLong.asDouble() == 213425245l);
			
			assertTrue(withFloat.asFloat() == 22.412312343f);
			//assertTrue(withDouble.asFloat() == 10.2);
			//assertTrue(withInt.asFloat() == 1);
			//assertTrue(withLong.asFloat() == 2134254542);
			
			//assertTrue(withLong.asLong() == 213425245l);
			//assertTrue(withInt.asLong() == 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
