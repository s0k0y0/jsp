package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><body>장바구니 비웠음!!");
		
		Cookie[] c=request.getCookies();
		
		if(c !=null && c.length>0) {
			for(int i=0; i<c.length; i++) {
				if(c[i].getName().equals("select")) {
					Cookie cc=new Cookie("select","");
					cc.setMaxAge(0);
					response.addCookie(cc);
				}
			}
		}
		
		
		
		out.println("<a href=''>상품 선택 페이지</a>");
		out.println("</html></body>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
