package com.greedy.section01.statement;

import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application4 {
	
	public static void main(String[] args) {
		
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rSet = null;
		
	    EmployeeDTO row = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회하려는 사번을 입력해주세요 : ");	
		String empId = sc.nextLine();
		
		String query = ("SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'");
		
		try {
			stmt = con.createStatement();
			rSet = stmt.executeQuery(query);
			
			if(rSet.next()) {
				row = new EmployeeDTO();
				
				row.setEmpId(empId);
				
			
		}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rSet);
			close(stmt);
			close(con);
			
		}
		
	}

}