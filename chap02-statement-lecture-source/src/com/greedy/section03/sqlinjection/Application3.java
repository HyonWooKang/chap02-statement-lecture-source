package com.greedy.section03.sqlinjection;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application3 {
	/* Application2에서 성공한 SQL 공격을 방어하는 방법 (객체 변경) */
	// 면접 답변 : SQL Injection에 대비하여 'PreparedStatement' 객체를 사용하여 방어했다.
	
	private static String empId = "200";
	private static String empName = "' OR 1=1 AND EMP_ID = '200";
	// 위 쿼리문에서 '을 빼고 OR부터 200까지 글씨만 적용된다.
	
	public static void main(String[] args) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?";
		// QUERY문을 변경 -> 조작을 불가능하게 처리한다!
		// ORACLE(SQL) 전용 WEB SEQURITY 전용함
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empId);
			pstmt.setString(2, empName);
			// 2개 자리를 설정하고 값을 하나(i.g. empId)만 넣어주면 error 발생
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
			} else {
				System.out.println("회원 정보가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
	}

}
