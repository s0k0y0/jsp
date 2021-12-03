

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1.annotatuin 방식=권장사항
@WebServlet("/login/login_mvc2")
public class loginServlet_MVC2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String ID=request.getParameter("ID");
		String PW=request.getParameter("PW");
		PrintWriter out=response.getWriter();
		
		if(ID.equals("admin")&&PW.equals("1234")){
			HttpSession session=request.getSession();
			session.setAttribute("ids", ID);
			session.setAttribute("pws", PW);
			
			RequestDispatcher d=request.getRequestDispatcher("../loginout/logout_jsp_MVC2.jsp");
			//위의 아이디와 패스워드를 해당 경로의 파일에 전달해줘서 사용할 수 있도록 해줌?
			d.forward(request, response);//요청했던거랑 응답했던거 다 실어서 보냄??
		} else {
			out.println("<script>");
			out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
