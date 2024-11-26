import org.testng.annotations.Test;

public class TestngExample2 {
	
	
	public TestngExample2() {
    }

    @Test(
        priority = 1
    )
    public void SystemLogin() {
        System.out.println("Login to the Application:");
    }

    @Test(
        priority = 5
    )
    public void MakePaymentUsingCreditCard() {
        System.out.println("Make Payment using Credit Cart");
    }

    @Test( priority = 4, enabled = false)
    public void MakePaymentUsingDebitCard() {
        System.out.println("Make Payment using Debit Cart");
    }

    @Test(
        priority = 3,
        invocationCount = -4
    )
    public void MakePaymentUsingUPI() {
        System.out.println("Make Payment using UPI ");
    }

    @Test(
        priority = 2
    )
    public void SystemLogout() {
        System.out.println("Logout form application ");
    }
}


