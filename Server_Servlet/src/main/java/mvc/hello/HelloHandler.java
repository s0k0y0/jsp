package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class HelloHandler implements CommandHandler {

	
	//로직을 처리할 커맨드 명렁어2
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		//페이지에서 사용할 정보 속정으로 저장
		req.setAttribute("hello", "안녕하세요!");
		
		//페이지의 URI리턴
		return "/WEB-INF/view/hello.jsp";
	}

}
