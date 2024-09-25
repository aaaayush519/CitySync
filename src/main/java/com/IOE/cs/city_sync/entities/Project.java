package com.IOE.cs.city_sync.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="PROJECT")
public class Project {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Department", referencedColumnName = "id")
	private Department department;
	
	@Column(name="DESCRIPTION")
	private String Description;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="PROJECT_START_DATE")
	private Date startDate;
	
	@Column(name="PROJECT_END_DATE")
	private Date endDate;
	
	@Column(name="UPLOAD_DATE")
	private Date uploadDate;
	
	@Column(name="isInterdepartmental")
	private Boolean isInterdepartmental;

}

