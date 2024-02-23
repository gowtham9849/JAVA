

import java.util.ArrayList;
import java.util.List;

public class User extends Object{
	private String firstName;
	private String lastName;
	private long phoneNo;
	private String DateOfBirth;
	private String Address;
	private int userId;
	private String passWord;
	
	private List<Bankaccount> Bankacctlist = new ArrayList<Bankaccount>();
	
	public List<Bankaccount> getBankacctlist() {
		return Bankacctlist;
	}

	public void setBankacctlist(List<Bankaccount> bankacctlist) {
		Bankacctlist = bankacctlist;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	//Account[]
	//Bank Acccount[]
	
	//Payment Account
	@Override
	public String toString() {
		return this.userId + ":" + this.firstName + ":" + this.lastName+":"+ this.phoneNo+":"+this.DateOfBirth+":"+this.Address+":"+this.passWord;
		
	}
	public String UserToFile() {
		return this.userId + "," + this.firstName + "," + this.lastName+","+ this.phoneNo+","+this.DateOfBirth+","+this.Address+","+this.passWord+"\n";
		
	}
	

	
}
