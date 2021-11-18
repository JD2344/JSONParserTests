package test;

import static org.junit.Assert.assertThrows;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONException;
import json.JSONParser;
import json.JSONValue;

/**
 * Tests various exception related functionality
 * 
 * @author James Davis - c3576413
 *
 */
public class ExceptionTests {

	@ParameterizedTest
	@ValueSource(strings = { "\"key\"", "{}", "[]", "true", "10.2", 
			"22.4434343f", "2139292929", "1" })
	public void testJSONValueasObject(String testVal) {
		JSONValue val;
		try {
			val = JSONParser.parse(testVal);
			if(!val.isObject()) {
				assertThrows(JSONException.class, () -> val.asObject());				
			}
			if(!val.isString()) {
				assertThrows(JSONException.class, () -> val.asString());
			}
			assertThrows(JSONException.class, () -> val.asByte());
			assertThrows(JSONException.class, () -> val.asShort());
			assertThrows(JSONException.class, () -> val.asInteger());
			assertThrows(JSONException.class, () -> val.asLong());
			assertThrows(JSONException.class, () -> val.asFloat());
			assertThrows(JSONException.class, () -> val.asDouble());
			if(!val.isBoolean()) {
				assertThrows(JSONException.class, () -> val.asBoolean());				
			}
			if(!val.isArray()) {
				assertThrows(JSONException.class, () -> val.asArray());				
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
