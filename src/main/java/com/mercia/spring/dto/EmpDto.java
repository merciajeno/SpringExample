package com.mercia.spring.dto;

import java.math.BigDecimal;

public class EmpDto {

	public EmpDto() {
		super();
	}
	public EmpDto(String empName, int empId, BigDecimal empSalary) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empSalary = empSalary;
	}
	private String empName;
	private int empId;
	private BigDecimal empSalary;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public BigDecimal getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(BigDecimal empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "EmpDto [empName=" + empName + ", empId=" + empId + ", empSalary=" + empSalary + "]";
	}
	
	
}
