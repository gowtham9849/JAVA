package bankapp.apk;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bankapp.entity.obj.Bankaccount;
import bankapp.entity.obj.Transaction;
import bankapp.entity.obj.Txn;
import bankapp.entity.obj.User;
import bankapp.entity.obj.Wallet;



public class Useroperations {
	List<User>users = Runpaymentapp.userlist;
	List<Bankaccount> Bank = Runpaymentapp.Bankacctlist;
	Map<Integer , Wallet> Walletlist = Runpaymentapp.Walletlist; 
	Map<Integer , Transaction > Txnlist = Runpaymentapp.Txnlist;
	
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
//		Fileops fo = new Fileops();
//		fo.WriteUsertofile(u);
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
//	public void minitransaction(int UserId) {
//		for(User u : users) {
//			if(u)
//		}
//	}
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
	public double checkBankBalance() {
		Scanner ops = new Scanner(System.in);
		System.out.println("Enter The Account Numer To Check The Bank Balance : ");
		long Accnum = ops.nextLong();
		
		for(User u : users) {
	        List<Bankaccount> Bankacctlist = u.getBankacctlist();
	        for(Bankaccount acct : Bankacctlist) {
	            if(acct.getBankacctnumber() == Accnum) {
	                System.out.println("Your Current Bank Balance is :  ");
	                
	                
	                acct.getBankBal();
	                System.out.println("Your Current Bank Balance is : " + acct.getBankBal());
	                return acct.getBankBal();
	            }
	        }
	    }
		return Accnum;
	
		
	}
	public boolean WTransaction(Wallet Sender, Wallet Receiver, Txn tType, double amount) {
		if(Sender.getBalance()>amount) {
			Receiver.setBalance(Receiver.getBalance()+ amount);
			Sender.setBalance(Sender.getBalance()-amount);
			return true;	
		}
		return false;
	}
	public boolean CTransaction(Wallet Reciever, Txn tType, double amount) {
		if(amount >= 0) {
			Reciever.setBalance(Reciever.getBalance()+ amount);
			return true;
		}
		return false;
	}
	public boolean BTransaction(Bankaccount Sender, Bankaccount Reciever, Txn tType, double amount) {
		if(Sender.getBankBal()>amount) {
			Reciever.setBankBal(Reciever.getBankBal()+amount);
			Sender.setBankBal(Sender.getBankBal()-amount);
			return true;
		}
		return false;
		
	}
	
}

//}