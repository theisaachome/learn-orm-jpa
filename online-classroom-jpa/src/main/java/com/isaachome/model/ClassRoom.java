package com.isaachome.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// Many ClassRoom will have same one  course teaching
	@ManyToOne
	private Course course;
	// One ClassRoom will have many Students
	@OneToMany
	@JoinTable(name = "class_students")
	private List<Student> students = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "class_days",joinColumns = @JoinColumn(name="class_id"))
	private List<DayOfWeek> days;
	private LocalDate startDate;
	private LocalTime timeFrom;
	private LocalTime timeTo;
}
