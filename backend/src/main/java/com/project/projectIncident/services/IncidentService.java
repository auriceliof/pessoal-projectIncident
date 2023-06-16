package com.project.projectIncident.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.projectIncident.dto.IncidentDTO;
import com.project.projectIncident.entities.Incident;
import com.project.projectIncident.repositories.IncidentRepository;

@Service
public class IncidentService {

	@Autowired
	private IncidentRepository repository;
	
	@Transactional(readOnly = true)
	public List<IncidentDTO> findAll(){
		
		List<Incident> list = repository.findAll();
		
		return list.stream().map(x -> new IncidentDTO(x)).collect(Collectors.toList());
	}
}
