package bankapp.apk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bankapp.entity.obj.Bankaccount;
import bankapp.entity.obj.User;

public class PaymentCLI {
	
	public void UserDb(User u) throws ClassNotFoundException,SQLException{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentapp","root","root");
			Statement Stmt = Con.createStatement();
			String query = "insert into User_Info12 (First_Name,Last_Name,Phone_No,Date_Of_Birth,Address,Curr_Wallet_Balance)"+
			"values('"+u.getFirstName()+"','"+u.getLastName()+"','"+u.getPhoneNo()+"','"+u.getDateOfBirth()+"','"+u.getAddress()+"','"+0+"')";
			Stmt.executeUpdate(query);
			Con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void BankDb(Bankaccount b) throws SQLException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentapp","root","root");
				Statement Stmt = Con.createStatement();
				String query = "insert into Bank_Account_Details(Bank_AcctNo,Bank_AcctBankName,Bank_IFSC_Code,Bank_AcctPin,Curr_Bank_Balance)"+
				"values('"+b.getBankacctnumber()+"','"+b.getBankacctBankName()+"','"+b.getBankAcctIFSC()+"','"+b.getBankAcctPin()+"','"+0+"')";
				Stmt.executeUpdate(query);
				Con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}