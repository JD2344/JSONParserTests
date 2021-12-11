package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Contains all the testing modules in one place
 * 
 * NOTE:Needs to be run with the JUNIT V5 Api 
 * 
 * @author James Davis - c3576413
 *
 */
@Suite
@SelectClasses({ 
	ArrayTests.class, 
	BooleanTests.class, 
	ExceptionTests.class, 
	JsonValueTest.class, 
	NullTests.class,
	NumberTests.class, 
	ObjectTests.class, 
	ParserTests.class, 
	StringTests.class })
public class AllTests {

}
