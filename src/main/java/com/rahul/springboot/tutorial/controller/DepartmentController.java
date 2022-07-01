package com.rahul.springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.springboot.tutorial.entity.Department;
import com.rahul.springboot.tutorial.error.DepartmentNotFoundException;
import com.rahul.springboot.tutorial.service.DepartmentService;
import com.rahul.springboot.tutorial.service.DepartmentServiceImpl;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department)
	{
		//DepartmentService departmentService=new DepartmentServiceImpl();
		LOGGER.info("inside saveDepartment of DepartmentController");
		
		return departmentService.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList()
	{
		//DepartmentService departmentService=new DepartmentServiceImpl();
		
		LOGGER.info("inside FetchDepartment of DepartmentController");
		return  departmentService.fetchDepartmentList();
		
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException
	{
		return departmentService.fetchDepartmentById(departmentId);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId)
	{
		departmentService.deleteDepartmentById(departmentId);
		return "department deleted Sucssfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department)
	{
		return departmentService.updateDepartment(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
	{
		return departmentService.fetchDepartmentByName(departmentName);
	}
}
