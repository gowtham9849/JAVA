
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Runpaymentapp {
	static int x = 0;
	public static List<User> userlist = new ArrayList<User>();
	public static List<Bankaccount> Bankacctlist = new ArrayList<Bankaccount>();
	public static int CurrUserId =-1;
	private static Bankaccount ba;
	
	
	public static void main(String[] args) {
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
			System.out.println("7.Add Money To Wallet");
			System.out.println("8. Delete Bank Account");
			System.out.println("-1.Quit / Log Out");
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
			
			loginUser();
			
			
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
			}
			
		}else if(Optstr.equalsIgnoreCase("6")){
			if(CurrUserId != -1) {
				PrintCurrUserBankaccountList();
			}
			
		}else if(Optstr.equalsIgnoreCase("7")) {
			if(CurrUserId != -1) {
				addWallet(CurrUserId);
			}else {
			System.out.println("User Must Log In to Add Money to wallet");
			}
			
		}else if(Optstr.equalsIgnoreCase("8")) {
			if(CurrUserId != -1) {
				delBankAccount();

			if(CurrUserId != -1) {
				PrintCurrUserBankaccountList();
			}
			
			
		}else if(Optstr.equalsIgnoreCase("-1")) {
			System.out.println("You Have Exit");
			break;
			
		}
			  	
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
			
			User u;
			
			try {
				u = ops.douserregistration(fname, lname, phoneNo, dob, passWord, address);
				userlist.add(u);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
//			
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
			Scanner opt = new Scanner(System.in);
			System.out.println("Enter Bank Account Number: ");
			String Bankacctnumber = opt.next(); 
			System.out.println("Enter The Bank Name : ");
			String BankacctBankName = opt.next();
			System.out.println("Enter the Bank Account Pin : ");
			String BankAcctPin = opt.next();
			System.out.println("Enter the Bank IFSC Code:");
			String BankAcctIFSC = opt.next();
			System.out.println("Please Select the Account Type : ");
			System.out.println("SA: SAVINGS");
			System.out.println("CU: CURRENT");
			System.out.println("LN: LOAN");
			System.out.println("SL: SALARY");
//			String Acctype = opt.next();
			for(Acctype type : Acctype.values()) {
				System.out.println(" "+ type);
			}									
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
			

			Bankaccount ba = new Bankaccount();
			ba.setBankacctnumber(Bankacctnumber);
			ba.setBankacctBankName(BankacctBankName);
			ba.setBankAcctPin(BankAcctPin);
			ba.setBankAcctIFSC(BankAcctIFSC);
			ba.setAcctype(Acctype.SALARY);
			ba.setUserId(CurrUserId);
			
			
			for(User u:userlist) {
				if(u.getUserId() == CurrUserId) {
					u.getBankacctlist().add(ba);
				}
			}
			
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
		public static void addWallet(int UserId) {
			Scanner sc = new  Scanner(System.in);
			System.out.println("Enter Amount to Add Wallet : ");
			double amount = sc.nextDouble();
			Wallet w = new Wallet();
			w.setWalletlimit(10000);
			if(amount <= 1000) {				
				Wallet.setBalance(Wallet.getBalance()+amount);
				if(Wallet.getBalance()> w.getWalletlimit()) {
					System.out.println("Wallet amount Exceeded. Wallet Limit is 10000.");
					Wallet.setBalance(Wallet.getBalance()-amount);
				}
				System.out.println("Your Current Balance In wallet : "+Wallet.getBalance());
			}else {
				System.out.println("Maximum Amount Deposit Limit is 1000");
			}
		}

		public static void delBankAccount() {
		    Scanner opt = new Scanner(System.in);

		    System.out.println("Enter Bank Account Number: ");
		    String acNum = opt.next();

		    boolean accountFound = false;
		    for (Bankaccount acct : Bankacctlist) {
		        if (acct.getBankacctnumber().equals(acNum)) {
		           Bankacctlist.remove(acct);
		            accountFound = true;
		            System.out.println("Bank account deleted successfully.");
		             break;
		        }
		    }
		    if (!accountFound) {
		        System.out.println("Account not found.");
		    }
		}
}
