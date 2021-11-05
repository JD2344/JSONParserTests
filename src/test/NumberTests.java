package test;

import org.junit.jupiter.api.Test;

import json.JSONFactory;
import json.JSONNumber;

/**
 * Tests the {@link JSONNumber} class functionality
 * @author James Davis - c3576413
 *
 */
public class NumberTests {

	@Test
	public void testConstructors() {
		JSONNumber withDouble = JSONFactory.createNumber(10.2);
		JSONNumber withFloat = JSONFactory.createNumber(22.412312343f);
		JSONNumber withLong = JSONFactory.createNumber(213425245l);
		
		
	}
}
