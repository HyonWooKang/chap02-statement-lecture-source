package com.greedy.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.*;

public class Application3 {
	
	public static void main(String[] args) {
		
		/* 1. Connection 생성 */
		// getConnection이라는 메소드 호출
		Connection con = getConnection();
		
		/* 2. Statement 객체 생성 */
		// 쿼리문 담고 실행할 객체
		Statement stmt = null;
		
		/* 3. ResultSet 생성 */
		ResultSet rSet = null;
		
		try {
			/* 4. Connection의 createStatement()를 이용한 Statement 인스턴스 생성 */
			stmt = con.createStatement();
			// 조회하려는 사번을 입력해주세요 라는 입력문을 쓰고 값을 입력 받아서 조회
			Scanner sc = new Scanner(System.in);
			System.out.print("조회하려는 사번을 입력해주세요 : ");
			
			String empId = sc.nextLine();
			String query = ("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'");
			
			System.out.println(query);
			
			/* 5. executeQuery()로 쿼리문 실행하고 결과를 ResultRet으로 반환 받는다. */
			rSet = stmt.executeQuery(query);
			
			/* 6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해서 꺼내온다. */
			if(rSet.next()) {
				
				System.out.println(rSet.getString("EMP_ID") + ", " + rSet.getString("EMP_NAME"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			/* 7. 이용한 객체 반환 */
			close(con);
			close(stmt);
			close(rSet);
			
		}
		
	}

}