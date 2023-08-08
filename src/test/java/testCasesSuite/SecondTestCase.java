package testCasesSuite;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTestCase {
	@AfterClass
	void  AfterClass()
	{
		System.out.println("---------------------------------------------");
	}
	@BeforeClass
	void  BeofreClass()
	{
		System.out.println("---------------------------------------------");
	}
	@Test(priority=1)
	void setUp()
	{
		System.out.println("This is Test Method");
	}
	@Test(priority=2)
	void SearchCostomer()
	{
		System.out.println("This is SearchCostomer");
	}
	@Test(priority=3)
	void addCustomer()
	{
		System.out.println("This is addCustomer");
	}

}
