package com.IOE.cs.city_sync.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class CSUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Department_ID", referencedColumnName = "id")
	private Department department;

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name="PASSWORD")
	private String password;
}
