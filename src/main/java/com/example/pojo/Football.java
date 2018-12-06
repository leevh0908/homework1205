package com.example.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Football {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;// id
	
	@Column(name = "fname", nullable = true, length = 20)
	private String fname;
	
	@Column(name = "fvalue", nullable = true, length = 20)
	private String fvalue;

	public Football() {
		super();
	}

	public Football(String fname, String fvalue) {
		super();
		this.fname = fname;
		this.fvalue = fvalue;
	}

	public Football(Integer id, String fname, String fvalue) {
		super();
		this.id = id;
		this.fname = fname;
		this.fvalue = fvalue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFvalue() {
		return fvalue;
	}

	public void setFvalue(String fvalue) {
		this.fvalue = fvalue;
	}

	@Override
	public String toString() {
		return "Football [id=" + id + ", fname=" + fname + ", fvalue=" + fvalue + "]";
	}
	
	

	
}
