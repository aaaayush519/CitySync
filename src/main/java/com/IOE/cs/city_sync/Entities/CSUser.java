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
	
	@Column(name="PASSWORD")
	private String password;
}
