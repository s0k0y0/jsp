package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
//로직을 처리할 커맨드 인터페이스
	
	//추상메소드
	public String process(HttpServletRequest req, HttpServletResponse res);
		
	
	
		
}
