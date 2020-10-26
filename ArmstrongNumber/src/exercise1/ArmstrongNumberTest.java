package exercise1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exercise1.models.ArmstrongNumberClass;
class ArmstrongNumberTest {

	@Test
	void test1() {
		
		assertTrue(ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(1));
		
	}
	@Test
	void test11()
	{
		assertFalse(ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(23));
	}

	@Test
	void test2()
	{
		assertTrue(ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(370));
	}
	@Test
	void test3()
	{
		assertTrue(ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(371));
	}
	@Test
	void test4()
	{
		assertTrue(ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(1634));
	}
	@Test
	void test5()
	{
		assertFalse(ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(1632));
	}
}
