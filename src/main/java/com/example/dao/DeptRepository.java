package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pojo.Football;
import java.lang.Integer;

public interface DeptRepository extends JpaRepository<Football, Integer>, JpaSpecificationExecutor<Football> {
	List<Football> findByFname(String name);
	
//	@Query("select d from football d where id=:dd ")
//	Football findById(@Param("dd") Integer id);

	


	
}
