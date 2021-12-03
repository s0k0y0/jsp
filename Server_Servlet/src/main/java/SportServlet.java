

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/study/Sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String baseball=request.getParameter("baseball");
		String soccer=request.getParameter("soccer");
		String basketball=request.getParameter("basketball");
		String gender=request.getParameter("gender");
		
		HttpSession ht=request.getSession();
		ht.setAttribute("bs",baseball);
		ht.setAttribute("s",soccer);
		ht.setAttribute("bk",basketball);
		ht.setAttribute("g",gender);
		
		RequestDispatcher re=request.getRequestDispatcher("../study/requestsub.jsp");
		re.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
