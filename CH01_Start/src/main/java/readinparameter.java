

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//read파일 jsp과 servlet버전으로 각각 출력 방식 작성. 이건 servlet버전!!!
@WebServlet("/readinparameter")
public class readinparameter extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>초기화 파라미터 목록::<br><ul>");
		
		
		Enumeration<String> initParam=getServletContext().getInitParameterNames();
		while(initParam.hasMoreElements()){
			String name= initParam.nextElement();
			String value= getServletContext().getInitParameter(name);
			out.println("<li>"+name+":"+value+"</li>");
		}
		
		out.println("</ul>");
		
		
		String val3= getServletContext().getInitParameter("logEnabled");
		String val4= getServletContext().getInitParameter("debug Level");
		out.println("logEnabled:"+val3+"<br>"+"debug Level:"+val4);
		
		
		
		
		out.println("</body></html>");
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
