package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class EstudianteCarrera {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="idEstudiante", insertable = true, updatable = false)
	private Estudiante idEstudiante;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="idCarrera", insertable = true, updatable = false)
	private Carrera idCarrera;
	@Column
	private int inscripcion;
	@Column
	private int graduacion;

	public EstudianteCarrera() {
		super();
	}

	public EstudianteCarrera(Estudiante idEstudiante, Carrera idCarrera, int inscripcion,
			int graduacion) {
		this.idEstudiante = idEstudiante;
		this.idCarrera = idCarrera;
		this.inscripcion = inscripcion;
		this.graduacion = graduacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Carrera getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}

	public int getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(int inscripcion) {
		this.inscripcion = inscripcion;
	}

	public int getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(int graduacion) {
		this.graduacion = graduacion;
	}

	@Override
	public String toString() {
		return "EstudianteCarrera{" +
				"id=" + id +
				", idEstudiante=" + idEstudiante +
				", idCarrera=" + idCarrera +
				", inscripcion=" + inscripcion +
				", graduacion=" + graduacion +
				'}';
	}
}
