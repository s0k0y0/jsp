package Member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class personalinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		personalinfo p=new personalinfo();
		
		p.setName("홍길동");
		p.setGender('M');
		p.setAge(24);
		
		request.setAttribute("pinfo", p);
		RequestDispatcher re=request.getRequestDispatcher("/CH08_jsp_useBean/study08/customerinfoViewer.jsp");
		re.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
