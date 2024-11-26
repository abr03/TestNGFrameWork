package CrossBroswer;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {
	
	
	@Test
	@Parameters({"Browser","Value"})
	public void param(@Optional("Brave")String Browser, @Optional("20") String Version) {
		
		
		System.out.println("Browser is :"+ Browser + " Version is :"+ Version);
	}

}
