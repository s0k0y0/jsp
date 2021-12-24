package CH18.mvc.simple;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch18/simple")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest( request,  response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doGet(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String type=request.getParameter("type");
		Object resultObject=null;
		
		if(type==null||type.equals("greeting")) {
			resultObject="안녕하세요";
		} else if(type.equals("date")) {
			resultObject=new Date();
		} else {
			resultObject="Invalid Type";
		}
		
		request.setAttribute("result", resultObject);
		
		
		//속성, 변수를 view로 전달하는 것
		RequestDispatcher d=request.getRequestDispatcher("simpleView.jsp");
		d.forward(request, response);
	}
	

}
