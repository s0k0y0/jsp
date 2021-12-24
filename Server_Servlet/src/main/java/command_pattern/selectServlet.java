package command_pattern;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.dsa")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Command Pattern
		//requestURI():: /Server_Servlet/insert.dos
		//getContextPath():: /Server_Servlet
		//command:: /insert.dos
		
		String requestURI=request.getRequestURI();
		System.out.println("requestURI::"+requestURI);
		String contextPath=request.getContextPath();
		System.out.println("getcontextPath::"+contextPath);
		String command=requestURI.substring(contextPath.length());
		System.out.println("command::"+command);
		
		if(command.equals("/insert.dsa")) {
			//command Pattern:각 명령어에 해당하는 로직 처리 코드를 별도 클래스로 작성하는 것(529~530)
			//하나의 명령씩 하나의 메모를 처리하는 것?
			System.out.println("DB에 데이터 입력");
		} else if(command.equals("/delete.dsa")) {
			System.out.println("DB에 데이터 삭제");
		} else if(command.equals("/update.dsa")) {
			System.out.println("DB에 데이터 수정");
		} else {
			//select.dsa
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			
		
			//EmpDAO dao=new EmpDAO();
			selectService service=new selectService();
		
			System.out.println("A");
			
			ArrayList<EmpDTO> list=service.execute(request, request);
			System.out.println("A");
			for(EmpDTO dto:list) {
			
				String empno=dto.getEmpno();
				String ename=dto.getEname();
				int sal=dto.getSal();
				String deptno=dto.getDeptno();
				out.print(empno+"\t"+ename+"\t"+sal+"\t"+deptno+"<br>");	
			}
			out.println("</body></html>");
			System.out.println("A");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
