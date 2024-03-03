import javax.print.attribute.standard.Destination;
import javax.xml.transform.Source;

public class Transaction {
	private int TxnId;
	private String Txndate;
	private double Txnamount;
	private Source Txnsrc;
	private long Srcnumber;
	private Destination TxnDest;
	private long Destnumber;
//	private Wallet wal;

//	public Wallet getWal() {
//		return wal;
//	}
//
//	public void setWal(Wallet wal) {
//		this.wal = wal;
//	}
	public int getTxnId() {
		return TxnId;
	}
	public void setTxnId(int txnId) {
		TxnId = txnId;
	}
	public String getTxndate() {
		return Txndate;
	}
	public void setTxndate(String txndate) {
		Txndate = txndate;
	}
	public double getTxnamount() {
		return Txnamount;
	}
	public void setTxnamount(double txnamount) {
		Txnamount = txnamount;
	}
	public Source getTxnsrc() {
		return Txnsrc;
	}
	public void setTxnsrc(Source txnsrc) {
		Txnsrc = txnsrc;
	}
	public long getSrcnumber() {
		return Srcnumber;
	}
	public void setSrcnumber(long srcnumber) {
		Srcnumber = srcnumber;
	}
	public Destination getTxnDest() {
		return TxnDest;
	}
	public void setTxnDest(Destination txnDest) {
		TxnDest = txnDest;
	}
	public long getDestnumber() {
		return Destnumber;
	}
	public void setDestnumber(long destnumber) {
		Destnumber = destnumber;
	}
	
}
