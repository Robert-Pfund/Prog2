package interface_wdh;

public class ExampleWebshop {

	public static void main(String[] args) {
		
		String paymentMethod;
		
		Payment paymentServicePayBuddy = new PayBuddyService();
		Payment paymentServiceMoneyTransfer = new MoneyTransferService();
		
		paymentMethod = "PayBuddy";
		
		
	}	
}
