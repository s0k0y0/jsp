package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.connection.JdbcUtil;
import member.model.Member;
import oracle.net.aso.p;

public class MemberDao {

	public Member selectById(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where memberid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(rs.getString("memberid"), rs.getString("name"), rs.getString("password"),
						toDate(rs.getTimestamp("regdate")));
			}
			return member;
		} catch (SQLException e) {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;

	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, Member mem) {

		PreparedStatement pstmt = null;

		String sql = "insert into member values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {

		}
	}

	public void update(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = "update member set name=?,password=?,where memberid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(1, member.getPassword());
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
		}
		
	}

}
