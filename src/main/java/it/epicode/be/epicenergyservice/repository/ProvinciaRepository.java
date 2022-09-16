package it.epicode.be.epicenergyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.epicenergyservice.model.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
	
}
