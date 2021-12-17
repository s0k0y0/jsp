package CH18.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CH18.mvc.dao.EmpDAO;
import CH18.mvc.dao.EmpDAO_Pool;
import CH18.mvc.vo.EmpDTO;


@WebServlet("/ch18/emppool")
public class EmpSelectServletDAO_Pool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		EmpDAO_Pool dao=new EmpDAO_Pool();
		ArrayList<EmpDTO> list=dao.select();
		for(EmpDTO dto:list) {
			String empno=dto.getEmpno();
			String ename=dto.getEname();
			int sal=dto.getSal();
			String deptno=dto.getDeptno();
			out.print(empno+"\t"+ename+"\t"+sal+"\t"+deptno+"<br>");	
		}
		out.println("</html></body>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
