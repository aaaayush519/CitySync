package com.IOE.cs.city_sync.Entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date meetingDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID", referencedColumnName = "id")
	private Project project;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ADDED_BY", referencedColumnName = "id")
	private CSUser addedBy;
}
