
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet Mapping 방법:annotation , web.xml
//1.annotation 방식:권장사항. 골뱅이 부분
//@WebServlet("/CH02_start/Start_Xml")
public class Start_xml extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><body>"+name+"환영합니다</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	
	
	
	
	}

}
