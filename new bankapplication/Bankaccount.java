

public class Bankaccount {
	private String Bankacctnumber;
	private String BankacctBankName;
	private Acctype Acctype;
	private String BankAcctIFSC;
	private String BankAcctPin;
	private int userId;
	
	public String getBankacctnumber() {
		return Bankacctnumber;
	}
	public void setBankacctnumber(String bankacctnumber) {
		Bankacctnumber = bankacctnumber;
	}
	public String getBankacctBankName() {
		return BankacctBankName;
	}
	public void setBankacctBankName(String bankacctBankName) {
		BankacctBankName = bankacctBankName;
	}
	public Acctype getAcctype() {
		return Acctype;
	}
	public void setAcctype(Acctype acctype) {
		Acctype = acctype;
	}
	public String getBankAcctIFSC() {
		return BankAcctIFSC;
	}
	public void setBankAcctIFSC(String bankAcctIFSC) {
		BankAcctIFSC = bankAcctIFSC;
	}
	public String getBankAcctPin() {
		return BankAcctPin;
	}
	public void setBankAcctPin(String bankAcctPin) {
		BankAcctPin = bankAcctPin;
	}
	
	public String printBankAcctDetails() {
		return "["+this.Bankacctnumber+","+this.BankacctBankName+","+this.BankAcctIFSC+","+this.BankAcctPin+","+this.Acctype+"]";		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}