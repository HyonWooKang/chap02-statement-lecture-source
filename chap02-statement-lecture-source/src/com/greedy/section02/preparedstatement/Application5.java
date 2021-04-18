package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application5 {
	
	public static void main(String[] args) {
		
		/*
		 * LIKE %이 이로 끝나는
		 * LIKE 이% 이로 시작하는
		 * LIKE %이% 이를 포함하는
		 */
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO row = null;
		List<EmployeeDTO> empList = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 이름의 성을 입력하세요 : ");
		String empName = sc.nextLine();
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE ? || '%'";
		// 뒤에 %를 합쳐주기 위해서는 SQL의 문자열 합치기인 ||을 사용해야 한다.
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empName);
			
			
			System.out.println(query);
			
			rset = pstmt.executeQuery();
			
			empList = new ArrayList<>();
			
			while(rset.next()) {
				row = new EmployeeDTO();
				
				row.setEmpId(rset.getString("EMP_ID"));
				row.setEmpName(rset.getString("EMP_NAME"));
				row.setEmpNo(rset.getString("EMP_NO"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setDeptCode(rset.getString("DEPT_CODE"));
				row.setJobCode(rset.getString("JOB_CODE"));
				row.setSalLevel(rset.getString("SAL_LEVEL"));
				row.setSalary(rset.getInt("SALARY"));
				row.setBouns(rset.getDouble("BONUS")); 
				row.setManagerId(rset.getString("MANAGER_ID"));
				row.setHireDate(rset.getDate("HIRE_DATE"));
				row.setEntDate(rset.getDate("ENT_DATE"));
				row.setEntYn(rset.getString("ENT_YN"));

				empList.add(row);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rset);
			close(pstmt);
			close(con);
			
		}
		
		for (EmployeeDTO emp : empList) {
			System.out.println(emp);
			
		}
		 
	}

}