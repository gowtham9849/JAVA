

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Fileops {
	public final String Userfilepath = "C:\\Users\\DT025\\Downloads\\Java8577\\Vijay by 8577\\JAVA\\User_Details.csv";
	public void WriteUsertofile(User u) throws IOException {
		File userfile = new File(Userfilepath);
		FileWriter Uf = new FileWriter(userfile,true);
		Uf.write(u.UserToFile());
		
//		String a = "";
//		List<String> Userf = new  ArrayList<String>();
//		FileReader Ur = new FileReader("C:\\Users\\DT049\\Downloads\\New folder (3)\\User_Details.csv");
//		BufferedReader b = new BufferedReader(Ur);
//		while((a=b.readLine())!= null) {
//			Userf.add(a);
//		}
//		for(String i : Userf) {
//			System.out.println(i);
//		}
//		
		Uf.flush();

		Uf.close();
	
	}
	public List<User> fileToUser() throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(Userfilepath));
		List<User> userlist = new ArrayList<User>();
		String line;
		while((line = br.readLine())!= null) {
			String[] usrdt = line.split(",");
			User user = new User();
			user.setUserId(Integer.parseInt(usrdt[0]));
			user.setFirstName(usrdt[1]);
			user.setLastName(usrdt[2]);
			user.setPhoneNo(Long.parseLong(usrdt[3]));
			user.setDateOfBirth(usrdt[4]);
			user.setAddress(usrdt[5]);
			
			userlist.add(user);
		}
		
		br.close();
		return userlist;
		
		
	}

}