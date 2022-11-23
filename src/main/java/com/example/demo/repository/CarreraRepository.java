package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Integer>{

	@Query("SELECT c FROM Carrera c WHERE size(c.estudiantes)> 0 ORDER BY  size(c.estudiantes) DESC ")
	List<Carrera> getCarrerasInscriptos();

}
