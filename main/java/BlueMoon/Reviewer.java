package BlueMoon;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.util.*;
import java.io.*;

@WebServlet("/Reviewer")
public class Reviewer extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter io = res.getWriter();
		
		res.sendRedirect("ReviewQuiz.jsp");
		//io.print("<html><body>"+req.getParameter("di")+"</body></html>");
	}

}
