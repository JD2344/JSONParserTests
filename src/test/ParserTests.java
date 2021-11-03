package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

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
	@Test
	public void testParsers() {
		try {
			JSONValue firstParsed = JSONParser.parse("{}");
			assertTrue(firstParsed instanceof JSONValue);

			JSONValue secondParsed = JSONParser.parse(new StringReader("{}"));
			assertTrue(secondParsed instanceof JSONValue);
			
			JSONValue thirdParsed = JSONParser.parseFile(System.getProperty("user.dir") + "/src/jsonFiles/Testing.json");
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
	@Test
	public void testExceptions() {
		assertThrows(JSONException.class, () -> JSONParser.parse("{},"));
	}
}
