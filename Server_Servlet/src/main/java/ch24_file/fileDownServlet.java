package ch24_file;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch24_fileupload/FileDown")
public class fileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName=request.getParameter("file_name");
		String sDownloadPath="c:\\uploadtest\\";
		String sFilePath=sDownloadPath+fileName;
		
		byte[] b=new byte[4096];//파일 내용이 들어가는 방을 만들어줌
		FileInputStream in=new FileInputStream(sFilePath);//파일 경로를 가지고 온다
		String sMimeType=getServletContext().getMimeType(sFilePath);
		System.out.println("ssMimeType>>>"+sMimeType);
		if(sMimeType == null) sMimeType="application/octet-stream";
		response.setContentType(sMimeType);
		
		
		String sEncoding= new String(fileName.getBytes("utf-8"));//바이트에 있는 내용을 utf-8로 변환?
		response.setHeader("Content-Disposition", "attachment; filename="+sEncoding);//내 local에 있는 파일을 출력하도록한다
		ServletOutputStream out=response.getOutputStream();//출력한 파일 내용을 반복문으로 하나씩 읽어드리겠다
		int numRead;
		while((numRead=in.read(b, 0, b.length)) != -1) {
			out.write(b,0,numRead);
		}
		out.flush();
		out.close();
		in.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
