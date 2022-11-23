package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public Estudiante agregarEstudiante(EstudianteDTO e) {
		return estudianteRepository.save(new Estudiante( e.getDNI(),e.getNombre(),e.getApellido(),e.getEdad(),e.getGenero(),e.getCiudad(),e.getNum_libreta()));
	}
	
	public List<Estudiante> getEstudiantes() {
		return estudianteRepository.getEstudiantes();
	}

	public Estudiante getEstudiantesByLU(int LU) {
		return estudianteRepository.getEstudianteByLU(LU);
	}  
	
	public List<Estudiante> getEstudiantesByGenero(String genero){
		return estudianteRepository.getEstudiantesByGenero(genero);
	} 

	public List<Estudiante> getEstudiantesByCarreraByCiudad(int idCarrera, String ciudad){
		return estudianteRepository.getEstudiantesByCarreraByCiudad(idCarrera, ciudad);
	}
	
}
