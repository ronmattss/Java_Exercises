package exercise1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exercise1.models.ArmstrongNumber;
class ArmstrongNumberTest {

	@Test
	void test1() {
		
		assertTrue(ArmstrongNumber.getInstance().checkIfArmstrongNumber(1,false));
		
	}
	@Test
	void test11()
	{
		assertFalse(ArmstrongNumber.getInstance().checkIfArmstrongNumber(23,false));
	}

	@Test
	void test2()
	{
		assertTrue(ArmstrongNumber.getInstance().checkIfArmstrongNumber(370,false));
	}
	@Test
	void test3()
	{
		assertTrue(ArmstrongNumber.getInstance().checkIfArmstrongNumber(371,false));
	}
	@Test
	void test4()
	{
		assertTrue(ArmstrongNumber.getInstance().checkIfArmstrongNumber(1634,false));
	}
	@Test
	void test5()
	{
		assertFalse(ArmstrongNumber.getInstance().checkIfArmstrongNumber(1632,false));
	}
	@Test
	void test6()
	{
		assertTrue(ArmstrongNumber.getInstance().checkIfArmstrongNumber(54748,false));
	}
}
