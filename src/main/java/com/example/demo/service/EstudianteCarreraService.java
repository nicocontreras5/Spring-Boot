package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.InscripcionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ReporteDTO;
import com.example.demo.entity.Carrera;
import com.example.demo.entity.Estudiante;
import com.example.demo.entity.EstudianteCarrera;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteCarreraRepository;
import com.example.demo.repository.EstudianteRepository;

@Service
public class EstudianteCarreraService {
	
	@Autowired
	private EstudianteCarreraRepository estudianteCarreraRepository;
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private CarreraRepository carreraRepository;
	
	public EstudianteCarrera matricular(InscripcionDTO inscripcion) {

		Estudiante e = estudianteRepository.findById(inscripcion.getIdEstudiante()).get();
		Carrera c = carreraRepository.findById(inscripcion.getIdCarrera()).get();
		EstudianteCarrera ec = new EstudianteCarrera(e, c, inscripcion.getInscripcion(), inscripcion.getGraduacion());
		return estudianteCarreraRepository.save(ec);
	}

	public List<ReporteDTO> getReporte(){
		return estudianteCarreraRepository.getReporte();
	}
	
}
