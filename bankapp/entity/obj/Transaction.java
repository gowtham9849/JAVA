package bankapp.entity.obj;
import java.time.LocalDate;

public class Transaction {
	private String TxnId;
	private LocalDate TransactionDate;
	private double txnamount;
	private Txn Transactiontype;
	private Transactiontype Txnsrc;
	private int UserId;
	private Transactiontype TxnDest;
	Wallet sourceWallet;
	Wallet destinationWallet;
	Bankaccount SourceBank;
	
	public Bankaccount getSourceBank() {
		return SourceBank;
	}


	public void setSourceBank(Bankaccount sourceBank) {
		SourceBank = sourceBank;
	}


	public Bankaccount getDestinationBank() {
		return DestinationBank;
	}


	public void setDestinationBank(Bankaccount destinationBank) {
		DestinationBank = destinationBank;
	}

	Bankaccount DestinationBank;
	
	
	public String getTxnId() {
		return TxnId;
	}


	public void setTxnId(String txnId) {
		TxnId =txnId;
	}


	public LocalDate getTransactionDate() {
		return TransactionDate;
	}


	public void setTransactionDate(LocalDate transactionDate) {
		TransactionDate = transactionDate;
	}


	public double getTxnamount() {
		return txnamount;
	}


	public void setTxnamount(double txnamount) {
		this.txnamount = txnamount;
	}


	public Transactiontype getTxnsrc() {
		return Txnsrc;
	}


	public void setTxnsrc(Transactiontype txnsrc) {
		Txnsrc = txnsrc;
	}


	public int getUserId() {
		return UserId;
	}


	public void setUserId(int userId) {
		UserId = userId;
	}


	public Transactiontype getTxnDest() {
		return TxnDest;
	}


	public void setTxnDest(Transactiontype txnDest) {
		TxnDest = txnDest;
	}


	public Wallet getSourceWallet() {
		return sourceWallet;
	}


	public void setSourceWallet(Wallet sourceWallet) {
		this.sourceWallet = sourceWallet;
	}


	public Wallet getDestinationWallet() {
		return destinationWallet;
	}


	public void setDestinationWallet(Wallet destinationWallet) {
		this.destinationWallet = destinationWallet;
	}
	
	public Txn getTransactiontype() {
		return Transactiontype;
	}


	public void setTransactiontype(Txn transactiontype) {
		Transactiontype = transactiontype;
	}

	@Override
	public String toString() {
		return "--->" +": Transaction ID " + TxnId + "Transaction date : " + TransactionDate 
				+ "Transaction Amount: "+txnamount + "Transaction Source Type" + Txnsrc 
				+" Amount sent to UserId "+ UserId + "Transaction Destination Type"
				+ TxnDest ;
	}
//	public String PrintTxn(){
//		return"--->" +": Transaction ID " + TxnId + "Transaction date : " + TransactionDate 
//				+ "Transaction Amount: "+txnamount + "Transaction Source Type" + Txnsrc 
//				+" Amount sent to UserId "+ UserId + "Transaction Destination Type"
//				+ TxnDest;
//
//	}
}
