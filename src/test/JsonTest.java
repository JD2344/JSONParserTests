package test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONException;
import json.JSONFactory;
import json.JSONParser;
import json.JSONValue;


/**
 * Tests the {@link JSONValue} class
 * 
 * @author James Davis - c3576413
 *
 */
public class JsonTest {
	
	/**
	 * Tests the various value methods 
	 */
	@ParameterizedTest
	@ValueSource(strings = { "false", "10", "\"hello\"", "null", "{}", "[]"})
	public void valueTests(String value) {
		try {
			JSONValue jsonVal = JSONParser.parse(value);
			
			if(jsonVal.isBoolean()) {
				assertTrue(jsonVal.isBoolean());
			} 
			else if(jsonVal.isNumber()) {
				assertTrue(jsonVal.isNumber());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
