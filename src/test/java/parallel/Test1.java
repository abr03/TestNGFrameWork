package parallel;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void Test() {
		System.out.println("-Test1-Current Thread ID "+Thread.currentThread().getId());
		
		System.out.println("-Test1-Current Thread Name "+Thread.currentThread().getName());
		
		System.out.println("-Test1-Current Thread Priority "+Thread.currentThread().getPriority());
	}
	
	

	@Test
	public void Test2() {
		System.out.println("-Test1-Current Thread ID "+Thread.currentThread().getId());
		
		System.out.println("-Test1-Current Thread Name "+Thread.currentThread().getName());
		
		System.out.println("-Test1-Current Thread Priority "+Thread.currentThread().getPriority());
	}
	
	
	
	@Test
	public void Test3() {
		System.out.println("-Test1-Current Thread ID "+Thread.currentThread().getId());
		
		System.out.println("-Test1-Current Thread Name "+Thread.currentThread().getName());
		
		System.out.println("-Test1-Current Thread Priority "+Thread.currentThread().getPriority());
	}
	}
	
	


