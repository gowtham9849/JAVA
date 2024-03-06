

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Useroperations {
	List<User>users = Runpaymentapp.userlist;
	List<Bankaccount> Bank = Runpaymentapp.Bankacctlist;
	Map<Integer , Wallet> Walletlist = Runpaymentapp.Walletlist; 
//	Map<Integer , Transaction > Txnlist = Runpaymentapp.Txnlist;
	
//	List<User> users = null;
//	List<Bankaccount> Bankacctlist = null;
//	Map<Integer, Wallet> Walletlist = null;
//	public Useroperations() {
//		users = Runpaymentapp.userlist;
//		Bankacctlist = Runpaymentapp.Bankacctlist;
//		Walletlist = Runpaymentapp.Walletlist;
//	}
	
	public User douserregistration(String Fname,String Lname,long phoneNo,String dob,String passWord,String address)throws Exception {
		User u = new User();
		u.setFirstName(Fname);
		u.setLastName(Lname);
		u.setPhoneNo(phoneNo);
		u.setDateOfBirth(dob);
		u.setAddress(address);
		u.setPassWord(passWord);
		
		if((Fname+Lname).length()>50) {
			throw new Exception();
		}
		u.setUserId((int)(Math.random()*1000)+100);
		Fileops fo = new Fileops();
		fo.WriteUsertofile(u);
		return u;
	}
	public void printUserlist(List<User> Users) {
		for(User u:Users) {
			if(Users != null) {
				System.out.println("User Details of "+ u.getFirstName());
				System.out.println(u);
			}
		}
			
		
		
	
		
	}
	
	public boolean verifyuserid(String userId,String password) {
		for(int i=0;i<users.size();i++) {
		if(String.valueOf(users.get(i).getUserId()).equals(userId)) {
			if(password.equals(users.get(i).getPassWord())) {
				return true;
				}
			}
		}
		return false;
	}
	public void Printcurruserdetails(int userId) {
		for(User u : users) {
			if(u.getUserId() == userId) {
				System.out.println(u);
			}else {
				System.out.println("No User Has Been Logged In.");
				break;
			}
		}	
		
		
		
	}
	public Map<User,List<Bankaccount>> getUserBankAccount(){
		Map<User, List<Bankaccount>> userBankAcctMap = new HashMap<User, List<Bankaccount>>() ;
		
		for(User u : users) {
			
			if(users != null) {
				
				userBankAcctMap.put(u,u.getBankacctlist());
			}
		}
		return userBankAcctMap;
	}
	public void addMoneytoWallet(double amount) {
		if(Walletlist.containsKey(Runpaymentapp.CurrUserId)) {
			
			Walletlist.get(Runpaymentapp.CurrUserId).setBalance(Walletlist.get(Runpaymentapp.CurrUserId).getBalance()+amount);
			
			System.out.println("Your Current Balance in your wallet : "+Walletlist.get(Runpaymentapp.CurrUserId).getBalance());
			
		}
	}
	
	public double checkWalletBalance(){
		System.out.println("Your Current Balance in Your Wallet : ");
		return Walletlist.get(Runpaymentapp.CurrUserId ).getBalance();
	}
	public boolean Transaction(Wallet Sender, Wallet receiver, Txn tType, double amount) {
		if(Sender.getBalance()>amount) {
			receiver.setBalance(receiver.getBalance()+ amount);
			Sender.setBalance(Sender.getBalance()-amount);
			return true;	
		}
		return false;
		
		
	}
	
	
}

//}