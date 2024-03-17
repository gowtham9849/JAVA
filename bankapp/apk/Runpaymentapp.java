package bankapp.apk;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bankapp.entity.obj.Acctype;
import bankapp.entity.obj.Bankaccount;
import bankapp.entity.obj.Transaction;
import bankapp.entity.obj.Transactiontype;
import bankapp.entity.obj.Txn;
import bankapp.entity.obj.User;
import bankapp.entity.obj.Wallet;


public class Runpaymentapp {
	static int x = 0;
	public static List<User> userlist = new ArrayList<User>();
	public static List<Bankaccount> Bankacctlist = new ArrayList<Bankaccount>();
	public static Map<Integer, Wallet> Walletlist = new HashMap<Integer , Wallet>();
	public static List<Transaction> TxnList = new ArrayList<Transaction>();
	public static int CurrUserId =-1;

	
	
	public static void main(String[] args) {
//		Fileops fileOps = new Fileops();
//		 try {
//			List<User> userData = fileOps.fileToUser();
//			for(User u : userData) {
//				System.out.println(u.getUserId()+" "+u.getFirstName()+" "+u.getLastName()+" "+u.getPhoneNo()+" "+u.getDateOfBirth()+" "+u.getAddress());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//	}
		int SelectedOption = 0;
		Scanner opt = new Scanner(System.in); 
		
		while(true) {
			System.out.println("please select one Option");
			System.out.println("1.Register New User");
			System.out.println("2.Login");
			System.out.println("3.Add Bank Account");
			System.out.println("4.List Of Users");
			System.out.println("5.Current User");
			System.out.println("6. List of All User Bank Account");
			System.out.println("7.Add Money To Wallet(self)");
			System.out.println("8.Check Balance in Wallet");
			System.out.println("9.Send Money To User(To Do A Transaction)");
			System.out.println("10.///////////////////");
			System.out.println("11.Mini Statement of transaction");
			System.out.println("12.Delete Bank Account");
			System.out.println("13.To Log Out The User");
			System.out.println("14.Add Money to Bank Account");
			System.out.println("15.Check Bank Account Balnace");
			System.out.println("-1.Quit / Exit From Command");
			System.out.println("Choose an Option: ");
			
			String Optstr = opt.next();	
			
		try {
			
			SelectedOption = Integer.parseInt(Optstr);
		
			}catch(NumberFormatException e){
				e.printStackTrace();
				e.getMessage();	
				System.out.println("Number Format Error. Please Choose Another Option.");
			}catch(ArithmeticException e){
				e.printStackTrace();
				e.getMessage();
				System.out.println("Arthemetic Error. Please Choose Another Option.");
			}catch(Exception e){
				e.printStackTrace();
				e.getMessage();
				System.out.println("Some Errors has Occured. Please Choose Another Option.");
			}finally {
				System.out.println();
			}
		
			System.out.println("User selected " + Optstr);
			
			Useroperations ops = new Useroperations();
			
		if(Optstr.equalsIgnoreCase("1")){
			
			registerUser();
			
		}
		else if(Optstr.equalsIgnoreCase("2")) {
			
			
			if(CurrUserId != -1) {
			
				System.out.println("please log out the current User ");
			
			}else {
				loginUser();
			}
			
			
		}
		else if(Optstr.equalsIgnoreCase("3")) {
			
			if(ValidateCurrUser()) {
				
			addBankAccount();
			
			}
		}else if(Optstr.equalsIgnoreCase("4")) {
			
			ops.printUserlist(userlist);
			
			
		}else if(Optstr.equalsIgnoreCase("5")){
			
			if(CurrUserId != -1) {
			ops.Printcurruserdetails(CurrUserId);
			}else{
				System.out.println("No User Has Logged In");
			}
			
		}else if(Optstr.equalsIgnoreCase("6")){

			if(CurrUserId != -1) {
				PrintCurrUserBankaccountList();
			}else {
				System.out.println("Please Login to show bank accounts");
			}
			
			
		}else if(Optstr.equalsIgnoreCase("7")) {
			if(CurrUserId != -1) {
				
				addWallet();
				
			}else {
			System.out.println("User Must Log In to Add Money to wallet");
			}
		}else if(Optstr.equalsIgnoreCase("8")) {
			if(CurrUserId != -1) {
				System.out.println(ops.checkWalletBalance());
			}else {
				System.out.println("Please Log in to Check Balance In Wallet");
			}
		}else if(Optstr.equalsIgnoreCase("9")) {
			if(CurrUserId != -1) {
				Dotransaction();
			}else {
				System.out.println("Please Login to Do Transaction ");
			}
		}else if(Optstr.equalsIgnoreCase("10")) {
			if(CurrUserId != -1) {
				
			}
			else if (Optstr.equalsIgnoreCase("11")) {
			    if (CurrUserId != -1) {
//			        PrintTransactionOfUser();
			    } else {
			        System.out.println("Please Login to view transaction history.");
			    }
			}

		}else if(Optstr.equalsIgnoreCase("12")) {
			if(CurrUserId != -1) {
				 Scanner ot = new Scanner(System.in);
				  Bankaccount ba = new Bankaccount();
				    System.out.println("Enter Bank Account Number: ");
				    long accnum = opt.nextLong();
				DelBankAcc(CurrUserId,accnum, userlist);
			}else {
				System.out.println("please login to delete the bankaccount");
			}
		}else if(Optstr.equalsIgnoreCase("13")) {
			if(CurrUserId != -1) {
				logout();
			}
		}else if (Optstr.equalsIgnoreCase("14")){
			if(CurrUserId != -1) {
				addmoneytoBank();
			}
			
		}else if(Optstr.equalsIgnoreCase("15")) {
			if(CurrUserId != -1) {
				ops.checkBankBalance();
			}
		}
		else if(Optstr.equalsIgnoreCase("-1")) {
			System.out.println("You Have Exit");
			break;
			
				}
			}
		}
	
