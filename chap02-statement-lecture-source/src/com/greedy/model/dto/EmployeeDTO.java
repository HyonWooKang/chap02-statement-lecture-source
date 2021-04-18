package com.greedy.model.dto;

import java.sql.Date;

/* DTO(Data Transfer Object)
 * : 데이터를 여러 계층간 전송을 위해 다양한 타입의 데이터를 하나로 묶이 위한 용도의 클래스
 *   유사한 말로 VO, Bean, Entity, (DO, Domain, Row) 등으로 사용한다.
 */

/*
 * DTO 클래스의 조건 (VO와 동일함)
 * 1. 모든 필드를 private로 만들어라
 * 2. 기본 생성자와 모든 필드를 초기화하는 생성자를 넣어주자 (모든 필드는 선택사항)
 * 3. 모든 필드에 대한 setter/getter 만들어줘야 한다.
 * 4. toString() Overriding을 이용한 필드값 반환용 메소드를 만들어야 한다.
 *    -- 주소값 반환하는 메소드 => 해당 필드의 값을 빌려와서 반환하는 메소드
 * 5. 직렬화처리
 */

public class EmployeeDTO implements java.io.Serializable {
	// 현재 코드로는 serializable이 필수는 아님

	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bouns;
	private String managerId;
	private java.sql.Date hireDate;
	private java.sql.Date EntDate;
	private String entYn;
	
	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(String empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, double bouns, String managerId, Date hireDate, Date entDate,
			String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bouns = bouns;
		this.managerId = managerId;
		this.hireDate = hireDate;
		EntDate = entDate;
		this.entYn = entYn;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public java.sql.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.sql.Date hireDate) {
		this.hireDate = hireDate;
	}

	public java.sql.Date getEntDate() {
		return EntDate;
	}

	public void setEntDate(java.sql.Date entDate) {
		EntDate = entDate;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel=" + salLevel
				+ ", salary=" + salary + ", bouns=" + bouns + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", EntDate=" + EntDate + ", entYn=" + entYn + "]";
	}
	
	
	
	
}
