package ch15.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ch15.guestbook.model.Message;
import ch15.jdbc.jdbcUtil;

//450
public class MessageDao {

	
	private static MessageDao messageDao=new MessageDao();
	private static MessageDao getInstance() {
		return messageDao;
	}
	
	private MessageDao() {
		
	}
	
	
	private Message makeMessageFromResultSet(ResultSet re) throws SQLException {
		
		Message m=new Message();
		m.setId(re.getInt("member_id"));
		m.setGuestName(re.getString("guest_name"));
		m.setPassword(re.getString("password"));
		m.setMessage(re.getString("message"));
		return m;

	}
	
	
	
	public int insert(Connection conn, Message message) throws SQLException{
		PreparedStatement pstmt=null;
		
		try {
			String sql = "insert into guestbook_message values(message_id_seq.NEXTVAL,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getMessage());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			
		} catch (SQLException e) {
			
		} finally {
			jdbcUtil.close(pstmt);
		}

		return pstmt.executeUpdate();
	}

	
	
	
	public Message select(Connection conn,int messageId) throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet re=null;
		
		try {
			
			String sql="select*from guestbook_message_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			re=pstmt.executeQuery();
			if(re.next()) {
				
			} else {
				return null;
			}
		} catch (SQLException e) {

		} finally {
			jdbcUtil.close(re);
			jdbcUtil.close(pstmt);
		}
		
		return makeMessageFromResultSet(re);
	}
	
	
	
	
	
	public int delete(Connection conn,int messagId) throws SQLException {
		PreparedStatement pstmt=null;
		
		
		try {
			String sql="delete from guestbook_message where message_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, messagId);
		} catch (SQLException e) {
			
		} finally {
			jdbcUtil.close(pstmt);
		}
		return pstmt.executeUpdate();
	}
	
	
	
	
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt=null;
		ResultSet re=null;
		
		try {
			stmt=conn.createStatement();
			String sql="select count(*) from guestbook_message";
			re=stmt.executeQuery(sql);
			re.next();
			
		} catch (SQLException e) {
		
		} finally {
			jdbcUtil.close(stmt);
			jdbcUtil.close(re);
		}
		
		return re.getInt(1);
	}
	
	

	
	public  List<Message> selectList(Connection conn,int firstRow, int endRow){
		PreparedStatement pstmt=null;
		ResultSet re=null;
		
		
		try {
			String sql = "select*from  where rnum>=?";
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			
		} finally {
			jdbcUtil.close(pstmt);
		}
		
		return null;
	}
	
	
	
	
	
	
}
