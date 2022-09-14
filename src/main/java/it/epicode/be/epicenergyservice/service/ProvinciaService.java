package it.epicode.be.epicenergyservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.epicenergyservice.exception.EpicEnergyException;
import it.epicode.be.epicenergyservice.model.Provincia;
import it.epicode.be.epicenergyservice.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

	@Autowired
	ProvinciaRepository provinciaRepository;
	
	public Optional<Provincia> findById(Long id) {
		Optional<Provincia> provincia = provinciaRepository.findById(id);
		if (provincia.isPresent())
			return provinciaRepository.findById(id);
		else
			throw new EpicEnergyException(
					"Provincia non trovata! Inserisci un altro id");

	}

	public Page<Provincia> findAll(Pageable pageable) {
		return provinciaRepository.findAll(pageable);
	}
	
	public List<Provincia> findAll() {
		return provinciaRepository.findAll();
	}
	
}
