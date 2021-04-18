package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application2 {
	
	public static void main(String[] args) {
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String empId = "200";
		
		try {

			pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?");
			// PreparedStatement를 사용할 때 위치홀더 자리에 ?을 붙여주고, 특정 값(empId)을 가져오게 설정하면 간편함
			// 보안에서도 더 좋다. (쿼리문을 찍어보면 값 자리에 ?로 표시됨)
			pstmt.setString(1, empId);
			// ?에 값을 넣어줄때는 set으로 넣어줌(i.g. setString(), setInt()...)
			// 주의) 위치 홀더의 시작점은 '1'이다!
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
				// SQL에서는 문자와 문자열이 없으니 받을때 그냥 String, getString()으로 받아주기
				// 사실 char로 받아도 문제는 없음
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
			// close 순서는 역순으로 해줘야 제대로 처리된다.
		}
		
	}

}
