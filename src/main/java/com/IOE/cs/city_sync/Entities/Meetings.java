package com.IOE.cs.city_sync.Entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MEETINGS")
public class Meetings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="MEETING_LOCATION")
	private String location;
	
	@Column(name="AGENDA")
	private String agenda;
		
	@Column(name="MEETING_DATE")
	private Date meetingDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID", referencedColumnName = "id")
	private Project project;
}
