package com.isaachome.one2one.bidirection;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployeeCard implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String employeNumber;
	private String empTitle;
	@OneToOne
	private Employee lineManager;
	
	
	@OneToOne(mappedBy = "empCard")
	private Employee emp;
	public String getEmployeNumber() {
		return employeNumber;
	}
	public void setEmployeNumber(String employeNumber) {
		this.employeNumber = employeNumber;
	}
	public String getEmpTitle() {
		return empTitle;
	}
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getLineManager() {
		return lineManager;
	}
	public void setLineManager(Employee lineManager) {
		this.lineManager = lineManager;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
}
