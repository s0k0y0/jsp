

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
//MVC:컨트롤러의 역할을 하는 파일 
@WebServlet("/login/login_mvc2")
public class loginServlet_MVC2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String ID=req.getParameter("ID");
		String PW=req.getParameter("PW");
		PrintWriter out=res.getWriter();
		
		if(ID.equals("admin")&&PW.equals("1234")){
			HttpSession session=req.getSession();
			session.setAttribute("ids", ID);
			session.setAttribute("pws", PW);
			
			RequestDispatcher d=req.getRequestDispatcher("../loginout/logout_jsp_MVC2.jsp");
			//위의 아이디와 패스워드를 해당 경로의 파일에 전달해줘서 사용할 수 있도록 해줌?
			d.forward(req, res);//요청했던거랑 응답했던거 다 실어서 보냄??
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
