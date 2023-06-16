package com.project.projectIncident.dto;

import java.io.Serializable;
import java.time.Instant;

import com.project.projectIncident.entities.Incident;

public class IncidentDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String reportVictim;
	private String violationVictim;
	private String providence;
	private Instant dateRegister;
	
	public IncidentDTO() {
		
	}

	public IncidentDTO(Long id, String reportVictim, String violationVictim, String providence, Instant dateRegister) {
		super();
		this.id = id;
		this.reportVictim = reportVictim;
		this.violationVictim = violationVictim;
		this.providence = providence;
		this.dateRegister = dateRegister;
	}
	
	public IncidentDTO(Incident entity) {
		super();
		id = entity.getId();
		reportVictim = entity.getReportVictim();
		violationVictim = entity.getViolationVictim();
		providence = entity.getProvidence();
		dateRegister = entity.getDateRegister();
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
	
	
}
