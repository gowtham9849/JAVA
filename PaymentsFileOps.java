

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PaymentsFileOps {
	public final String usersFilePath = "C:\\Users\\siva ganesh\\Downloads\\files\\Payments_CLI_USers.csv";
	
	public void writeUserToFile(User u) throws IOException {
		
		File userFile = new File(usersFilePath);
		FileWriter fw = new FileWriter(userFile,true);
		fw.write(u.userToFileRecord());
		
		
		String a="";
		List<String> los=new ArrayList<String>();
		FileReader f2=new FileReader(userFile);
		BufferedReader b=new BufferedReader(f2);
		while((a=b.readLine())!=null)
		{
			los.add(a);
		}
		fw.flush();
		fw.close();
	}

}
