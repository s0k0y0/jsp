package ch15.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//434
public class jdbcUtil {

	public static void close(ResultSet re) {
		if(re != null) {
			try {
				re.close();
			} catch (Exception e) {
			
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			} catch (Exception e) {
				
			}
		}
	}
	
	
	
	
	
	
}
