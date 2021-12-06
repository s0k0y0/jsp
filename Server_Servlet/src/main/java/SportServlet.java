

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//url mapping 방법1:어노테이션 방식 밑의 골뱅이 붙여서 
//@WebServlet("/study/Sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//form의 method형식이 get일 경우, 데이터를 이 메소드로 받겠다

		
		//mvc2(questsub)
		request.setCharacterEncoding("utf-8");//이 request는 그냥 변수명으로 jsp의 request는 문법이 있는 메소드이다. 해당 변수는 http타입이므로 http클래스에 있는 변수와 모든 메소드를 쓸 수 있는 파라미터 다형성이다
		response.setContentType("text/html;charset=utf-8");
		String baseball=request.getParameter("baseball");
		String soccer=request.getParameter("soccer");
		String basketball=request.getParameter("basketball");
		String gender=request.getParameter("gender");
		
		HttpSession ht=request.getSession();//다른 화면 즉, 사이트 사이에서 해당 사이트 안의 데이터를 주고받을 수 있도록 하는 문법
		ht.setAttribute("bs",baseball);
		ht.setAttribute("s",soccer);
		ht.setAttribute("bk",basketball);
		ht.setAttribute("g",gender);
		
		RequestDispatcher re=request.getRequestDispatcher("../study/requestsub.jsp?id=hong");
		re.forward(request, response);//위 경로의 목적파일을 출력하기 위한 문법
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {//form의 method형식이 post일 경우, 데이터를 이쪽으로 받겠다
	
		
		String[] baseball=req.getParameterValues("sports");//이름이 같은 데이터의 값을 출력하는 방법 1.배열로 변수를 설정하기 2.반복문으로 배열 출력하기
		
		//mvc1
		PrintWriter out=res.getWriter();//출력하기 위한 메소드
		out.println("<html><body>");
		for(String s:baseball) {
			out.println("좋아하는 운동:"+s);
		}
		out.println("</body></html>");
		
		doGet(req, res);
	}

}
