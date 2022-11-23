package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.ReporteDTO;
import com.example.demo.entity.EstudianteCarrera;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Integer> {

	@Query("SELECT NEW com.example.demo.dto.ReporteDTO (ec.inscripcion AS anio, ec.idCarrera.nombre AS nombreCarrera, COUNT(ec.inscripcion) AS inscriptos, COUNT(ec.graduacion) AS graduados) "
			+ "FROM EstudianteCarrera ec "
			+ "GROUP BY anio, ec.idCarrera.nombre "
			+ "ORDER BY ec.idCarrera.nombre ASC, anio ASC ")
	public List<ReporteDTO> getReporte();
		
}
