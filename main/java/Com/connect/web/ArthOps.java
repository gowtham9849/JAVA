package Com.connect.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ArthOps extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ArthOps() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String num3 = request.getParameter("num3");
		int res = Integer.parseInt(num1)+Integer.parseInt(num3);
		

		response.getWriter().write("<html>\r\n"
				+ "    <body>\r\n"
				+ "        <h1>THE CALCULATION OF </h1>\r\n"
				+ "        <h2> "+ res+ "</h2>\r\n"
				+ "    </body>\r\n"
				+ "</html>");

	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
