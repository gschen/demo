package edu.fudan.demo.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubtract() {
//		fail("Not yet implemented");
		assertEquals(5, new Calculator().subtract(10, 5));
	}

}
