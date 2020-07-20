package com.isaachome.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RegistrationId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	private int studentId;
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + studentId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationId other = (RegistrationId) obj;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	
}
