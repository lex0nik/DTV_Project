package com.springboot.demo.model;



import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;





@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO, 
		    generator="native"
		)//for dont create the extra hibernate table for auto increments in db
		@GenericGenerator(
		    name = "native", 
		    strategy = "native"
		)
	@Column(name = "user_id")
	private Long userId;
	@Column( nullable=false , length=25)
	private String email;
	@Column( nullable=false , length=25)
	private String name;

	@Column( name="password" , nullable=false , length=250)
	private String password;
	

	
	
	@Column( nullable=false , length=25)
	private String company;
	@Column( nullable=false , length=25)
	private String phone;
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}

