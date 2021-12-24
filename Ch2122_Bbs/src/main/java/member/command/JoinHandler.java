package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;


public class JoinHandler implements CommandHandler {

	

	private static final String FORM_VIEW="WEB-INF/view/joinForm.jsp";
	private JoinService joinservice=new JoinService();//조인 서비스의 객체를 생성해서 이용...
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")){
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//
			return null;
		}
	}
	//view안에 있는 joinform.jsp에 의해 join명령어를 받아 joinhandler가 코드를 처리하고 데이터를 저장(joinRequest라는 DTO에 저장)하여 MemberDao로 가서 처리함

	//get
	private String processForm (HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	//가입버튼을 누르게 되면 여기가 command실행 코드로 밑에 코드로 request DTO
	
	//post방식인 경우
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		JoinRequest joinReq=new JoinRequest();
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		
		Map<String, Boolean> errors=new HashMap<String, Boolean>();//들어오는 데이터 값이 에러일 경우 true. joinRequest에서 validate로 검사
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		//
		try {
			joinservice.join(joinReq);//데이터를 가지고 DAO로 진행하겠다
			return "/WEB-INF/view/joinSuccess.jsp";//request에 저장한 값을 불러오고 회원가입에 성공했다는 것을 출력하기 위해 jsp경로 리턴
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
		
		
	}
	

}
