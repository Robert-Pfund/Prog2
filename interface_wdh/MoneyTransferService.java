package interface_wdh;

import java.math.BigDecimal;

public class MoneyTransferService implements Payment{

	@Override
	public BigDecimal requestBalance(String accountId) {
		
		return new BigDecimal(300);
	}
	
	@Override
	public int makePayment(BigDecimal amount, String fromAccountId, String toAccountId) {
		
		
		return 0;
	}
}
