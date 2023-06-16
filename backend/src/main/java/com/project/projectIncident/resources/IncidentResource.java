package com.project.projectIncident.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.projectIncident.entities.Incident;
import com.project.projectIncident.services.IncidentService;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentResource {

	@Autowired
	private IncidentService service;
	
	@GetMapping
	public ResponseEntity<List<Incident>> findAll(){
	
		List<Incident> list = service.findAll();
		
		return ResponseEntity.ok().body(list);		
	}
}
