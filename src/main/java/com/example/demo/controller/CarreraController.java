package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Carrera;
import com.example.demo.service.CarreraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("carreras")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@PostMapping("")
	@Operation(
            summary = "Agregar una carrera nueva.",
            description = "funcionalidad para agregar una carrera nueva.",
            tags = { "CarreraController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrera.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
	public ResponseEntity<?> agregarCarrera(@RequestBody Carrera c){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.agregarCarrera(c));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Datos incorrectos y/o insuficientes.\"}");
        }
	}


	@GetMapping("/inscriptos")
	@Operation(
            summary = "Devuelve el listado: Carreras con estudiantes.",
            description = "Funcionalidad para recuperar las carreras con estudiantes inscriptos, y ordena por cantidad de inscriptos.",
            tags = { "CarreraController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrera.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
	public ResponseEntity<?> getCarrerasInscriptos() {
	        try{
	            return ResponseEntity.status(HttpStatus.OK).body(carreraService.getCarrerasInscriptos());
	        }catch (Exception e){
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No hay carreras con inscriptos.\"}");
	        }
	}

}