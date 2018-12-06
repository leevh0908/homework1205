package com.example.serives;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DeptRepository;
import com.example.pojo.Football;



@Service
public class Fservice {

	@Autowired
	DeptRepository deptRepository;

	// 查所有分页
	public void getP() {
		// TODO Auto-generated method stub
			Map map = new HashMap();
			Page<Football> pageList;
			Specification<Football> spec = new Specification<Football>() {
				public Predicate toPredicate(Root<Football> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					// 查询出未删除的
					list.add(cb.equal(root.<String>get("fvalue"), "123"));
					//System.out.println(list);
					return cb.and(list.toArray(new Predicate[0]));
				}
			};
			pageList = deptRepository.findAll(spec, new PageRequest(0, 10, new Sort(Direction.ASC, "id")));

			map.put("total", pageList.getTotalElements());
			List<Football> list = pageList.getContent();

			map.put("depts", list);
System.out.println(map);

	}

	// 查所有
	public void findall() {
		List<Football> list = deptRepository.findAll();
		System.out.println(list);
	}

	// 通过名字查（属性）
	public void findonebyname(String name) {
		List<Football> list = deptRepository.findByFname(name);

		System.out.println(list);
	}



	// 通过id删除
	@Transactional(propagation = Propagation.REQUIRED)
	public void delid(Integer id) {
		deptRepository.deleteById(id);
	}

	// 插入
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(Football football) {
		deptRepository.saveAndFlush(football);
	}
	//修改
	@Transactional(propagation = Propagation.REQUIRED)
	public void updata(String name ,String newname,String value) {
		
		List<Football> list=deptRepository.findByFname(name);
		Football f=list.get(0);
		f.setFname(newname);
		f.setFvalue(value);
		deptRepository.saveAndFlush(f);
	}
	
}
