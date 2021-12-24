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

//파라미터에 명령어 정보를 담아서 전달한 것. 즉, cmd에 클라이언트가 요청할 다양한 명렁어를 저장.
//커맨드: frontController에서 받은 요청을 분석해 어떤 처리가 필요한지에 따라서 각 처리에 필요한 Command객체를 할당해 그곳에서 처리한 뒤 필요한 데이터를
//가지고 frontController로 보내주고 그 데이터를 request객체 등에 세팅해 requestDispatcher객체를 통해 화면 전화시 request,response 객체를 함께 전달해주는 방식
//즉, 한곳에서 모이는 모든 요청을 command명령어에 따라 각자 클래스로 보내져 처리됨

//@WebServlet("/controllerUsingFile")
public class ControllerUsingFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, CommandHandler> commandHandlerMap=new HashMap<String, CommandHandler>();
	//key는 문자고 vlaue는 클래스타입으로 process의 값이라고 할 수 있음?
	
	
	
	//가장 먼저 실행됨
	@Override
	public void init() throws ServletException {
		
		String confgFile=getInitParameter("confgFile");//web에 있는 confgFile파라미터 밑의 value값을 가져와 변수에 저장하겠다
		Properties prop=new Properties();//Map게열 
		String confgFilePath=getServletContext().getRealPath(confgFile);///WEB-INF/commandHandler.properties이 confgFile에 들어있다는 뜻. 
		System.out.println("confgFilePath:"+confgFilePath);
		
		
		try(FileReader fis=new FileReader(confgFilePath)){
			prop.load(fis);
		} catch(IOException e){
			throw new ServletException(e);
		}
		//confg에 있는 매핑 정보를 읽어와 properties 객체에 저장한다. 
		
		
		
		Iterator<Object> keyIter=prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command=(String)keyIter.next();
			System.out.println("command::"+command);//hello라는 값이 들어가 있음
			String handlerClassName=prop.getProperty(command);
			System.out.println("handlerClassName::"+handlerClassName);//mvc.hello.HelloHandler
					
			try {
				
				Class<?> handlerClass=Class.forName(handlerClassName);
				CommandHandler handlerInstance=(CommandHandler) handlerClass.newInstance();
				System.out.println("handlerClassName::"+handlerInstance);//mvc.hello.HelloHandler@71c7c4d1
				//hello     mvc.hello.HelloHandler@71c7c4d1이 각각 들어있는것?
				commandHandlerMap.put(command, handlerInstance);
				
			} catch (ClassNotFoundException |InstantiationException|IllegalAccessException e) {
				
			}  
		}
		
		//매핑정보가 담긴 속성명을 커맨드명으로 사용한다.
		
		
		
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
		
		String command=request.getParameter("cmd");//hello
		CommandHandler handler= commandHandlerMap.get(command);//mvc.hello.HelloHandler
		if(handler==null) {
			handler=new NullHandler();	
		
		}
		
		String viewPage=null;
		
		try {
			viewPage= handler.process(request, response);///WEB-INF/view/hello.jsp
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		if(viewPage !=null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
			
			
		}
		
	}

}
