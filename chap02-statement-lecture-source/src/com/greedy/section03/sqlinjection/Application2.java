package com.greedy.section03.sqlinjection;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application2 {
	/* Application1에서 작성한 코드에 대한 SQL Injection 공격법 (객체 변경) */
	
	// 아이디와 비밀번호 맞으면 로그인 된다고 가정
	private static String empId = "200";
	private static String empName = "' OR 1=1 AND EMP_ID = '200";
	// injection query문 (문자열 값 수정)
	// 200 뒤에 single quotation(') 빼주기 - 아래 쿼리문에서 ' 작성됨
	// sql injection문은 true값을 맞춰줘서, 되면 안되는 것을 되게 바꾸는 방법
	
	public static void main(String[] args) {
		
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND EMP_NAME ='" + empName + "'";
		System.out.println(query);
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
			} else {
				System.out.println("회원 정보가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(con);
		}
		
	}

}
