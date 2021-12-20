package ch15.guestbook.service;

import java.sql.Connection;

import java.sql.SQLException;

import ch15.guestbook.dao.MessageDao;
import ch15.guestbook.model.Message;
import ch15.jdbc.jdbcUtil;
import ch15.jdbc.connection.ConnectionProvider;


//460
public class DeleteMessageService {

	private static DeleteMessageService instance=new DeleteMessageService();
	
	public static DeleteMessageService getInstance() {
		return instance;
	}
	
	private DeleteMessageService() {
		
	}
	
	public void deleteMessage(int MessageId, String password) throws Exception {

		Connection conn=null;
		
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			MessageDao messageDao=MessageDao.getInstance();
			Message message=messageDao.select(conn, MessageId);
			if(message==null) {
				throw new MessageNotFoundException("메세지 없음");
			}
			
			if(!message.matchPassword(password)) {
				throw new invalidPasswordException("bad password");
			}
			messageDao.delete(conn, MessageId);
			
			
			conn.commit();
			
		} catch (SQLException ex) {
			jdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패:"+ex.getMessage(), ex);
			
		} catch (invalidPasswordException | MessageNotFoundException ex) {
			jdbcUtil.rollback(conn);
			throw ex;
		} 
		finally {
			jdbcUtil.close(conn);
		}
	
	}
	
}
