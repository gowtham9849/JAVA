
public class WalletOperations  {
	static int defaultBalance=0;
public static int  AddMoney(int a)
{
	
	Wallet w=new Wallet();
	w.setLimit(50000);
	defaultBalance=a+defaultBalance;
	if(defaultBalance>w.getLimit())
	{
	System.out.println("LimitExceeded");
	defaultBalance=defaultBalance-a;
	}
	return defaultBalance;
}
}
