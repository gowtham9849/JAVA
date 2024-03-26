package bankapk.jdbc.JdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import bankapk.jdbc.apk.Runpaymentappjdbc;
import bankapk.jdbc.entity.AcctType;
import bankapk.jdbc.entity.BankAccount;
import bankapk.jdbc.entity.User;
import bankapk.jdbc.entity.Wallet;

public class PaymentCliDao {
	
	
	public static void UserRdb(User u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String Uquery = "insert into User_Info(First_Name,Last_Name,Phone_No,Date_Of_Birth,Address,PassWord,Curr_Wallet_Balance)" + "values "
					+ "('"+u.getFirstName()+"','"+u.getLastName()+"','"+u.getPhoneNo()+"','"+u.getDateOfBirth()+"','"+u.getAddress()+"','"+u.getPassWord()+"','"+0+"')";
			Stm.executeUpdate(Uquery);
			Stm.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}	
	}
	public static boolean Logindb(int Uid ,String PassWord) {
		User u = new User();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();

//			String Uquery = "Select User_Id,PassWord from User_Info where User_Id = '"+u.getUserId()+"'and PassWord ='"+u.getPassWord()+"'";
//			ResultSet res = Stm.executeQuery(Uquery);	
//			res.next();
//			return;
			   String Uquery = "Select User_Id,PassWord from User_Info where User_Id = ? and PassWord = ?";
	            PreparedStatement ps = Con.prepareStatement(Uquery);
	            ps.setInt(1, Uid);
	            ps.setString(2, PassWord);
	            ResultSet res = ps.executeQuery();
	            return res.next();
		
		

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		return false;
	}
	public static void UserBankDb(User u, BankAccount ba) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String BankQuery = "insert into Bank_Account_Details (Bank_AcctNo,Bank_AcctBankName,Acct_TypeId,Bank_IFSC_Code,Bank_User_Id,Bank_AcctPin,Curr_Bank_Balance) values ('"
					+ ba.getAccNo() + "','" + ba.getAcctBankName() + "','" + ba.getBankAcctType() + "','" + ba.getAcctIFSCCode() + "','" +Runpaymentappjdbc.CurrUserId +"', '" + ba.getAcctPin() + "','" + 0 + "')";

					Stm.executeUpdate(BankQuery);

			Stm.close();
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}	
		
	}
	public static void PrintUserListDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String UserList = "Select * from User_Info";
			ResultSet res = Stm.executeQuery(UserList);
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2));
			}
			Stm.close();
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
	}
	public static void CurrLoginUserIdDb() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String CurrLoginUser = "Select * from User_Info where User_Id = '"+Runpaymentappjdbc.CurrUserId+"'";
			ResultSet res = Stm.executeQuery(CurrLoginUser);
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2));
			}
			Stm.close();
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void BankAcctListDb() {
		BankAccount ba = new BankAccount();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String BankUserList = "Select * from Bank_Account_Details where Bank_User_Id = '"+Runpaymentappjdbc.CurrUserId+"'";
			ResultSet res = Stm.executeQuery(BankUserList);
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2));
			}
			Stm.close();
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void AddMoneyToWalletDb(double Wamount) {
		Wallet wa = new Wallet();
		User u = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1t:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String Waquery = "Update User_Info Set Curr_Wallet_Balance = Curr_Wallet_Balance + '"+Wamount+"' where User_Id = '"+Runpaymentappjdbc.CurrUserId+"'";
			Stm.executeUpdate(Waquery);
			String Bquery = "Select Curr_Wallet_Balance from User_Info where User_Id = '"+Runpaymentappjdbc.CurrUserId+"'";
			
			ResultSet res = Stm.executeQuery(Bquery);
			if(res.next()) {
				System.out.println(" Your current Wallet_Balance is "+res.getInt(1));
			}else{
				
				System.out.println("User Not Found!");
			
			}
			

			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}	
	}
	public static void CheckCurrWalletBalDb() {
		User u = new User();
		Wallet w  =new Wallet();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String Waquery = "Select Curr_Wallet_Balance from User_Info where User_Id = '"+Runpaymentappjdbc.CurrUserId+"'";
			ResultSet res = Stm.executeQuery(Waquery);
			while(res.next()) {
				System.out.println(" Your current Wallet_Balance is "+res.getInt(1));
			}
			Stm.executeQuery(Waquery);
			Stm.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void AddMoneyToBankDb(double Bamount,long AccNo) {
		BankAccount ba = new BankAccount();
		User u = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			
			String Baquery = "Update Bank_Account_Details Set Curr_Bank_Balance = Curr_Bank_Balance + '"+Bamount+"' where Bank_AcctNo = '"+AccNo+"' ";
			Stm.executeUpdate(Baquery);
			String Bquery = "Select Curr_Bank_Balance from Bank_Account_Details where Bank_AcctNo = '"+AccNo+"'";
			
			ResultSet res = Stm.executeQuery(Bquery);
			if(res.next()) {
				System.out.println(" Your current Wallet_Balance is "+res.getInt(1));
			}else{
				
				System.out.println("User Not Found!");
			
			}
			Stm.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void CheckCurrBankBalDb(long AccNo) {
		User u = new User();
		BankAccount ba = new BankAccount();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String Waquery = "Select Curr_Bank_Balance from Bank_Account_Details where Bank_AcctNo = '"+AccNo+"'";
			
			ResultSet res = Stm.executeQuery(Waquery);
			if(res.next()) {
				System.out.println(" Your current Bank_Balance is "+res.getDouble(1));
			}
			Stm.executeQuery(Waquery);
			
			Stm.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static boolean VerifyAccountNo(long AccNo) {
		BankAccount ba =new BankAccount();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String Uquery = "Select * from Bank_Account_Details where Bank_User_Id = '"+Runpaymentappjdbc.CurrUserId+"'and Bank_AcctNo ='"+AccNo+"'";
			
			ResultSet res = Stm.executeQuery(Uquery);
			if(res.next()) {
				System.out.println("Account Found!");
				return true;
			}else{
				
				System.out.println("Account Not Found!");
			
			}
			Stm.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public static boolean VerifyUserId(int Reciever) {
		User u = new User();
		boolean UserExist = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String Uquery = "Select User_Id from User_Info where User_Id = '"+Reciever+"'";
			ResultSet res = Stm.executeQuery(Uquery);
			if(res.next()) {
				UserExist = true;
				return true;
			}else{
				
				System.out.println("User Not Found!");
			
			}
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}
	public static void DoWWTransaction(int Sender, int Reciever, double TxnAmount) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String SenderType = "DEBIT";
			String RecieverType ="CREDIT";
			String Txn_AcctType = "Wallet";
			LocalDateTime now = LocalDateTime.now();
			
			UUID UuiS = UUID.randomUUID();
			UUID UuiD = UUID.randomUUID();
			String TxnIdS = "TXNS" + UuiS.toString(); 
			String TxnIdD = "TXND" + UuiD.toString();
			
			String Bquery = "Select Curr_Wallet_Balance from User_Info where User_Id = '"+Runpaymentappjdbc.CurrUserId+"'";
			
			String Squery = "Update User_Info Set Curr_Wallet_Balance = Curr_Wallet_Balance - '"+TxnAmount+"' where User_Id = '"+Sender+"'";
			
			String Rquery = "Update User_Info Set Curr_Wallet_Balance = Curr_Wallet_Balance + '"+TxnAmount+"' where User_Id = '"+Reciever+"'";
			
			
			String Tquery = "INSERT INTO Transaction (Txn_Id, Txn_Date, Txn_Amount, Txn_Type, Txn_AcctType, Txn_User_Id) VALUES " + 
			        "('" + TxnIdS + "', '" + now + "', " + TxnAmount + ", '" + SenderType + "', '" + Txn_AcctType + "', '" + Sender + "')";


			String Tdquery = "insert into Transaction (Txn_Id,Txn_Date,Txn_Amount,Txn_Type,Txn_AcctType,Txn_User_Id) values "+ 
					"('"+TxnIdD+"','"+now+"','"+TxnAmount+"','"+RecieverType+"','"+Txn_AcctType+"','"+Reciever+"')";
				
			Stm.executeUpdate(Tquery);
			Stm.executeUpdate(Tdquery);
			
			
			
			
			Stm.executeUpdate(Squery);
			Stm.executeUpdate(Rquery);
			ResultSet res = Stm.executeQuery(Bquery);
			if(res.next()) {
				System.out.println(" Your current Wallet_Balance is "+res.getInt(1));
			}else{
				
				System.out.println("User Not Found!");
			
			}
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void DoBBTransaction(long SBank,double TxnAmount,long DBank) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String SenderType = "DEBIT";
			String RecieverType ="CREDIT";
			String Txn_AcctType = "BANK ACCOUNT";
			LocalDateTime now = LocalDateTime.now();
			UUID UuiS = UUID.randomUUID();
			UUID UuiD = UUID.randomUUID();
			String TxnIdS = "TXNS" + UuiS.toString(); 
			String TxnIdD = "TXND" + UuiD.toString();
			String Bquery = "Select Bank_User_Id from Bank_Account_Details where Bank_AcctNo = '"+DBank+"'";
			
			ResultSet res = Stm.executeQuery(Bquery);
			res.next();
			int duser = res.getInt(1);

			String Squery = "Update Bank_Account_Details Set Curr_Bank_Balance = Curr_Bank_Balance - '"+TxnAmount+"' where Bank_AcctNo = '"+SBank+"'";
			
			String Rquery = "Update Bank_Account_Details Set Curr_Bank_Balance = Curr_Bank_Balance + '"+TxnAmount+"' where Bank_AcctNo = '"+DBank+"'";
			Stm.executeUpdate(Squery);
			Stm.executeUpdate(Rquery);
			
			
			String Tquery = "INSERT INTO Transaction (Txn_Id, Txn_Date, Txn_Amount, Txn_Type, Txn_AcctType, Txn_User_Id) VALUES " + 
			            "('" + TxnIdS + "', '" + now + "', " + TxnAmount + ", '" + SenderType + "', '" + Txn_AcctType + "', '" + Runpaymentappjdbc.CurrUserId + "')";

			String TxnQ = "INSERT INTO Transaction (Txn_Id, Txn_Date, Txn_Amount, Txn_Type, Txn_AcctType, Txn_User_Id) VALUES " + 
		            "('" + TxnIdS + "', '" + now + "', " + TxnAmount + ", '" + SenderType + "', '" + Txn_AcctType + "', '" + duser+ "')";


			
			Stm.executeUpdate(Tquery);
			Stm.executeUpdate(TxnQ);

			
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void MiniStatement() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Paymentapp", "root", "root");
			Statement Stm = Con.createStatement();
			String Uquery = "Select * from Transaction where Txn_User_Id = '"+Runpaymentappjdbc.CurrUserId+"'";
			ResultSet res = Stm.executeQuery(Uquery);
			if(res.next()) {
				System.out.println("Mini Statement Transaction Till Now ");
				System.out.println("Trasaction Id : "+res.getString(1)+ " Transaction Date : "+ res.getDate(2)+ " Transaction Amount : " + res.getDouble(3)+" Type : " + res.getString(4)+" Source : "+ res.getString(5)+ " User Id : " +res.getInt(6));
			}else{
				
				System.out.println("User Not Found!");
			
			}
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
	