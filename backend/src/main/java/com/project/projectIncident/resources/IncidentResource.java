package com.project.projectIncident.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.projectIncident.dto.IncidentDTO;
import com.project.projectIncident.services.IncidentService;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentResource {

	@Autowired
	private IncidentService service;

	/*
	@GetMapping
	public ResponseEntity<List<IncidentDTO>> findAll() {

		List<IncidentDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	*/
	
	@GetMapping
	public ResponseEntity<Page<IncidentDTO>> findAll(Pageable pageable) {

		Page<IncidentDTO> list = service.findAllPaged(pageable);

		return ResponseEntity.ok().body(list);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<IncidentDTO> findById(@PathVariable Long id) {

		IncidentDTO dto = service.findById(id);

		return ResponseEntity.ok().body(dto);
	}

	
	@PostMapping
	public ResponseEntity<IncidentDTO> insert(@RequestBody IncidentDTO dto) {

		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<IncidentDTO> update(@PathVariable Long id, @RequestBody IncidentDTO dto) {

		dto = service.update(id, dto);

		return ResponseEntity.ok().body(dto);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}














