package com.rahul.springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rahul.springboot.tutorial.entity.Department;
import com.rahul.springboot.tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp()
	{
		Department department=new Department(1L,"IT","ASR","IT-01");
		Mockito.when(departmentRepository.findBydepartmentName("IT")).thenReturn(department);		
	}
	
	@Test
	public void whenValidDepartmentName_thenDepartmentShouldFound()
	{
		String departmentName= "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
		
	}

	

}
