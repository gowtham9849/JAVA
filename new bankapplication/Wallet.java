

public class Wallet {
	private static  double Balance = 0;
	private double Walletlimit;
private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
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
