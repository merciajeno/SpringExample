package com.mercia.spring.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercia.spring.dto.EmpDto;

@RestController
public class CourseController {
	private List<EmpDto> empList = new ArrayList<>();
	public CourseController()
	{
		System.out.println("Initialising employee");
		empList.add(new EmpDto("Mercia", 123, new BigDecimal(49539593)));
		empList.add(new EmpDto("Shania", 124, new BigDecimal(4953)));
		empList.add(new EmpDto("Issac", 125, new BigDecimal(4957)));
		empList.add(new EmpDto("Merline", 126, new BigDecimal(4967)));
	}
	
	@GetMapping("/course")
	public List<EmpDto> get(){
		return empList;
	}
}
