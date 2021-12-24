package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import article.model.Article;

public class ArticleDao {

	public Article insert(Connection conn,Article article) {
		PreparedStatement pstmt = null;
		Statement stmt=null;
		ResultSet rs = null;

		
		try {
			String sql="insert into article (article_no,writer_id,writer_name, title, regdate, moddate, read_cnt) values (article_no_seq.nextval, ?, ?, ?, ?, ?, 0)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimest(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
