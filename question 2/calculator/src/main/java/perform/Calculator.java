package perform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Calculator() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = null;
		
		
		
		try {
			out = response.getWriter();
			int num1 = Integer.parseInt(request.getParameter("n1"));
			int num2 = Integer.parseInt(request.getParameter("n2"));
			int c= 0;
			
			String op = request.getParameter("btn");
			
			if (op.equals("+")) c = num1 + num2;
			if (op.equals("-")) c = num1 - num2;
			if (op.equals("*")) c = num1 * num2;
			if (op.equals("/")) c = num1 / num2;
			
			out.println("<h3>"+num1+op+num2+"="+c+"</h3>");
			
			
			
		}catch(Exception e) {
				out.println("Error:"+e.getMessage());
		}
		finally {
				out.println("br/");
				out.println("Go to main page ");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
