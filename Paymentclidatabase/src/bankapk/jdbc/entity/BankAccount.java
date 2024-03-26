package bankapk.jdbc.entity;

public class BankAccount {
	private long AccNo;
	private String AcctBankName;
	private AcctType BankAcctTypeId;
	private String AcctIFSCCode;
	private int AcctPin;
	private double CurrBankBal;
	private int UserId;
	public long getAccNo() {
		return AccNo;
	}
	public void setAccNo(long accNo) {
		AccNo = accNo;
	}
	public String getAcctBankName() {
		return AcctBankName;
	}
	public void setAcctBankName(String acctBankName) {
		AcctBankName = acctBankName;
	}
	public AcctType getBankAcctType() {
		return BankAcctTypeId;
	}
	public void setBankAcctType(AcctType acct) {
		BankAcctTypeId = acct;
	}
	public String getAcctIFSCCode() {
		return AcctIFSCCode;
	}
	public void setAcctIFSCCode(String acctIFSCCode) {
		AcctIFSCCode = acctIFSCCode;
	}
	public int getAcctPin() {
		return AcctPin;
	}
	public void setAcctPin(int acctPin2) {
		AcctPin = acctPin2;
	}
	public double getCurrBankBal() {
		return CurrBankBal;
	}
	public double setCurrBankBal(double currBankBal) {
		this.CurrBankBal = currBankBal;
		return CurrBankBal = currBankBal;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
}