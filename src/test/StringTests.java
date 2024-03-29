package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONException;
import json.JSONFactory;
import json.JSONParser;
import json.JSONString;
import json.JSONValue;

/**
 * Tests the functionality of the {@link JSONString} class
 * 
 * @author James Davis - c3576413
 *
 */
public class StringTests {

	@ParameterizedTest
	@ValueSource(strings = { "testString", ""})
	public void testConstructor(String testVal) {
		JSONString s = JSONFactory.createString(testVal);
		assertTrue(s instanceof JSONString);
	}
	
	@Test
	public void testNullStringConstructor() {
		JSONString tv = JSONFactory.createString(null);
		assertTrue(tv instanceof JSONString);
		assertEquals(tv.toString(), JSONString.JSON_EMPTY_STRING.toString());
		
	}
	
	/**
	 * Test functionality of the {@link JSONString#encode(String, StringBuilder)} method.
	 * 
	 * NOTE: ISOControl Chars cannot be reached using this method
	 * Each individual 'char' is treated separately and therefore
	 * prevents this functionality from being reached. 
	 * 
	 * @param testVal - The value to test
	 */
	@ParameterizedTest
	@ValueSource(strings = { "\"", "\\", "/", "\b", "\f", 
			"\n", "\r", "\t" })
	public void testEncoder(String testVal) {
		StringBuilder sb = new StringBuilder();
		String encodedCompare = buildEncodedString(testVal);

		sb = JSONString.encode(testVal, sb);

		assertEquals(sb.toString(), encodedCompare);
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "hellothere" })
	public void testToString(String testVal) {
		JSONString test = JSONFactory.createString(testVal);
		if (test == JSONString.JSON_EMPTY_STRING)
			assertTrue(test.toString().contains("\"\""));
		else
			assertEquals(test.toString(), "\""+testVal+"\"");
	}

	@ParameterizedTest
	@ValueSource(strings = { "testValueHere", "{}" })
	public void testAsString(String testValue) {
		JSONString test = JSONFactory.createString(testValue);
		try {
			assertEquals(test.asString(), testValue);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetString() {
		JSONString test = JSONFactory.createString("this is my string here");
		assertEquals(test.getString(), "this is my string here");
		assertTrue(test.isString());
	}
	
	@RepeatedTest(3)
	public void testHashcode() {
		JSONString testVal = JSONFactory.createString("hello");
		assertEquals(testVal.hashCode(), 99162322);
	}
	
	@Test
	public void testEquals() {
		String s = "a test string";
		JSONString jString = JSONFactory.createString(s);
		JSONString jSCopy = jString;
		JSONString nullString = JSONString.JSON_EMPTY_STRING;
		JSONString test = JSONFactory.createString("this string");
		
		assertFalse(jString.equals(s));
		assertTrue(jSCopy.equals(jString));
		assertTrue(JSONString.JSON_EMPTY_STRING.equals(nullString));
		assertFalse(test.equals(s));
	}
	
	@Test
	public void testAppend() {
		try {
			JSONValue firstVal = JSONParser.parse("{\"value\":\"myString\"}");
			JSONValue secVal = JSONParser.parse("{\"value\":\"\"}");
			
			assertEquals(firstVal.toString(), "{\"value\":\"myString\"}");
			assertEquals(secVal.toString(), "{\"value\":\"\"\"\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Helper function to encode a string in such a way like the {@link JSONString#encode(String, StringBuilder)}
	 * encoder handles it.
	 * 
	 * This is to allow a bit for bit comparison so i can compare both outputs in comparison
	 * 
	 * @param testVal - The value to test
	 * @return The encoded string value
	 */
	private String buildEncodedString(String testVal) {
		StringBuilder builder = new StringBuilder();

		// The value is a String type, so place within quotes and encode special characters.
		builder.append('\"');

		String str = (String) testVal;

		int len = str.length();

		for (int i = 0; i < len; i++) {

			char c = str.charAt(i);

			// Check for any characters which require encoding.
			switch (c) {

			case '"':
				builder.append("\\\"");
				break;

			case '\\':
				builder.append("\\\\");
				break;

			case '/':
				builder.append("\\/");
				break;

			case '\b':
				builder.append("\\b");
				break;

			case '\f':
				builder.append("\\f");
				break;

			case '\n':
				builder.append("\\n");
				break;

			case '\r':
				builder.append("\\r");
				break;

			case '\t':
				builder.append("\\t");
				break;

			default:
				return "\"\\" + testVal + "\"";
			}
		}

		builder.append('\"');

		return builder.toString();
	}
}
