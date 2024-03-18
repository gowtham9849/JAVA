package bankapk.jdbc.entity;

public class Wallet {
	private double CurrWalletBalance;
	private double WalletLimit;
	private int UserId;
	public double getCurrWalletBalance() {
		return CurrWalletBalance;
	}
	public double setCurrWalletBalance(double currWalletBalance) {
		this.CurrWalletBalance = currWalletBalance;
		return CurrWalletBalance = currWalletBalance;
	}
	public double getWalletLimit() {
		return WalletLimit;
	}
	public void setWalletLimit(double walletLimit) {
		WalletLimit = walletLimit;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		this.UserId = userId;
	}
	
}