package com.isaachome.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
@Entity
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@Temporal(TemporalType.DATE)
	private Date foundedDate;
	private BigDecimal averageYearlySales;
	private Boolean active;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="MANUFACTURER_ID")
	private List<Model> models = new ArrayList<>();
	
	@ManyToOne
	private Location headquarters;
}
