package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONException;
import json.JSONParser;
import json.JSONValue;

/**
 * Tests functionality of the {@link JSONParser} class
 * 
 * @author James Davis - c3576413
 *
 */
public class ParserTests {
	/**
	 * Tests the parser functionality
	 */
	@RepeatedTest(5)
	public void testParsers() {
		try {
			JSONValue firstParsed = JSONParser.parse("{}");
			assertTrue(firstParsed instanceof JSONValue);

			JSONValue secondParsed = JSONParser.parse(new StringReader("{}"));
			assertTrue(secondParsed instanceof JSONValue);

			JSONValue thirdParsed = JSONParser
					.parseFile(System.getProperty("user.dir") + "/src/jsonFiles/Testing.json");
			assertTrue(thirdParsed instanceof JSONValue);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
		}
	}

	/**
	 * Tests exception functionality within the {@link JSONParser}
	 */
	@ParameterizedTest
	@ValueSource(strings = { "{},", "{a}", "{\"value1\".}", "{\"value1\":\"key\",}}", "{\"value1\":\"key\"!}", "[1,]",
			"[1", "tfue", "ftalse", "nall", "10.1.", "!", "\"\\m\"", "\"\u0001\"", "\" \u0000 \"", "\\u01A", "{null}" })
	public void testExceptions(String testInput) {
		assertThrows(JSONException.class, () -> JSONParser.parse(testInput));
	}
}
