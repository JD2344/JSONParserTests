package test;

import static org.junit.Assert.assertTrue;

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
	@ValueSource(strings = { "\"", "\\", "/" })
	public void testEncoder(String testVal) {
		JSONString test = JSONFactory.createString(testVal);
		System.out.println(test.toString() + " " + testVal);
		assertTrue(test.toString() == testVal);
	}
}
