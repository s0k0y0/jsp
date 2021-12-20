package ch15.guestbook.service;
//462
public class invalidPasswordException extends Exception {

	private static final long serialVersionUID=1L;
	//직렬화?? 객체를 바이트배열로 변환하여 파일로 저장하는것
	
	public invalidPasswordException(String message) {
		super(message);
	}
}
