package ch15.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch15.guestbook.model.Message;
import ch15.jdbc.jdbcUtil;

//450
public class MessageDao {

	//싱글톤:한번 객체를 생성하면 다시 재생성하지 않고 계속해서 불어와서 쓸 수 있는 것
	private static MessageDao messageDao=new MessageDao();
	public static MessageDao getInstance() {
		return messageDao;
	}
	
	private MessageDao() {
		
	}
	
	//resultset에서 데이터를 읽어와서 메세지 생성: select(),selectList()에서 사용됨
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
		
		try {//mysal은 시퀀스를 따로 표시할 필요 없이 자동으로 채워주시만 oracle은 시퀀스명을 작성해야함
			String sql = "insert into guestbook_message(message_id,guest_name,password,message) values(message_id_seq.NEXTVAL,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			return pstmt.executeUpdate();
		
		} finally {
			jdbcUtil.close(pstmt);
		}
		

		
	}//catch안붙여야지 return값을 try에 넣을 수 있음

	
	
	
	public Message select(Connection conn,int messageId) throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet re=null;
		
		try {
			
			String sql="select*from guestbook_message where message_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			re=pstmt.executeQuery();
			if(re.next()) {
				return makeMessageFromResultSet(re);
			} else {
				return null;
			}
		} finally {
			jdbcUtil.close(re);
			jdbcUtil.close(pstmt);
		}
		
		
	}
	
	
	
	
	
	public int delete(Connection conn,int messagId) throws SQLException {
		PreparedStatement pstmt=null;
		
		
		try {
			String sql="delete from guestbook_message where message_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, messagId);
			
			return pstmt.executeUpdate();
			
		}  finally {
			jdbcUtil.close(pstmt);
		}
		
	}
	
	
	
	
	//글 목록의 전체 갯수?
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt=null;
		ResultSet re=null;
		
		try {
			stmt=conn.createStatement();
			String sql="select count(*) from guestbook_message";
			re=stmt.executeQuery(sql);
			re.next();
			return re.getInt(1);
			
		}finally {
			jdbcUtil.close(stmt);
			jdbcUtil.close(re);
		}
		
		
	}
	
	

	//글 상세 불러오기
	public  List<Message> selectList(Connection conn,int firstRow, int endRow) throws SQLException{
		PreparedStatement pstmt=null;
		ResultSet re=null;
		
		
		try {
			String sql ="select message_id, guest_name, password, message from ( "
							+ " select rownum rnum, message_id, guest_name, password, message from ( "
							+ " select * from guestbook_message m order by m.message_id desc "
							+ "    ) where rownum <= ? "
							+ ") where rnum >= ?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);
			re=pstmt.executeQuery();
			
			
			if(re.next()) {
				List<Message> messageList=new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(re));
				} while (re.next());
				return messageList;
				
				
				
			} else {
				return Collections.emptyList();
			}
			
		} finally {
			jdbcUtil.close(pstmt);
		}
		
		
	}
	
	
	
	
	
	
}
