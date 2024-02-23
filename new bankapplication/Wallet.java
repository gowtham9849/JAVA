

public class Wallet {
	private static  double Balance = 0;
	private double Walletlimit;
	
	public static double getBalance() {
		return Balance;
	}
	public static void setBalance(double balance) {
		Balance = balance;
	}
	public double getWalletlimit() {
		return Walletlimit;
	}
	public void setWalletlimit(double walletlimit) {
		Walletlimit = walletlimit;
	}
		
}
