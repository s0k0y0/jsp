package ch15.guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import ch15.guestbook.dao.MessageDao;
import ch15.guestbook.model.Message;
import ch15.jdbc.jdbcUtil;
import ch15.jdbc.connection.ConnectionProvider;

public class GetMessageListService {

	private static GetMessageListService instance=new GetMessageListService();
	
	public static GetMessageListService getInstance() {
		return instance;
	}
	
	private GetMessageListService(){
		
	}
	
	private static final int MESSAGE_COUNT_PER_PAGE=3;//한 페이지에 보여줄 글의 갯수를 3개로 설정한다
	
	public MessageListView getMessageList(int pageNumber) {
		Connection conn=null;
		int currentPageNumber=pageNumber;//글을 담는 페이지 넘버
		try {
			conn=ConnectionProvider.getConnection();
			
			MessageDao messageDao=MessageDao.getInstance();//싱글톤으로 dao클래스 불러오기
			int messageTotalCount=messageDao.selectCount(conn);//전체 글의 갯수 세는 메소드 호출
			
			List<Message> messageList=null;
			int firstRow=0;
			int endRow=0;
			if(messageTotalCount>0) {
				firstRow=(pageNumber-1)*MESSAGE_COUNT_PER_PAGE+1;//현재 페이지에 담기는 글의 인덱스 1,2,3(1page)/4,5,6(2page) 에서 해당 페이지의  첫번째 인덱스
				endRow=firstRow+MESSAGE_COUNT_PER_PAGE-1;//해당 페이지의 마지막 글의 인덱스 번호
				messageList=messageDao.selectList(conn, firstRow, endRow);
			} else {
				currentPageNumber=0;
				messageList=Collections.emptyList();
			}
			
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
			
			
			
			
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패:"+e.getMessage(),e);
		} finally {
			jdbcUtil.close(conn);
		}
		
	}
	
	
}
