package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;

public class Application1 {
	
	public static void main(String[] args) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		// Statement는 query문이 바뀌고 사용될때마다 compile을 함
		// 하지만 PrepareStatement는 객체를 만들어두고 가져다가 써서 속도가 향상됨
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
			}
		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
	}

}
