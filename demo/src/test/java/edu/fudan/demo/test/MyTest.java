package edu.fudan.demo.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import junit.framework.TestCase;

public class MyTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.xml");
	}



	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}



	static Logger log = Logger.getLogger(MyTest.class.getName());

	
	
	@Test
	public void testMy() {
		log.info("This is my test function.");
		System.out.println("");
	}

}
