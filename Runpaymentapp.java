package bankapp.apk;

import java.util.Scanner;

import bankapp.entity.User;

public class Runpaymentapp {
	static int x = 0;
	public static User[] userlist = new User[10];
	public static void main(String[] args) {
		int SelectedOption = 0;
		int c = -1;
		while(true) {
			System.out.println("please select one Option");
			System.out.println("1.Register");
			System.out.println("2.Login");
			System.out.println("3.Add Bank Account");
			System.out.println("4.List Of Users");
			System.out.println("-1.Quit");
			System.out.println("Choose atleast one Option");
			Scanner opt = new Scanner(System.in); 
			String Optstr = opt.next();	
			System.out.println("User selected " + Optstr);
		try {
			SelectedOption = Integer.parseInt(Optstr);
		}catch(NumberFormatException Ea){
			Ea.printStackTrace();
			Ea.getMessage();			
		}catch(ArithmeticException Ex){
			Ex.printStackTrace();
			Ex.getMessage();
			System.out.println("Some Errors has Occured in Athematic");
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
			System.out.println("Some Errors has Occured");
		}finally {
			System.out.println("Finnally");
		}
		
		Useroperations ops = new Useroperations();
		
		if(Optstr.equalsIgnoreCase("1")){
			System.out.println("Please provide user details as asked");
			System.out.println("First Name:");
			String fname = opt.next();
			System.out.println("Last Name : ");
			String lname = opt.next();
			System.out.println("Phone No : ");
			Long phoneNo = Long.parseLong(opt.next());
			System.out.println("Date Of Birth : ");
			String dob = opt.next();
			System.out.println("Address :");
			String address = opt.next();
			System.out.println("passWord : ");
			String passWord = opt.next();
			
			User u = ops.douserregistration(fname, lname, SelectedOption, dob, address, SelectedOption, passWord);
			for(int i=0;i<userlist.length;i++) {
				if(userlist[i]==null) {
					c=i;
				}
				if(c!=-1) {
					userlist[c] = u;
				}
				c++;
				break;
			}
		}
		else if(Optstr.equalsIgnoreCase("2")) {
			
		}
		else if(Optstr.equalsIgnoreCase("3")) {
			
		}else if(Optstr.equalsIgnoreCase("4")) {
			ops.printUserlist(userlist);
		}
		else if(Optstr.equalsIgnoreCase("-1")) {
			System.out.println("You Have Exit");
			break;
			
		}
		}
		
//		if(str.equals("1")||str.equals("2")||str.equals("3")) {
//			SelectedOption = Integer.parseInt(str);
//		}else {
//			System.out.print("Choose option in the range of 1 to 3");
//		}		
	}
}
