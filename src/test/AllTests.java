package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Contains all the testing modules in one place
 * 
 * @author James Davis - c3576413
 *
 */
@Suite
@SelectClasses({ 
	ArrayTests.class, 
	BooleanTests.class, 
	ExceptionTests.class, 
	JsonTest.class, 
	NullTests.class,
	NumberTests.class, 
	ObjectTests.class, 
	ParserTests.class, 
	StringTests.class })
public class AllTests {

}
