package test;

import java.io.File;
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

	@Test
	public void testParsers() {
		try {
			JSONValue firstParsed = JSONParser.parse("");

			JSONValue secondParsed = JSONParser.parse(new StringReader("{}"));

			JSONValue thirdParsed = JSONParser.parseFile("jsonFiles/Testing.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
