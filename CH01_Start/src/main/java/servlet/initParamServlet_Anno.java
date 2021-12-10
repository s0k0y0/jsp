package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet URL Mapping 방법: Annotation 방식을 사용함.


@WebServlet(name="InitParamServlet_Anno",
			urlPatterns= {"/initAnno"}, 
			initParams= {@WebInitParam(name="dirPath",value="c:\\test"),
					@WebInitParam(name="userid",value="admin")})
public class initParamServlet_Anno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		String dirPath=getInitParameter("dirPath");
		String userid=getInitParameter("userid");
		
		out.println("<hrml><body>");
		out.println("dirPath:"+dirPath+"userid:"+userid);
		out.println("</body></hrml>");
		
		System.out.println(getInitParameter("dirPath"));
		System.out.println(getInitParameter("userid"));
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	//init-param:해당 경로로 들어와야지만 변수안에 있는 데이터값을 사용할 수 있다. 그냥 param-name이면 즉, 아무나 쓸 수 있고 init은 한정된 경로에서 사용하는 지역변수인것이다
	//init-param도 동일하게 그냥 getinit에 param-name넣어서 불어오면 된다는 것? 차이점은 해당 경로에서만 사용하는 변수라 application을 적지 않는다는 점
}