		public static void registerUser(){
			Scanner opt = new Scanner(System.in); 
			
			Useroperations ops = new Useroperations();
			System.out.println("Please provide user details as asked");
			System.out.println("First Name:");
			String fname = opt.next();
			System.out.println("Last Name : ");
			String lname = opt.next();
			System.out.println("Phone Number : ");
			Long phoneNo = Long.parseLong(opt.next());
			System.out.println("Date Of Birth : ");
			String dob = opt.next();
			System.out.println("Address :");
			String address = opt.next();
			System.out.println("password : ");
			String passWord = opt.next();
			
			User u = null;
			
			try {
				u = ops.douserregistration(fname, lname, phoneNo, dob, passWord, address);
				userlist.add(u);
//				PaymentCLIDAO db = new PaymentCLIDAO();
//				db.UserDb(u);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			Wallet w = new Wallet();
			int UserId = u.getUserId();
			Walletlist.put(UserId, w);
		

		}
		public static boolean loginUser() {
			Scanner opt = new Scanner(System.in); 
			Useroperations ops = new Useroperations();
			
			System.out.println("Login Using UserID");
			System.out.println("Enter UserId : ");
			String Uid =opt.next();
			System.out.println("Enter the Password : ");
			String password = opt.next();
			
			if (ops.verifyuserid(Uid, password)) {
				CurrUserId = Integer.parseInt(Uid);
				System.out.println("Login Successful");
				return true;
			}else {
			System.out.println("Login Failed !");
			return false;
			}
		}
		public static void addBankAccount() {
			
			Bankaccount ba = new Bankaccount();
			
			Scanner opt = new Scanner(System.in);
			System.out.println("Enter Bank Account Number: ");
			long Bankacctnumber = opt.nextLong();
			System.out.println("Enter The Bank Name : ");
			String BankacctBankName = opt.next();
			System.out.println("Enter the Bank Account Pin : ");
			String BankAcctPin = opt.next();
			System.out.println("Enter the Bank IFSC Code:");
			String BankAcctIFSC = opt.next();
			System.out.println("Please Select the Following Account Type : ");
//			System.out.println("SA: SAVINGS");
//			System.out.println("CU: CURRENT");
//			System.out.println("LN: LOAN");
//			System.out.println("SL: SALARY");
			for(Acctype type : Acctype.values()) {
				System.out.println(" "+ type);
			}									//Account Type Enum Selection.
			try {
			String Acty = opt.next();
			Acctype Accty = Acctype.valueOf(Acty);
			ba.setAcctype(Accty);
			}catch(IllegalArgumentException ie) {
				System.out.println("Please Select the Correct Acctype : ");
				for(Acctype type : Acctype.values()) {
					System.out.println(" "+ type);
				}
			}
			
			ba.setBankacctnumber(Bankacctnumber);
			ba.setBankacctBankName(BankacctBankName);
			ba.setBankAcctPin(BankAcctPin);
			ba.setBankAcctIFSC(BankAcctIFSC);
			ba.setUserId(CurrUserId);
			
			
			for(User u:userlist) {
				if(u.getUserId() == CurrUserId) {
					u.getBankacctlist().add(ba);
				}
			}
			

//			PaymentCLIDAO db = new PaymentCLIDAO();
			
//				db.BankDb(ba);
				Bankacctlist.add(ba);
		
		}
		public static boolean ValidateCurrUser() {
			if(CurrUserId != -1) {
				return true;
			}else {
				return false;
			}
		}
		public static void PrintCurrUserBankaccountList() {
			Useroperations ops = new Useroperations();
			Map<User,List<Bankaccount>> mapItems = ops.getUserBankAccount();
			for(User u : mapItems.keySet()) {
				List<Bankaccount> baList = mapItems.get(u);
				System.out.println(u);
				if(baList != null) {
					for(Bankaccount ba : baList) {
						System.out.println("-->" + ba.printBankAcctDetails());
					}
				}
			}
			
		}
	
//			Useroperations ops = new Useroperations();
//			Transaction tx = new Transaction();
//			Map<User,Map<Integer,Transaction>> mapItems = ops.getUserTransaction();
//			for(User u : mapItems.keySet()) {
//				Map<Integer, Transaction> txnList = mapItems.get(u);
//				System.out.println(u);
//				if(txnList != null) {
//					for(Transaction txn : txnList.values()) {
//						System.out.println("-->" + tx.toString());
//					}
//				}
//			}
		
			public static void addWallet() {
				LocalDate date = LocalDate.now();
				Transaction tx = new Transaction();
			Scanner sc = new  Scanner(System.in);
			System.out.println("Enter Amount to Add Wallet : ");
	
			double amount = sc.nextDouble();
			Wallet w = new Wallet();

			w.setWalletlimit(10000);
						if(amount <= 10000.00) {
							Useroperations ops = new Useroperations();
							ops.addMoneytoWallet(amount);
						if(w.getBalance()> w.getWalletlimit()) {
							System.out.println("Wallet amount Exceeded. Wallet Limit is 10000.");
							w.setBalance(w.getBalance()-amount);
							
						}else {
						System.out.println("Maximum Amount Deposit Limit is 10000");
					
						}
			}
}
//		public static void addmoneytoBank() {
//			Scanner sc = new  Scanner(System.in);
//			System.out.println("Enter The Bank Account Number to add Money: ");
//			Bankaccount ba = new Bankaccount();
//			
//			long Accnum = sc.nextLong();
//			 for(User u : userlist) {
//			        
//			            List<Bankaccount> Bankacctlist = u.getBankacctlist();
//			            Iterator<Bankaccount> iterator = Bankacctlist.iterator();
//			            if(iterator.hasNext()) {
//			                Bankaccount acct = iterator.next();
//			                if(acct.getBankacctnumber()== Accnum) {
//			                	System.out.println("Enter the Money To Bank : ");
//			                	double amount = sc.nextDouble();
//			                	
//			                    ba.setBankBal(Bankacctlist.get(CurrUserId).setBankBal(Bankacctlist.get(CurrUserId).getBankBal()+amount));
//			                    System.out.println("Amount Added Success" + ba.getBankBal());
//			                    return;
//			                }
//			            }
//			        
//			    }
//		}
		public static void addmoneytoBank() {
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Enter The Bank Account Number: ");
		    long Accnum = sc.nextLong();

		    for(User u : userlist) {
		        List<Bankaccount> Bankacctlist = u.getBankacctlist();
		        for(Bankaccount acct : Bankacctlist) {
		            if(acct.getBankacctnumber() == Accnum) {
		                System.out.println("Enter the Money To Bank : ");
		                double amount = sc.nextDouble();
		                double newBalance = acct.getBankBal() + amount;
		                acct.setBankBal(newBalance);
		                System.out.println("Amount Added Success. Available Balance: " + acct.getBankBal());
		                return;
		            }
		        }
		    }
		    System.out.println("Account not found.");
		}

		

		public static void DelBankAcc(int UserId, long accnum, List<User> userlist) {
		    for(User u : userlist) {
		        if(u.getUserId() == UserId) {
		            List<Bankaccount> Bankacctlist = u.getBankacctlist();
		            Iterator<Bankaccount> iterator = Bankacctlist.iterator();
		            while(iterator.hasNext()) {
		                Bankaccount acct = iterator.next();
		                if(acct.getBankacctnumber()== accnum) {
		                    iterator.remove();
		                    System.out.println("Bankaccount Deleted Successfully");
		                    return;
		                }
		            }
		        }
		    }
		    System.out.println("Bank Account has not matched");
		}
		
		
		public static void logout() {
			CurrUserId = -1;
			System.out.println("User has Log out");
		}
		public static void Dotransaction() {
			Useroperations ops = new Useroperations();
			Scanner ty = new Scanner(System.in);
			Transaction txn = new Transaction();
			LocalDate date = LocalDate.now();
			Wallet w = new Wallet();
			int i=1;
			for (Txn tx : Txn.values()) {
				System.out.println(i+ " " + tx);
				i++;
			}
			System.out.println("Select The Option To Send or Withdraw : ");
			int option = ty.nextInt();
				if(option == 1) {
					 txn.setTransactiontype(Txn.Debit);
					 System.out.println("Select The Option to Send Money From Which Account: ");
				for(Transactiontype s : Transactiontype.values()) {
					System.out.println(" "+ s ); 			//for Txn Src Enum
					
				}
				try {
					String Src = ty.next();
					Transactiontype Srctype = Transactiontype.valueOf(Src.toUpperCase());
					txn.setTxnsrc(Srctype);
				}catch(IllegalArgumentException e) {
					e.printStackTrace();
					System.out.println("Please Select the Correct Option");
				}
				if(txn.getTxnsrc()==Transactiontype.CASH){
					System.out.println("Enter the User Id To Send Cash : ");
					int Reciever = ty.nextInt();
					Wallet Destination = Walletlist.get(Reciever);
					txn.setDestinationWallet(Destination);
					System.out.println("Enter the Cash To Deposit In Wallet : ");
					double txamount = ty.nextDouble();
					txn.setTransactionDate(date);
					txn.setTxnId(date.toString());
					boolean res = ops.CTransaction(Destination, txn.getTransactiontype(), txamount);
					if(res== true) {
						System.out.println("Transaction completed");
						System.out.println("Your Current Balance : " + Destination.getBalance());
						
							}else
							{
							System.out.println("Transaction Failed");
							}
							
				}
				if(txn.getTxnsrc()==Transactiontype.BANK){
	//					Bankaccount BankAcct = Bankacctlist.get(Runpaymentapp.CurrUserId);
						System.out.println("Select Option to Send Money to Reciever account type");
						System.out.println("BANK");
						System.out.println("WALLET");
						String recieverSrc = ty.next();
						if(recieverSrc.equalsIgnoreCase("BANK")) {
							System.out.println("Amount Will Be Credited in User's Bank Account");
							Bankaccount BankAcct = null;
							 for(Bankaccount b : Bankacctlist) {
								 if(b.getUserId()==CurrUserId) {
									 BankAcct = b;
								 }
							 }
								txn.setSourceBank(BankAcct);
								
								System.out.println("Enter the Bank Account Number to Send : ");
								int RecieverB = ty.nextInt();
								Bankaccount Destination = null;
								for(Bankaccount ba : Bankacctlist) {
									if(ba.getBankacctnumber() == RecieverB) {
										Destination = ba;
									}
								}
								txn.setDestinationBank(Destination);
								
								System.out.println("Enter Amount To Send To Bank : ");
								double Txamount = ty.nextDouble();
								txn.setTransactionDate(date);
								txn.setTxnId(date.toString());
								boolean res = ops.BBTransaction(BankAcct, Destination, txn.getTransactiontype(), Txamount);
								if(res== true) {
									System.out.println("Transaction completed");
									System.out.println("Your Current Balance : " + BankAcct.getBankBal());
										}else{
										System.out.println("Transaction Failed");
										}
								}
							if(recieverSrc.equalsIgnoreCase("WALLET")){
								System.out.println("Amount Will Be Credited in User's Wallet");
								Bankaccount BankAcct = null;
								for(Bankaccount b : Bankacctlist) {
									 if(b.getUserId()==CurrUserId) {
										 BankAcct = b;
									 }
								 }
								txn.setSourceBank(BankAcct);
								System.out.println("Enter the User ID To Send Money To Wallet : ");
								int RecieverW = ty.nextInt();
								Wallet destination = Walletlist.get(RecieverW);
								txn.setDestinationWallet(destination);
								System.out.println("Enter Amount To Send : ");
								double txamount = ty.nextDouble();
								txn.setTransactionDate(date);
								txn.setTxnId(date.toString());
								boolean res = ops.BWTransaction(BankAcct, destination,txn.getTransactiontype(), txamount);
								if(res== true) {
									System.out.println("Transaction completed");
									System.out.println("Your Current Balance : " + BankAcct.getBankBal());
										}else{
										System.out.println("Transaction Failed");
										}
								}
								
							}
					
						
			       }
					if(txn.getTxnsrc()==Transactiontype.WALLET)  {
						
						 System.out.println("Select Option to Send Money to Reciever account type");
						 	System.out.println("BANK");
						 	System.out.println("WALLET");
						 	
						 String recieversrc = ty.next();
						 if(recieversrc.equalsIgnoreCase("WALLET")) {
							 System.out.println("Amount Will Be Sent User Wallet ");
							 Wallet Source = Walletlist.get(Runpaymentapp.CurrUserId);
							 txn.setSourceWallet(Source);
							 System.out.println("Enter The Reciver UserId To Send : ");
							 int Reciever = ty.nextInt();
							 
							 Wallet Destination = Walletlist.get(Reciever);
							 txn.setDestinationWallet(Destination);
							
							 System.out.println("Enter The Amount To Send :");
							 double Txamount = ty.nextDouble() ;
							 txn.setTransactionDate(date);
							 txn.setTxnId(date.toString());
							boolean res = ops.WwTransaction(Source,Destination,txn.getTransactiontype(),Txamount);
								if(res== true) {
							System.out.println("Transaction completed");
							System.out.println("Your Current Balance : " + w.getBalance());
							
								}else
								{
								System.out.println("Transaction Failed");
								
							
							}
						 }
						 if(recieversrc.equalsIgnoreCase("BANK")) {
							
							 System.out.println("Amount Will be Sent to Users Bank Account");
							 Wallet Source = Walletlist.get(Runpaymentapp.CurrUserId);
							 txn.setSourceWallet(Source);
							 System.out.println("Enter The Bank Account Number To Send");
							 int recieverb = ty.nextInt();
							 Bankaccount Destination = null;
								for(Bankaccount ba : Bankacctlist) {
									if(ba.getBankacctnumber() == recieverb) {
										Destination = ba;
									}
								}
							txn.setDestinationBank(Destination);
							System.out.println("Enter Amount to Send Money: ");
							double txamount = ty.nextDouble();
							txn.setTransactionDate(date);
							txn.setTxnId(date.toString());
							boolean res = ops.WbTransaction(Source, Destination, txn.getTransactiontype(), txamount);
							if(res == true) {
								System.out.println("Transaction completed");
								System.out.println("Your Current Balance : " + Destination.getBankBal());
							}else
							{
							System.out.println("Transaction Failed");
							}
						 }
						 TxnList.add(txn);
	
				}
			if(option == 2) {
				System.out.println("in devolopment");
			}
		
		}
//		private static void PrintTransactionOfUser() {
//		    System.out.println("Mini Statement of Transactions:");
//
//		  
//		    for (Transaction txn : TxnList) {
//		     
//		        if (txn.getUserId() == CurrUserId) {
//		           
//		            System.out.println("Transaction ID: " + txn.getTxnId());
//		            System.out.println("Transaction Date: " + txn.getTransactionDate());
//		            System.out.println("Transaction Type: " + txn.getTransactiontype());
//		            System.out.println("Amount: " + txn.getAmount());
//		            System.out.println("----------------------------------");
//		        }
//		    }
//		}

}