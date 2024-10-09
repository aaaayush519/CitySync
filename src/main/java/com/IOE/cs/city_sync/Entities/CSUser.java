package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class CSUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Department_ID", referencedColumnName = "id")
	private Department department;

	@Column(name="EMAIL")
	private String email;

	@Column(name="USERNAME")
	private String username;

	public CSUser() {

	}

	public void setUsername(){
		this.username = this.email.substring(0,this.email.indexOf('@'));
	}
	@Override
	public String toString() {
		return "CSUser{" +
				"id=" + id +
				", name='" + name + '\'' +
				", department=" + department +
				", email='" + email + '\'' +
				", role='" + role + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	@Column(name="ROLE")
	private String role;

//	public CSUser(Integer id, String password, String role, String username, String email, Department department, String name) {
//		this.id = id;
//		this.password = password;
//		this.role = role;
//		this.username = email.substring(0,email.indexOf('@'));
//		this.email = email;
//		this.department = department;
//		this.name = name;
//	}

	@Column(name="PASSWORD")
	private String password;
}
