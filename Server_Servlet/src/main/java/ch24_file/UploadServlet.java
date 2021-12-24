package ch24_file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/ch24_fileupload/Upload")
@MultipartConfig(maxFileSize = 1024*1024*2, location = "c:\\uploadtest")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//파일명을 얻기
    private String getFilename(Part part) {
    	
    	String filename=null;
    	String contentDispositionHeader=part.getHeader("content-disposition");//getHeard에 있는 여러 개의 파일을 불러온다
    	String[] elements= contentDispositionHeader.split(";");//그 파일들을 위와 같이 분리한다. 앞에 있는 문자의 앞과 뒤를 구분하겠다
    	for(String element:elements) {
    		if(element.trim().startsWith("filename")) {//불리한 파일명 중에서 filename이란 파일이 있는지 찾는다
    			filename=element.substring(element.indexOf('=')+1);
    			filename=filename.trim().replace("\"", "");//파일이 없다면 없는 것으로 쳐라??
    		}
    	}
    	
    	return filename;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Part part=request.getPart("theFile");
		String filename=getFilename(part);
		if(filename !=null && !filename.isEmpty()) {
			part.write(filename);
		}
		
		String author=request.getParameter("theAuthor");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("작성자:"+author+"<br>");
		out.println("파일명:<a href='FileDown?file_name="+filename+"'>"+filename+"</a><br>");
		out.println("파일크기:"+part.getSize()+"<br>");
		
		
		
	}

}
