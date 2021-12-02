
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CH02_start/start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//자바에서 웹으로 정보를 전달하기 위한 방법???
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