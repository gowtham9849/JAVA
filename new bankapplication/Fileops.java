

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Fileops {
	public final String Userfilepath = "C:\\file pat\\User_Details.csv";
	public void WriteUsertofile(User u) throws IOException {
		File userfile = new File("C:\\file pat\\User_Details.csv");
		FileWriter Uf = new FileWriter(userfile,true);
		Uf.write(u.UserToFile());
		Uf.flush();
		String a = "";
	
		Uf.close();
		
		FileReader Ur = new FileReader("C:\\file pat\\\\User_Details.csv");
		
	}

}
