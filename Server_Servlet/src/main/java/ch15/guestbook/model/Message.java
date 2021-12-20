package ch15.guestbook.model;
//448, DTO=vo=Bean=Getter()/Setter()
public class Message {

	private int id;
	private String guestName;
	private String password;
	private String Message;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
	public boolean hasPassword() {
		return password !=null&& !password.isEmpty();
	}
	
	public boolean matchPassword(String pwd) {
		return password !=null&& !password.equals(pwd);
	}
	
	
	
	
	
}
