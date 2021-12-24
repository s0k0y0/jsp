package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.connection.ConnectionProvider;
import jdbc.connection.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	//DTO에 담긴 값을 DAO로 넘겨주는 역할

	private MemberDao memberDao = new MemberDao();
	
	
	
	public void join(JoinRequest joinReq) {//request DTO로부터 데이터 값을 받음
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);//커밋의 시작점. 트랜잭션이 적용되는 시점이다. 롤백할때 돌아오는 시점
			Member member = memberDao.selectById(conn, joinReq.getId());//데이터를 연결하는데 id와 일치하도록 한다.
			if(member != null) {
				//중복된id인 경우
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			Member member2 = new Member(joinReq.getId(), joinReq.getName(), joinReq.getPassword(), new Date());
			memberDao.insert(conn, member2);////위 객체를 넣어 insert를 실행하겠다
		
			conn.commit();
			
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	//커밋의 시작점:커밋을 수행하는 것이 아닌 커밋의 시작(준비)을 의미하는 것. 이후에 롤백이 오면 이 코드바로 다음까지의 상태로 돌아옴
	//중복된 id인 경우:아이디가 중복된 경우는 지금까지의 내용을 취소하게끔 롤백시키겠다. 또한 강제적으로 예외를 발생시키겠다
}
