package com.project.projectIncident.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_incident")
public class Incident implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reportVictim;
	private String violationVictim;
	private String providence;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dateRegister;
	
	public Incident() {
		
	}

	public Incident(Long id, String reportVictim, String violationVictim, String providence, Instant dateRegister) {
		super();
		this.id = id;
		this.reportVictim = reportVictim;
		this.violationVictim = violationVictim;
		this.providence = providence;
		this.dateRegister = dateRegister;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportVictim() {
		return reportVictim;
	}

	public void setReportVictim(String reportVictim) {
		this.reportVictim = reportVictim;
	}

	public String getViolationVictim() {
		return violationVictim;
	}

	public void setViolationVictim(String violationVictim) {
		this.violationVictim = violationVictim;
	}

	public String getProvidence() {
		return providence;
	}

	public void setProvidence(String providence) {
		this.providence = providence;
	}

	public Instant getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Instant dateRegister) {
		this.dateRegister = dateRegister;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incident other = (Incident) obj;
		return Objects.equals(id, other.id);
	}
}
