package bankapk.jdbc.apk;

import java.util.List;

import bankapk.jdbc.entity.AcctType;
import bankapk.jdbc.entity.BankAccount;
import bankapk.jdbc.entity.User;

public class UserOperations {
	List<User> userlist = Runpaymentappjdbc.userlist;
	
	public User UserRegistration(String FirstName,String LastName, Long PhoneNo,String DOB, String Address,String PassWord) throws Exception {
		User u = new User();
		u.setFirstName(FirstName);
		u.setLastName(LastName);
		u.setPhoneNo(PhoneNo);
		u.setDateOfBirth(DOB);
		u.setAddress(Address);
		u.setPassWord(PassWord);
		return u;
	}
	public static boolean ValidateCurrUser() {
		if(Runpaymentappjdbc.CurrUserId != -1) {
			return true;
		}else {
			return false;
		}
	}
	public BankAccount AddBankAcct(long AccNo,String AcctBankName,String AcctIFSCCode,int acctPin) {
		BankAccount ba = new BankAccount();
		ba.setAccNo(AccNo);
		ba.setAcctBankName(AcctBankName);
		
		ba.setAcctIFSCCode(AcctIFSCCode);
		ba.setAcctPin(acctPin);
		return ba;
		
	}
	
}