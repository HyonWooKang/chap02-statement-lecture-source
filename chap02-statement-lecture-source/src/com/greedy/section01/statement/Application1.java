package com.greedy.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;

public class Application1 {
	
	public static void main(String[] args) {
		
		Connection con = getConnection();
		
		/* 쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스 생성 */
		Statement stmt = null;
		// Statement는 인터페이스라 뼈대만 있음
				
		/* select의 결과 집합을 받아올 용도의 인터페이스 */
		ResultSet rset = null;
		
		try {
			/* connection을 이용해서 statement 인스턴스 생성 */
			stmt = con.createStatement();
			// 객체 생성
			
			rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");
			// 결과값 담기
			
			while(rset.next()) {
				System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
				// 내용 있으면 출력, 없으면 종료
		        // 괄호 안은 컬럼명을 작성한 것
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
