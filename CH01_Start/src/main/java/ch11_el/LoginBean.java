package ch11_el;

import java.io.Serializable;

//serializable: 원격지 컴에 객체 전송시 사용	
//vo=DTO=Bean=getter() and setter()	값을 넣기도 하고 빼기도 하는 파일 위치? 역할
public class LoginBean implements Serializable {

	
	
	private static final long serialVersionUID= 155L;
	
	private String userid;
	private String passwd;
	
	public LoginBean() {
		
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
