package Assertion;

import org.testng.annotations.Test;

public class TestingInvocationCount {

	
		@Test(groups = "Smoke")
		public void test1()
		{
			System.out.println("Hello 1");
		}
		
		@Test(groups = {"Smoke","Regression"})
		public void test2()
		{
			System.out.println("Hello 2");
		}
		
		@Test(groups = "Regression")
		public void test3()
		{
			System.out.println("Hello 3");
		}
		
		@Test(groups = "Regression")
		public void test4()
		{
			System.out.println("Hello 4");
		}
		
		@Test
		public void test5()
		{
			System.out.println("Hello 5");
		}


}
