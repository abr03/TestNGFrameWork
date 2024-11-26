package Assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	

		
		// call assertAll at end always
		
		@Test
		public void test1()
		{
			System.out.println("Start");
			
			SoftAssert softAssert=new SoftAssert();
			
			softAssert.assertEquals(12, 13);
			
			softAssert.assertEquals(12.2, 13.2);
			
			softAssert.assertEquals("Mukesh", "mukesh");
			
			softAssert.assertTrue(false);
			
			softAssert.assertFalse(true);
		
			System.out.println("End");
			
			softAssert.assertAll();
			
		}

	}



