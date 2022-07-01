package com.rahul.springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.springboot.tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	public Department findBydepartmentName(String departmentName);

	
	public Department findBydepartmentNameIgnoreCase(String departmentName);
}
