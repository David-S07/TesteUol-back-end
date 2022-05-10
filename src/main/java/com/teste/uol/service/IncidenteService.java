package com.teste.uol.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.uol.dto.IncidenteDto;
import com.teste.uol.repository.IncidenteRepository;

@Service
public class IncidenteService {
	
	@Autowired
	private IncidenteRepository incidenteRepository;
	
	public List<IncidenteDto> listar() {
		return incidenteRepository.findAll().stream().map(i -> new IncidenteDto(i)).collect(Collectors.toList());
	}
}
