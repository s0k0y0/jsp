package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class basket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		Cookie[] c=request.getCookies();
		
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("장바구니 리스트<br>");
		
		if(c != null && c.length>0) {
			for(int i=0; i<c.length; i++) {
				out.println("product:"+c[i].getValue());
			}
		} else {
			out.println("장바구니가 비었습니다");
		}
		
		out.println("<a href='c.html'>상품 선택 페이지</a>");
		out.println("<a href=''>장바구니 비우기</a>");
		out.println("</body></html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
