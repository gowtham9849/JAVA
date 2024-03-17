package bankapp.entity.obj;

import java.util.Map;

import bankapp.apk.Runpaymentapp;

public class Wallet {
	private  double Balance;

	private double Walletlimit;
	private int userId;
	Map<Integer , Wallet> Walletlist = Runpaymentapp.Walletlist; 

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return Balance;
	}
	public double setBalance(double balance) {
		this.Balance = balance;
		return balance;
	}
	
	public double getWalletlimit() {
		return Walletlimit;
	}
	public void setWalletlimit(double walletlimit) {
		Walletlimit = walletlimit;
	}
		
}