

public class Wallet {
    private static int defaultBal;
	private int userId;
	private int limit;
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public static int getDefaultBal() {
		return defaultBal;
	}
	public void setDefaultBal(int defaultBal) {
		Wallet.defaultBal = defaultBal;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
