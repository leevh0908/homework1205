package com.example;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.DeptRepository;

import com.example.pojo.Football;
import com.example.serives.Fservice;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springmvc4ApplicationTests {


	@Autowired
	private Fservice fservice;
	
	@Test
	public void doSomething() {
	  //  List<Football> persons = fdao.findAll();
	//	List<Football> persons = fdao.findByBname("sd");
//		List<Football> persons = dr.
//	    System.out.println(persons);
		
		//fs.findall();
	//	fs.findonebyname("中超用球");
		//fs.del("111");
	//fservice.delid(1);
		//Football football = new Football("111", "111");
		//fservice.delid(5);
		//fservice.add(football);
		//fservice.updata("111", "333", "ddd");
		//fservice.getP();
		fservice.findonebyname("333");
		
		
	  }

}
