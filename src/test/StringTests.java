package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONException;
import json.JSONFactory;
import json.JSONString;

/**
 * Tests the functionality of the {@link JSONString} class
 * 
 * @author James Davis - c3576413
 *
 */
public class StringTests {

	@Test
	public void testConstructor() {
		JSONString s = JSONFactory.createString("testString");
		assertTrue(s instanceof JSONString);
	}

	@ParameterizedTest
	@ValueSource(strings = { "\"", "\\", "/", "\b", "\f", "\n"
			,"\r", "\t"})
	public void testEncoder(String testVal) {
		StringBuilder sb = new StringBuilder();
		String encodedCompare = buildEncodedString(testVal);
		
		sb = JSONString.encode(testVal, sb);
		
		
		assertEquals(sb.toString(), encodedCompare);
	}

	@Test
	public void testToString() {
		JSONString test = JSONFactory.createString("");

		if (test == JSONString.JSON_EMPTY_STRING) {
			assertTrue(test.toString().contains("\"\""));
		}
	}

	@ParameterizedTest
	@ValueSource(strings = { "testValueHere", "{}" })
	@RepeatedTest(10)
	// TODO:fix this
	public void testAsString(String testValue) {
		JSONString test = JSONFactory.createString(testValue);
		try {
			assertTrue(test.asString() == testValue.toString());
		} catch (JSONException e) {
			if (!(test.toString() instanceof String)) {
				assertThrows(JSONException.class, () -> test.asString());
			}
		}
	}
	
	/**
	 * Helper function to encode a string in such a way like the 
	 * {@link JSONString} encoder handles it. 
	 * @param testVal - The value to test
	 * @return The encoded string value
	 */
	private String buildEncodedString(String testVal) {
		StringBuilder builder = new StringBuilder();
		builder.append('\"');
		for(int i = 0; i < testVal.length(); i++) {
			char c = testVal.charAt(i);
			switch (c) {
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
