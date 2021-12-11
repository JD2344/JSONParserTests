package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;

/**
 * Tests the {@link JSONNumber} class functionality
 * 
 * @author James Davis - c3576413
 *
 */
public class NumberTests {
	private static int counter = 0;
	
	/**
	 * This is to demonstrate afterEach annotation. Typically
	 * used to clear up/ change variables when after a method is fired.
	 */
	@AfterEach
	public void fireAfterEach() {
		System.out.println("After a method: " + counter);
		counter++;
	}
	
	@DisplayName("Test the number constructors")
	@Test
	public void testConstructors() {
		JSONNumber withDouble = JSONFactory.createNumber(10.2);
		JSONNumber withLongDec = JSONFactory.createNumber(43.192929393948);
		JSONNumber withFloat = JSONFactory.createNumber(22.412312343f);
		JSONNumber withLong = JSONFactory.createNumber(213425245l);
		JSONNumber withLongovMax = JSONFactory.createNumber(9913425245l);
		JSONNumber wEmptyDouble = JSONFactory.createNumber(0.0);
		JSONNumber wEmptyFloat = JSONFactory.createNumber(0.0f);
		JSONNumber wEmptyLong = JSONFactory.createNumber(0);

		assertTrue(withDouble instanceof JSONNumber);
		assertTrue(withLongDec instanceof JSONNumber);
		assertTrue(withFloat instanceof JSONNumber);
		assertTrue(withLong instanceof JSONNumber);
		assertTrue(withLongovMax instanceof JSONNumber);
		assertTrue(wEmptyDouble instanceof JSONNumber);
		assertEquals(wEmptyDouble, JSONNumber.JSON_ZERO_FLOAT);
		assertTrue(wEmptyFloat instanceof JSONNumber);
		assertEquals(wEmptyFloat, JSONNumber.JSON_ZERO_FLOAT);
		assertEquals(wEmptyLong, JSONNumber.JSON_ZERO_NUMBER);
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
		assertEquals(nVal.getNumber(), (Object) 10.3);
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
		JSONNumber withLong = JSONFactory.createNumber(213425245282883838L);

		try {
			// Test {@link JSONNumber#asInteger()}
			assertEquals(withInt.asInteger(), 1);
			assertThrows(JSONException.class, () -> withDouble.asInteger());

			// Test {@link JSONNumber#asDouble()}
			assertEquals(withInt.asDouble(), 1, 0);
			assertEquals(withDouble.asDouble(), 10.2, 0);
			assertEquals(withFloat.asDouble(), 22.412312343f, 0);
			assertEquals(withLong.asDouble(), 213425245282883838L, 0);

			// Test {@link JSONNumber#asFloat()}
			assertEquals(withInt.asFloat(), 1, 0);
			assertEquals(withLong.asFloat(), 213425245282883838L, 0);
			assertEquals(withFloat.asFloat(), 22.412312343f, 0);
			assertEquals(withDouble.asFloat(), ((Double) 10.2).floatValue(), 0);

			// Test {@link JSONNumber#asLong()}
			assertEquals(withLong.asLong(), 213425245282883838L, 0);
			assertEquals(withInt.asLong(), 1, 0);
			assertThrows(JSONException.class, () -> withDouble.asLong());

			// Test {@link JSONNumber#asByte()}
			assertEquals(withInt.asShort(), 1, 0);
			assertThrows(JSONException.class, () -> withDouble.asShort());

			// Test {@link JSONNumber#asByte()}
			assertEquals(withInt.asByte(), 1, 0);
			assertThrows(JSONException.class, () -> withDouble.asByte());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
