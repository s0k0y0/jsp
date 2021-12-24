package command_pattern;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class EmpDAO {
	
	
//	String driver="oracle.jbdc.driver.OracleDriver";
//	String url="jdbc:oracle:thin:@locahost:1521:orcl";
//	String userid="scott";
//	String passwd="scott";
	//tomcat context에 이미 oracle 연걸 resource가 첨부되어 있어 따로 드라이브 연결이 필요가 없음
	
	DataSource dataFactory;
	
	public EmpDAO(){
	
			try {
				Context cx=new InitialContext();
				dataFactory=(DataSource)cx.lookup("java:comp/env/jdbc/OracleDB");
				
			} catch (NamingException e) {
				
			}
		
	}
	

	public ArrayList<EmpDTO> select(){
		
		ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			String sql="select empno,ename,sal,deptno from emp";
			con=dataFactory.getConnection();
			
			System.out.println("A");
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String empno=rs.getString("empno");
				String ename=rs.getString("ename");
				int sal=rs.getInt("sal");
				String deptno=rs.getString("deptno");
				
				EmpDTO dto=new EmpDTO(empno, ename, sal, deptno);
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e1) {
				
			}
		}
		
		
		return list;
	}
	
	
	
	
}
