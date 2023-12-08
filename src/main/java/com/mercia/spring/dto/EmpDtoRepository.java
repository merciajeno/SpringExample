package com.mercia.spring.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpDtoRepository {
	List<EmpDto> empList = new ArrayList<>();
	
	public void addEmployee(EmpDto employee)
	{
		empList.add(employee);
	}
	
//	public EmpDto findById(int id)
//	{
//		return empList.remove(id);
//	}

	public List<EmpDto> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmpDto> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "EmpDtoRepository [empList=" + empList + "]";
	}

	public List<EmpDto> findAll() {
		// TODO Auto-generated method stub
		return empList;
	}
	
	public Optional<EmpDto> findById(int id)
	{
		for(EmpDto dto:empList)
			if(dto.getEmpId()==id)
				return Optional.of(dto);
		return null;
	}

}
