package com.greedy.section02.preparedstatement;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class Application4 {
	
	public static void main(String[] args) {
		
		/* 스캐너 이용해서 사번을 입력받고 해당 사번의 사원 정보를 EmployeeDTO에 담아서 출력하세요 */
		// 실패 ㅜㅜ 복습하기
		// 결과를 담을 때 변수, LIST(ArrayList), MAP으로 사용할 수 있다.
		// **MAP을 자주 사용함 (Properties 문서도 MAP임 - KEY -- VALUE 매칭)
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmployeeDTO selectEmp = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 사원의 사번을 입력하세요 : ");
		String empId = sc.nextLine();
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectEmp = new EmployeeDTO();
				selectEmp.setEmpId(rset.getString("EMP_ID"));
				selectEmp.setEmpName(rset.getString("EMP_NAME"));
				selectEmp.setEmpNo(rset.getString("EMP_NO"));
				selectEmp.setEmail(rset.getString("EMAIL"));
				selectEmp.setPhone(rset.getString("PHONE"));
				selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
				selectEmp.setJobCode(rset.getString("JOB_CODE"));
				selectEmp.setSalLevel(rset.getString("SAL_LEVEL"));
				selectEmp.setSalary(rset.getInt("SALARY"));
				selectEmp.setBouns(rset.getDouble("BONUS")); 
				selectEmp.setManagerId(rset.getString("MANAGER_ID"));
				selectEmp.setHireDate(rset.getDate("HIRE_DATE"));
				selectEmp.setEntDate(rset.getDate("ENT_DATE"));
				selectEmp.setEntYn(rset.getString("ENT_YN"));

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rset);
			close(pstmt);
			close(con);
			
		}

		System.out.println(selectEmp);
		 
	}

}
