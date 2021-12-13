

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/CH10_session/study10/")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//servlet~sevlet으로 데이터 전송
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String animal=request.getParameter("animal");
		HttpSession session=request.getSession();
		session.getAttribute("f");
		session.invalidate();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		out.print("<html><body>");
		out.print("<h1>좋아하는 동물은?</h1>");
		out.print("<input type='text' name='animal'>");
		out.printf("ekdtlsdml &sdhk %2를 좋아하는 성격입니다,food,animal");
		out.print("</body></html>");
		
	}

}
