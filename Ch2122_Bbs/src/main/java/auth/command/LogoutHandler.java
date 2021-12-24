package auth.command;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession session=req.getSession(false);
		
		if(session!=null) {
			session.invalidate();
		}
		try {
			res.sendRedirect(req.getContextPath()+"/index.jsp");
		} catch (IOException e) {
			
		}
		return null;
		
	}

	
	
	
	
	
}
