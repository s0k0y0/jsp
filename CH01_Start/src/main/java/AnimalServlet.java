

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);//데이터가 get의 형태로 오지 않을 경우, post도 살펴보겠다
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String food=request.getParameter("food");
		HttpSession session=request.getSession();
		session.setAttribute("f", food);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		out.print("<html><body>");
		out.print("<h1>성겨 테스트</h1><form action='result'>");
		out.print("<input type='text' name='animal'>");
		out.print("<input type='submit' value='확인'>");
		out.print("</form></body></html>");
	}

}
