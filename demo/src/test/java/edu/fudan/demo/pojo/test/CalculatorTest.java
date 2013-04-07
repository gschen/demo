package edu.fudan.demo.pojo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.fudan.demo.pojo.Calculator;

public class CalculatorTest {

	private Calculator calculator;
	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDivide() {
		assertEquals(5, calculator.divide(10, 2));
		
	}

	@Test
	public void testAdd() {
		assertEquals(5, calculator.add(2, 3));
	}

}
