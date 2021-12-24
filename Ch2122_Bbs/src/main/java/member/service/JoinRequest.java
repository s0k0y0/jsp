package member.service;

import java.util.Map;

//DTO,594
//[594]DTO:데이터를 담는 곳
//service에 데이터 넘겨우는 첫번째 DTO
public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isPasswordEqualToConfirm() {
		
		return false;
	}
	//유효성 검증:각 필드를 검사하는 것 
	//Map<>:에 에러 정보 담기???
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password,"passowrd" );
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if(!errors.containsKey(confirmPassword)) {
			if(!isPasswordEqualToConfirm()) {//암호하고 암호확인하고 맞지 않는 경우, MAP에 true값을 넣겠다
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	
	
	//에러 발생 시, 작동하는 메소드.  value가 값이 없는 경우, Map객체에 필드이름에 true값을 추가하도록 한다
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value==null||value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
