package com.isaachome.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.id.UUIDHexGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;


@Data
@Entity
public class ConferenceEvent implements Serializable {

	@Id
//	@GenericGenerator(
//			name = "uuid",
//			strategy = "org.hibernate.id.UUIDHEXGenerator",
//			parameters = {@Parameter(name="separator",value = "-")})
//	@GeneratedValue(generator =  "uuid")
	private String id;
	private String name;
	private LocalDate event_date;
}
