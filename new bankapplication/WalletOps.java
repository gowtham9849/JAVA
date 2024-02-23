
	
public class WalletOps {
	static double defaultamount = 0;
	public static double Addmoney(double amount) {
		Wallet w1 = new Wallet();
		w1.setAmountlimit(5000);
		defaultamount = amount+defaultamount;
		
		if(defaultamount>w1.getAmountlimit()) {
			System.out.println("Limit Exceded to wallet");
			defaultamount = defaultamount-amount;
		}
		return defaultamount;
	}

	
}
