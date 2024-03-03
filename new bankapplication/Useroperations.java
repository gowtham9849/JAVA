

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



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
	public void Dotransaction() {
		Scanner ty = new Scanner(System.in);
		Transaction txn = new Transaction();
		Wallet w = new Wallet();
//		User u = new User();
		System.out.println("Select The Option to Send Money From Which Account: ");
		for(Source s : Source.values()) {
			System.out.println(" "+ s ); 			//for Txn Src Enum
		}
		try {
		String Src = ty.next();
		Source Srctype = Source.valueOf(Src.toUpperCase());
		txn.setTxnsrc(Srctype);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Please Select the Correct Option");
		}
		if(txn.getTxnsrc()==Source.CASH){
		
		      System.out.println("Enter the Source Amount : ");
		       txn.setTxnamount(ty.nextDouble());
		        double amount = txn.getTxnamount();
		        System.out.println("Enter the Destination UserID To Send the money : ");
		        int Destuid = ty.nextInt();
		        for(User user : users) {
		            if(user.getUserId() == Destuid) {
		            
//		               Walletlist.put(Destuid, w.setBalance(amount + w.getBalance()));
		            	
		            	
		            	
		                System.out.println("Amount Sent to "+ Destuid +" Successfully");
		                break;
		            } else {
		                System.out.println("User Id Entered is Not Found");
		            }
		        }
					
		}else if(txn.getTxnsrc()==Source.BANK){
			
			
	        System.out.println("Enter the Source Amount : ");
	        txn.setTxnamount(ty.nextDouble());
	        double amount = txn.getTxnamount();
	        System.out.println("Enter the Bank Account Number : ");
	        long DestAcctNo = ty.nextLong();
	        for(Bankaccount ba : Bank) {
	            if(ba.getBankacctnumber() == DestAcctNo) {
	            	
	            	
	            	
	            	
	                w.setBalance(amount + w.getBalance());
	                System.out.println("Amount Sent to this Account Number "+ DestAcctNo +" Successfully");
	            } else {
	                System.out.println("Account Number Entered is Not Found");
	            }
	        }

		}else if (txn.getTxnsrc()==Source.WALLET)  {
			System.out.println("Enter the Source Amount : ");
			txn.setTxnamount(ty.nextDouble());
			double amount = txn.getTxnamount();
			if(w.getBalance()>= amount) {
				System.out.println("Enter the UserId : ");
				int Destuid1 = ty.nextInt();
				for(User user : users) {
					if(user.getUserId() == Destuid1) {
						
						
						
						w.setBalance(amount+ w.getBalance());
						System.out.println("Amount Sent to "+ Destuid1 +" Successfull");
					}
				}
			}else {
				System.out.println("User Id Entered is Not Found");
			}
		}
	}
}