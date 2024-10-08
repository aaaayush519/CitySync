package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SHARED_RESOURCES")
public class SharedResource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RESOURCE_Id" , referencedColumnName = "id")
	private Resource ResourceID;
	
	@Column(name = "Shared_Quantity")
	private Integer sharedQuantity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Project_Id", referencedColumnName = "id")
	private Project ProjectId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Shared_Dept_Id" , referencedColumnName = "id")
	private Department sharedDeptId;
	
}

