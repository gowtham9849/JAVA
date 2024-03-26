package bankapk.jdbc.apk;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bankapk.jdbc.JdbcDao.PaymentCliDao;
import bankapk.jdbc.entity.*;


public class Runpaymentappjdbc {
	public static List<User> userlist = new ArrayList<User>();
	public static int CurrUserId = -1;
		public static void main(String[] args) {
			int SelectedOption = 0;
			Scanner opt = new Scanner(System.in);
			
			while(true) {
				System.out.println("Please Select One Option");
				System.out.println("1. Register New User");
				System.out.println("2. Login");
				System.out.println("3. Add Bank Account to User");
				System.out.println("4. List Of Users.");
				System.out.println("5. Current User Id");
				System.out.println("6. List Current Bank Accounts");
				System.out.println("7. Add Money to Wallet");
				System.out.println("8. Check Amount In Wallet");
				System.out.println("9. Add Money to Bank");
				System.out.println("10. Check Bank Account Balance");
				System.out.println("11. Send Money To Other (Do Transaction)");
				System.out.println("12. Transaction Mini Statement.");
				System.out.println("13. Log Out.");
				System.out.println("Choose an Option:");
				String OptStr = opt.next();
				try {	
				SelectedOption = Integer.parseInt(OptStr);
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
				System.out.println("User Selected " + OptStr);
				
				UserOperations ops = new UserOperations();
				
				
				if(OptStr.equalsIgnoreCase("1")) {
					
						RegisterUser();
					
				}else if(OptStr.equalsIgnoreCase("2")) {
					
						Login();
					
				}else if(OptStr.equalsIgnoreCase("3")) {
					
					if(CurrUserId != -1) {
						AddBankAcc();
					}else {
						System.out.println("Login Add Bank Account");
					}
					
				}else if(OptStr.equalsIgnoreCase("4")) {
					
					PaymentCliDao.PrintUserListDb();
					
				}else if(OptStr.equalsIgnoreCase("5")) {
					if(CurrUserId != -1) {
						PaymentCliDao.CurrLoginUserIdDb();
					}else {
						System.out.println("NO User Has Been Logged In");
					}
				}else if(OptStr.equalsIgnoreCase("6")) {
					if(CurrUserId != -1) {
						PaymentCliDao.BankAcctListDb();
					}else {
						System.out.println("Login see Bank Accounts");
					}
				}else if (OptStr.equalsIgnoreCase("7")) {
					if(CurrUserId != -1) {
						AddMoneyToWallet();
					}else {
						System.out.println("Login To Add Money To Wallet");
					}
				}else if(OptStr.equalsIgnoreCase("8")) {
					if(CurrUserId != -1) {
						PaymentCliDao.CheckCurrWalletBalDb();
					}else {
						System.out.println("Login To Check Money In Wallet");
					}
				}else if(OptStr.equalsIgnoreCase("9")) {
					if(CurrUserId != -1) {
						AddMoneyToBank();
					}else {
						System.out.println("Login To Check Money In Wallet");
					}
				}else if(OptStr.equalsIgnoreCase("10")) {
					if(CurrUserId != -1) {
						CheckBankBanl();
					}else {
						System.out.println("Login To Check Money In Wallet");
					}
				}else if(OptStr.equalsIgnoreCase("11")) {
					if(CurrUserId != -1) {
						try {
							DoTransaction();
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}else {
						System.out.println("Please Login To Do Transaction");
					}
				}else if(OptStr.equalsIgnoreCase("12")) {
					if(CurrUserId != -1) {
						try {
							PaymentCliDao.MiniStatement();
						} catch (Exception e) {
						
							e.printStackTrace();
						}
					}else {
						System.out.println("Please Log In to See Mini Statement");
					}
				}else if (OptStr.equalsIgnoreCase("13")) {
					
					if(CurrUserId != -1) {
						LogOut();
					}else {
						System.out.println("Please Log in To Log Out");
					}
				}
			}
			
	
		}
		public static void RegisterUser(){
			Scanner opt = new Scanner(System.in); 
			
			UserOperations ops = new UserOperations();
			System.out.println("Please provide user details as asked");
			System.out.println("First Name:");
			String FirstName = opt.next();
			System.out.println("Last Name : ");
			String LastName = opt.next();
			System.out.println("Phone Number : ");
			Long PhoneNo = Long.parseLong(opt.next());
			System.out.println("Date Of Birth : ");
			String DOB = opt.next();
			System.out.println("Address :");
			String Address = opt.next();
			System.out.println("password : ");
			String PassWord = opt.next();
			
			User u = null;
			
			try {
				u = ops.UserRegistration(FirstName, LastName, PhoneNo, DOB, Address ,PassWord);
//				userlist.add(u);
				PaymentCliDao db = new PaymentCliDao();
				db.UserRdb(u);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
//			Wallet w = new Wallet();
//			int UserId = u.getUserId();
//			Walletlist.put(UserId, w);
		

		}
		public static void Login() {
			Scanner opt = new Scanner(System.in);
			UserOperations ops = new UserOperations();
			
			System.out.println("Login Through UserId");
			System.out.println("Enter User Id :");
			int UId = opt.nextInt();
			System.out.println("Enter Password :");
			String PassWord = opt.next();
			PaymentCliDao db = new PaymentCliDao();
			
				boolean	LoginUser = db.Logindb(UId, PassWord);
				if(LoginUser) {
					Runpaymentappjdbc.CurrUserId = UId;
					System.out.println("Login successful!");
				}else{
					System.out.println("Login Failed");
				}
			
				
			
			
		}
		public static void AddBankAcc() {
			Scanner opt = new Scanner(System.in);
			User u = new User();
			BankAccount ba = new BankAccount();
			
			UserOperations ops = new UserOperations();
			System.out.println("Add Bank Account Details");
			System.out.println("Enter The Account No : ");
			long AccNo = opt.nextLong();
			System.out.println("Enter the Bank Account Name :");
			String AcctBankName = opt.next();
			System.out.println("Enter the Bank Account Type");
			System.out.println("Please Select The Account Type :");
			for(AcctType type : AcctType.values()) {
			    System.out.println(" "+ type);
			}
			

			try {
				
//			        AcctType Acct = null;
			        
			      
			            System.out.println("Please Select One Option : ");
			            
			            String type = opt.next();
			            AcctType Accty1 = AcctType.valueOf(type);
			            ba.setBankAcctType(Accty1);
			        
			       
			       
			        }catch(IllegalArgumentException ie) {
			    System.out.println("Please Select the Correct Acctype : ");
			    for(AcctType type : AcctType.values()) {
			        System.out.println(" "+ type);
			    }
			}

//			System.out.println("Enter the Bank Account Type");
//			System.out.println("Please Select The Account Type :");
//			for(AcctType type : AcctType.values()) {
//				System.out.println(" "+ type);
//			}
//			 AcctType Accty = null;
//		       
//			try {
//				System.out.println("Enter a number from 1 to 4:");
//		       int Acct_TypeId = opt.nextInt();
//
//		        if (Acct_TypeId < 1 || Acct_TypeId > 4) {
//		        } else {
//		            AcctType day = AcctType.values()[Acct_TypeId];
//		             System.out.println("Invalid number. Please enter a number from 1 to 4.");
//		           System.out.println("You selected: " + Acct_TypeId);
//		        }
//		
//			}catch(IllegalArgumentException ie) {
//				System.out.println("Please Select the Correct Acctype : ");
//				for(AcctType type : AcctType.values()) {
//					System.out.println(" "+ type);
//				}
//			}
		        
			System.out.println("Enter the Account IFSC Code :");
			String AcctIFSCCode = opt.next();
			System.out.println("Enter the Account Pin : ");
			int AcctPin = opt.nextInt();
			try {
				BankAccount ba1 = null;
				
				
				ba1 =ops.AddBankAcct(AccNo, AcctBankName, AcctIFSCCode, AcctPin);
			    
		
				PaymentCliDao.UserBankDb(u, ba1);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void AddMoneyToWallet() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Your Adding Amount To Wallet");
			System.out.println("Enter The Amount to Add Wallet : ");
			double Wamount = sc.nextDouble();
			Wallet w = new Wallet ();
			w.setWalletLimit(5000);
			if(Wamount <= 1000) {
				w.setCurrWalletBalance(Wamount);
				PaymentCliDao.AddMoneyToWalletDb(Wamount);
				System.out.println(w.getCurrWalletBalance()+" Is Added To Your Wallet.");
			}else {
				System.out.println("Maximum Amount Deposit is 1000");
			}
		}
		public static void AddMoneyToBank() {
			Scanner sc = new Scanner(System.in);
			BankAccount ba = new BankAccount();
			PaymentCliDao db = new PaymentCliDao();
				System.out.println("Enter the amount to add Bank :");
				double Bamount= sc.nextDouble();
				System.out.println("Enter the Account Number To Send Money:");
				long AccNo = sc.nextLong();
				if(PaymentCliDao.VerifyAccountNo(AccNo)) {
					PaymentCliDao.AddMoneyToBankDb(Bamount,AccNo);
					
					
				}
		}
		public static void CheckBankBanl(){
			Scanner sc = new Scanner(System.in);
			BankAccount ba = new BankAccount();
			
			System.out.println("Enter the Account Number :");
			long AccNo = sc.nextLong();
			
			
			PaymentCliDao.VerifyAccountNo(AccNo);
				PaymentCliDao.CheckCurrBankBalDb(AccNo);
				
				
	
			
		}
		public static void LogOut() {
			System.out.println( CurrUserId +" UserId Has Been Logged Out");
			CurrUserId =-1;
			
		}
		public static void DoTransaction() throws Exception{
			Scanner sc = new Scanner(System.in);
			System.out.println("Send Money To Others");
			
				try {
				System.out.println("1.Wallet to Wallet");
				System.out.println("2.Bank Account To Bank Account");
				System.out.println("3.Wallet To Bank Account");
				System.out.println("4.Bank Account To Wallet");
				System.out.println("please Select On Option: ");
				String SelectOpt = sc.next();
				if(SelectOpt.equalsIgnoreCase("1")) {
					System.out.println("Enter the User ID to Send the Amount : ");
					int Reciever = sc.nextInt();
					
					if(PaymentCliDao.VerifyUserId(Reciever)) {
						System.out.println("User Found");	
						System.out.println("Enter the amount to send the amount : ");
						double TxnAmount = sc.nextDouble();
						int Sender = CurrUserId;
						
						PaymentCliDao.DoWWTransaction(Sender,Reciever,TxnAmount);
					}
					
				}else if (SelectOpt.equalsIgnoreCase("2")) {
					System.out.println("Enter the Account Number To Credit The Amount: ");
					long DBank = sc.nextLong();
					if(PaymentCliDao.VerifyAccountNo(DBank)) {
						System.out.println("Enter the Amount To Send");
						double TxnAmount = sc.nextDouble();
						System.out.println("Enter the Account Number To Debit The Amount: ");
						long SBank = sc.nextLong();
						if(PaymentCliDao.VerifyAccountNo(SBank)) {
							PaymentCliDao.DoBBTransaction(DBank,TxnAmount,SBank);
						}
						
						
					}
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
			
			
			
		}

}