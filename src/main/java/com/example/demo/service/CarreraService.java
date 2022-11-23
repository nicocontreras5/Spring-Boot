package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CarreraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Carrera;
import com.example.demo.repository.CarreraRepository;

@Service
public class CarreraService {

	
	@Autowired
	private CarreraRepository carreraRepository;

	public Carrera agregarCarrera(@RequestBody CarreraDTO c) {

		return carreraRepository.save(new Carrera(c.getId(),c.getName(), c.getDuracion()));
	}

	public List<Carrera> getCarrerasInscriptos(){
		return carreraRepository.getCarrerasInscriptos();
	}
}
