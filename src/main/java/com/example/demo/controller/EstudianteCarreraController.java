package com.example.demo.controller;
import com.example.demo.dto.InscripcionDTO;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EstudianteCarrera;
import com.example.demo.service.EstudianteCarreraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;


@RestController
@RequestMapping("estudianteCarrera")
public class EstudianteCarreraController {

	@Autowired
	private EstudianteCarreraService estudianteCarreraService;

	@RequestMapping(value="/inscribir", method=RequestMethod.POST,produces="application/json")
	@Operation(
            summary = "Inscribir un estudiante en una carrera.",
            description = "funcionalidad para inscribir un estudiante en una carrera.",
            tags = { "EstudianteCarreraController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstudianteCarrera.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
	public ResponseEntity<?> inscribir(@RequestBody InscripcionDTO inscripcion){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteCarreraService.matricular(inscripcion));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR: Datos incorrectos y/o insuficientes.\"}");
        }
	}
	

	@GetMapping("/reporte")
	@Operation(
            summary = "Devuelve un listado de reportes para cada carrera.",
            description = "Funcionalidad para genera un reporte de las carreras, incluyendo información de los inscriptos y egresados por año." +
                        "También se ordenan las carreras alfabéticamente, y se muestran los años de manera cronológica.",
            tags = { "EstudianteCarreraController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstudianteCarrera.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
	public ResponseEntity<?> getReporte() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteCarreraService.getReporte());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR: No existen carreras con inscriptos.\"}");
        }
	}
}