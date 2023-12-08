package com.mercia.spring.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercia.spring.dto.EmpDto;
import com.mercia.spring.dto.EmpDtoRepository;

@RestController
public class CourseController {
	EmpDtoRepository repository;
	public CourseController()
	{
		System.out.println("Initialising employee");
		repository = new EmpDtoRepository();
		repository.addEmployee(new EmpDto("Mercia",1,new BigDecimal(3834348)));
		repository.addEmployee(new EmpDto("Shania",2,new BigDecimal(3348)));
		repository.addEmployee(new EmpDto("Issac",3,new BigDecimal(38)));
		
	}
	
	@GetMapping("/course")
	public List<EmpDto> get(){
		return repository.findAll();
	}
	
	@GetMapping("/course/")
	public EmpDto getCourse(@RequestParam int id)
	{
	    Optional<EmpDto> emp = repository.findById(id);
	    if(emp.isEmpty())
	    	throw new RuntimeException("The employee with id : "+id+" is not found");
		return emp.get();
		
	}
	
	@PostMapping("/course")
	public void createCourse(@RequestBody EmpDto employee)
	{
		repository.addEmployee(employee);
	}
	
	@PutMapping("/course/{id}")
	public void updateCourse(@PathVariable int id,@RequestBody EmpDto employee)
	{
		
		Optional<EmpDto> emp = repository.findById(id);
	    if(emp.isEmpty())
	    	throw new RuntimeException("The employee with id : "+id+" is not found");
	    else
	    {
	    	List<EmpDto> list = repository.findAll();
	    	for(EmpDto dto:list)
	    	{
	    		if(dto.getEmpId()==id)
	    		{
	    			dto.setEmpName(employee.getEmpName());
	    			dto.setEmpSalary(employee.getEmpSalary());
	    		}
	    	}
	    }
	}
	
	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable int id)
	{
		List<EmpDto> emp = repository.findAll();
		Iterator<EmpDto> it = emp.iterator();
		while(it.hasNext())
		{
			EmpDto dto = it.next();
			if(dto.getEmpId()==id)
				it.remove();
		}
	}
	
	
}
