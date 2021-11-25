package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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
@TestInstance(Lifecycle.PER_CLASS)
public class StringTests {

	@Test
	public void testConstructor() {
		JSONString s = JSONFactory.createString("testString");
		assertTrue(s instanceof JSONString);
	}

	@ParameterizedTest
	@ValueSource(strings = { "\"", "\\", "/", "\b", "\f", "\n", "\r", "\t" })
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
	
	@Test
	public void testHashcode() {
		JSONString testVal = JSONFactory.createString("hello");
		assertEquals(testVal.hashCode(), 99162322);
	}

	/**
	 * Helper function to encode a string in such a way like the {@link JSONString}
	 * encoder handles it.
	 * 
	 * @param testVal - The value to test
	 * @return The encoded string value
	 */
	private String buildEncodedString(String testVal) {
		StringBuilder builder = new StringBuilder();
		builder.append('\"');
		for (int i = 0; i < testVal.length(); i++) {
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
