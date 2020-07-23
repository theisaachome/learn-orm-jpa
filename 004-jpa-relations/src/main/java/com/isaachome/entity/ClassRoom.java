package com.isaachome.entity;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="class")
public class ClassRoom implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	
	@ManyToOne
	private Course course;
	
	@ElementCollection
	@CollectionTable(name="class_days",joinColumns = @JoinColumn(name="class_id"))
	private List<DayOfWeek>  days =new ArrayList<DayOfWeek>();
	private LocalDate starteDate;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	@ManyToMany
	private List<Student> students;

}
