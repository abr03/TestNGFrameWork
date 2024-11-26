package Assertion;

import org.testng.annotations.Test;

public class CyclicDependency {
	

	@Test 
	public void Login() {
		System.out.println(3/3);

		System.out.println("Login");
	}
	
	
	
	@Test (dependsOnMethods = "Login")
	
	public void Logout() {
		System.out.println(3/3);

		System.out.println("Logout");
	}

}


