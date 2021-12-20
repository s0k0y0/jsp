package ch15.guestbook.service;

import java.util.List;

import ch15.guestbook.model.Message;

//445
public class MessageListView {

	private int messageTotalCount;//글 전체 갯수
	private int currentPageNumber;//현재 페이지
	private List<Message> messageList;//글 내용
	private int pageTotalCount;//전체 페이지 수
	private int messageCountPerPage;//페이지 당 글 출력 갯수(getmessage에서 3이라고 설정)
	private int firstRow;//현재 페이지에서 첫번째 글의 인덱스
	private int endRow;//현재 페이지에서 마지막 글의 인덱스
	
	
	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,int messageCountPerPage, int startRow, int endRow) {

		this.messageList=messageList;
		this.messageTotalCount=messageTotalCount;
		this.currentPageNumber=currentPageNumber;
		this.messageCountPerPage=messageCountPerPage;
		this.firstRow=startRow;
		this.endRow=endRow;
	
		calculatePageTotalCount();
	}
	
	//글 목록이 증가할 경우, 페이지 이동 갯수를 글 갯수에 맞게 추가하도록 한다
	public void calculatePageTotalCount() {
		if(messageTotalCount==0) {
			pageTotalCount=0;
		} else {
			pageTotalCount=messageTotalCount/messageCountPerPage;
			if(messageTotalCount % messageCountPerPage>0) {
				pageTotalCount++;
			}
		}
	}
	
	
	public int getMessageTatalCount() {
		return messageTotalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
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
		
		return messageTotalCount==0;
	}
	
	
	
	
	
}
