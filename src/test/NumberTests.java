package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testEquals() {
		JSONNumber firstNum = JSONFactory.createNumber(10.2);
		JSONNumber firstNumCopy = JSONFactory.createNumber(10.2);
		
		assertTrue(firstNum.equals(firstNumCopy));
		assertEquals(firstNum.equals(null), false);
	}
	
	@Test
	public void testHashcode() {
		JSONNumber testVal = JSONFactory.createNumber(10.21f);
		JSONNumber testValCopy = JSONFactory.createNumber(10.21f);
		assertEquals(testVal.hashCode(), testValCopy.hashCode());
	}
	
	@Test
	public void testToString() {
		JSONNumber numberVal = JSONFactory.createNumber(1234567890);
		assertTrue(numberVal.toString() instanceof String);
		assertEquals(numberVal.toString(), "1234567890");
	}
	
	@Test
	public void testGetNumber() {
		JSONNumber nVal = JSONFactory.createNumber(10.3);
		assertEquals(nVal.getNumber(), (Object)10.3);
	}
	
	@Test
	public void testIsNumber() {
		JSONNumber nVal = JSONFactory.createNumber(10.3);
		assertTrue(nVal.isNumber());
	}
	
	@Test
	//TODO: fix this shit. wtf man..
	public void testAsType() {
		JSONNumber withInt = JSONFactory.createNumber(1);
		JSONNumber withDouble = JSONFactory.createNumber(10.2);
		JSONNumber withFloat = JSONFactory.createNumber(22.412312343f);
		JSONNumber withLong = JSONFactory.createNumber(213425245l);
		
		try {
			assertEquals(withInt.asInteger(), 1);
			
			assertEquals(withDouble.asDouble(), 10.2);
			assertEquals(withDouble.asDouble() == 10.2);
			assertEquals(withFloat.asDouble() == 22.412312343f);
			assertEquals(withLong.asDouble() == 213425245l);
			
			assertEquals(withFloat.asFloat() == 22.412312343f);
			//assertTrue(withDouble.asFloat() == 10.2);
			//assertTrue(withInt.asFloat() == 1);
			//assertTrue(withLong.asFloat() == 2134254542);
			
			assertEquals(withLong.asLong() == 213425245l);
			assertEquals(withInt.asLong() == 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
