package ch15.guestbook.service;

import java.util.List;

import ch15.guestbook.model.Message;

//445
public class MessageListView {

	private int messageTatalCount;
	private int currentPageNumber;
	private List<Message> messageList;
	private int pageToralCount;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;
	
	
	public int getMessageTatalCount() {
		return messageTatalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public int getPageToralCount() {
		return pageToralCount;
	}
	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public int getEndRow() {
		return endRow;
	}
	
	public boolean isEmpty() {
		
		return messageTatalCount==0;
	}
	
	
	
	
	
}
