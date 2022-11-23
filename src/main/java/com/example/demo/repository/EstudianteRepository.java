package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	@Query("SELECT e FROM Estudiante e ORDER BY e.apellido ASC")
	List<Estudiante> getEstudiantes();

	@Query("SELECT e FROM Estudiante e WHERE e.num_libreta = :LU")
	Estudiante getEstudianteByLU(int LU);
	
	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	List<Estudiante> getEstudiantesByGenero(String genero);

	@Query("SELECT DISTINCT(e) FROM Estudiante e JOIN e.carreras c WHERE c.id = :idCarrera AND e.ciudad = :ciudad")
	List<Estudiante> getEstudiantesByCarreraByCiudad(int idCarrera, String ciudad);
	
}

