package com.rahul.springboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.rahul.springboot.tutorial.entity.Department;
import com.rahul.springboot.tutorial.repository.DepartmentRepository;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() {
		
		Department department=new Department(1L,"IT","ASR","IT-01");
		entityManager.persist(department);
	}
	
	@Test
	public void whenFindById_thenReturnDepartment()
	{
		departmentRepository.findById(1L).get();
	}

	

}
