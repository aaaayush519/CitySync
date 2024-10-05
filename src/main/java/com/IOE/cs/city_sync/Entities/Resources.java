package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESOURCES")
public class Resources {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Project_Id" , referencedColumnName = "id")
	private Project project;
	
	@Column(name="DESCRIPTION")
	private String Description;
	
	@Column(name="isAvailable")
	private Boolean isAvailable;
	
	@Column(name="Quantity")
	private Integer Quantity;
}
