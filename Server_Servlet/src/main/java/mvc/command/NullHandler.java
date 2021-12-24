package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {
	//로직을 처리할 커맨드 명렁어1
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		//명령어와 관련된 비즈니스 로직 가져오기
		
		return null;
	}

}
