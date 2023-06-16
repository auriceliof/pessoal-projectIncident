package com.project.projectIncident.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.projectIncident.entities.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long>{

}
