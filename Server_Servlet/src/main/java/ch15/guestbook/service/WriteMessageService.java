package ch15.guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import ch15.guestbook.dao.MessageDao;
import ch15.guestbook.model.Message;
import ch15.jdbc.jdbcUtil;
import ch15.jdbc.connection.ConnectionProvider;

//458
public class WriteMessageService {

	//싱글톤으로 객체 생성& 싱글톤 불러오는 메소드 생성
	private static WriteMessageService instance=new WriteMessageService();
	public static WriteMessageService getInstance() {
		return instance;
	}
	
	private WriteMessageService() {
		
	}
	
	
	public void write(Message message) {//jsp에서 받아온 메세지 값 
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();//드라이버로 데이터베이스 연결
			MessageDao messageDao=MessageDao.getInstance();//싱글톤 호출
			messageDao.insert(conn, message);//테일블 값 삽입하는 메소드 호출
			
		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패:"+e.getMessage(),e);
		} finally {
			jdbcUtil.close(conn);
		}
		
		
	
	}
	
	
}
