package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONFactory;
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
	@Test
	public void valueTests() {
		JSONValue boolVal = JSONFactory.createBoolean(false);
		JSONValue numberVal = JSONFactory.createNumber(10);
		JSONValue arrayVal = JSONFactory.createArray();
		JSONValue stringVal = JSONFactory.createString("hello");
		JSONValue nullVal = JSONFactory.createNull();
		JSONValue objectVal = JSONFactory.createObject();
		assertTrue(boolVal.isBoolean());
		assertTrue(numberVal.isNumber());
		assertTrue(arrayVal.isArray());
		assertTrue(stringVal.isString());
		assertTrue(nullVal.isNull());
		assertTrue(objectVal.isObject());
	}
}
