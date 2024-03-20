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
						
					}else {
						System.out.println("Login To Check Money In Wallet");
					}
				}else if(OptStr.equalsIgnoreCase("10")) {
					if(CurrUserId != -1) {
						
					}else {
						System.out.println("Login To Check Money In Wallet");
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
				u = ops.UserRegistration(FirstName, LastName, PhoneNo, DOB, PassWord, Address);
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
			
				boolean	LoginUser = PaymentCliDao.Logindb(UId, PassWord);
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
			 AcctType Accty = null;
		        while (Accty == null) {
			try {
				System.out.println("Enter a number from 0 to 3:");
		       int Acct_TypeId = opt.nextInt();

		        if (Acct_TypeId < 0 || Acct_TypeId > 3) {
		            System.out.println("Invalid number. Please enter a number from 0 to 3.");
		        } else {
		            AcctType day = AcctType.values()[Acct_TypeId];
		            System.out.println("You selected: " + Acct_TypeId);
		        }
		
			}catch(IllegalArgumentException ie) {
				System.out.println("Please Select the Correct Acctype : ");
				for(AcctType type : AcctType.values()) {
					System.out.println(" "+ type);
				}
			}
		        }
			System.out.println("Enter the Account IFSC Code :");
			String AcctIFSCCode = opt.next();
			System.out.println("Enter the Account Pin : ");
			int AcctPin = opt.nextInt();
			try {
				BankAccount ba = null;
				
				ba =ops.AddBankAcct(AccNo, AcctBankName, Accty, AcctIFSCCode, AcctPin);
				PaymentCliDao db = new PaymentCliDao();
				PaymentCliDao.UserBankDb(u, ba);
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
				PaymentCliDao.AddMoneyToWalletDb();
				System.out.println("Now Your Current Wallet Balance is" + w.getCurrWalletBalance());
			}else {
				System.out.println("Maximum Amount Deposit is 1000");
			}
		}
		

}