package com.project.projectIncident.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.projectIncident.dto.IncidentDTO;
import com.project.projectIncident.entities.Incident;
import com.project.projectIncident.repositories.IncidentRepository;

@Service
public class IncidentService {

	@Autowired
	private IncidentRepository repository;
	
	/*
	@Transactional(readOnly = true)
	public List<IncidentDTO> findAll(){
		
		List<Incident> list = repository.findAll();
		
		return list.stream().map(x -> new IncidentDTO(x)).collect(Collectors.toList());
	}
	*/
	
	@Transactional(readOnly = true)
	public Page<IncidentDTO> findAllPaged(Pageable pageable){
		
		Page<Incident> list = repository.findAll(pageable);
		
		return list.map(x -> new IncidentDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public IncidentDTO findById(Long id){
		
		Optional<Incident> obj = repository.findById(id);
		Incident entity = obj.get();
		
		return new IncidentDTO(entity);
	}
	
	
	@Transactional
	public IncidentDTO insert(IncidentDTO dto) {
		
		Incident entity = new Incident();
		entity.setProvidence(dto.getProvidence());
		entity.setReportVictim(dto.getReportVictim());
		entity.setViolationVictim(dto.getViolationVictim());
		
		entity = repository.save(entity);
		
		return new IncidentDTO(entity);
	} 
	
	
	@Transactional
	public IncidentDTO update(Long id, IncidentDTO dto) {
		
		Incident entity = repository.getReferenceById(id);
		entity.setProvidence(dto.getProvidence());
		entity.setReportVictim(dto.getReportVictim());
		entity.setViolationVictim(dto.getViolationVictim());
		
		entity = repository.save(entity);
		
		return new IncidentDTO(entity);
	}
	
	
	public void delete(Long id) {
	
		repository.deleteById(id);
	}
	
}




















