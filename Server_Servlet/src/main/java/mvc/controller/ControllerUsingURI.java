package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;


//실행해서 ?cmd=hello로 넣어보기
//http://localhost/Server_Servlet/controllerUsingFile?cmd=hello같이 복잡한 경로로 파라미터로 값을 보낼 경우의 단점이 존재하는데 이 단점을 보안하는 방법이 controllerUserURI
//ControllerUsingURI는 확장자 패턴을 사용한다 (main.do 경로로 가겠다)



//@WebServlet("/controllerUsingURI")
public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, CommandHandler> commandHandlerMap=new HashMap<String, CommandHandler>();
	//key는 문자고 vlaue는 클래스타입으로 process의 값이라고 할 수 있음?
	
	
	
	//가장 먼저 실행됨
	@Override
	public void init() throws ServletException {
		
		///WEB-INF/commandHandlerURI.properties
		String confgFile=getInitParameter("confgFile");//web에 있는 confgFile파라미터 밑의 value값을 가져와 변수에 저장하겠다
		Properties prop=new Properties();//Map게열 
		String confgFilePath=getServletContext().getRealPath(confgFile);///WEB-INF/commandHandlerURI.properties이 confgFile에 들어있다는 뜻. 
		System.out.println("confgFilePath:"+confgFilePath);
		try(FileReader fis=new FileReader(confgFilePath)){
			prop.load(fis);//경로를 가지고와 위의 prop에 저장함??
		} catch(IOException e){
			throw new ServletException(e);
		}
		Iterator<Object> keyIter=prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command=(String)keyIter.next();//hello.dodo가 들어있음
			System.out.println("command::"+command);//hello라는 값이 들어가 있음
			String handlerClassName=prop.getProperty(command);
			System.out.println("handlerClassName::"+command);//hello라는 값이 들어가 있음
					
			try {
				
				Class<?> handlerClass=Class.forName(handlerClassName);//member.command.HelloHandler
				CommandHandler handlerInstance=(CommandHandler) handlerClass.newInstance();
				//   hello.dodo가 변수명에 들어있는 것임. member.command.HelloHandler의 객체가 들어있는 것과 같음?
				System.out.println("handlerClassName::"+handlerInstance);
				//hello     mvc.hello.HelloHandler@71c7c4d1이
				commandHandlerMap.put(command, handlerInstance);//
				
			} catch (ClassNotFoundException |InstantiationException|IllegalAccessException e) {
				
			}  
		}
	}
	//properties에 있는 hello라는 키를 통해 =""의 value값을 알려고 하는 코드
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);//process메소드에 가서 처리하겠다
	}
	
	//두번째로 코드 수행됨
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command=request.getRequestURI();//hello
		System.out.println("command1: "+command);///Server_Servlet/*.dodo
		if(command.indexOf(request.getContextPath())==0) {
			command=command.substring(request.getContextPath().length());
			System.out.println("command2: "+command);///*.dodo
		}
		CommandHandler handler= commandHandlerMap.get(command);//mvc.hello.HelloHandler
		if(handler==null) {
			handler=new NullHandler();	
		
		}
		
		String viewPage=null;
		
		try {
			viewPage= handler.process(request, response);///WEB-INF/view/hello.jsp
			System.out.println("viewPage: "+viewPage);///WEB-INF/view/hello.jsp(hello.dodo로 변경하여 검색했을때 viewPage의 값이 위와 같은 경로값이 들어가게 됨)
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		if(viewPage !=null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
			
			
		}
		
	}

}
