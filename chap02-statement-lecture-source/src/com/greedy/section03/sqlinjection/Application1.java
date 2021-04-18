package com.greedy.section03.sqlinjection;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application1 {
	
	// 아이디와 비밀번호 맞으면 로그인 된다고 가정
	private static String empId = "200";
	private static String empName = "선동일";
	
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
