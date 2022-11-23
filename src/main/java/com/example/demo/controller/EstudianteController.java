package com.example.demo.controller;
import com.example.demo.dto.EstudianteDTO;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Estudiante;
import com.example.demo.service.EstudianteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;

	@RequestMapping(value="", method=RequestMethod.POST,produces="application/json")
	@Operation(
            summary = "Agregar un estudiante nuevo.",
            description = "Funcionalidad para agregar un estudiante nuevo.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
	public ResponseEntity<?> agregarEstudiante(@RequestBody EstudianteDTO estudiante){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.agregarEstudiante(estudiante));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR: Datos incorrectos y/o insuficientes.\"}");
        }
	}

    @GetMapping("")
	@Operation(
            summary = "Retorna el listado de estudiantes ordenados por apellido.",
            description = "Funcionalidad  para obtener lista de estudiantes ordenados alfabéticamente por apellido.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
	public ResponseEntity<?> getEstudiantes() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.getEstudiantes());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR: No existen estudiantes. \"}");
        }
	}

	@GetMapping("/{LU}")
    @Operation(
            summary = "Retorna un estudiante segun su número de libreta universitaria.",
            description = "funcionalidad para obtener un estudiante por libreta universitaria ingresada por parámetro.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getEstudianteByLU(@PathVariable int LU){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.getEstudiantesByLU(LU));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR: No se encontro el estudiante.\"}");
        }
    }

    @RequestMapping(value="/genero/{genero}", method=RequestMethod.GET)
    @Operation(
            summary = "Retorna una lista de estudiantes por género.",
            description = "Funcionalidad para obtener una lista de estudiantes por género ingresado por parámetro.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getEstudiantesByGenero(@PathVariable String genero){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.getEstudiantesByGenero(genero));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR: No se encuentran estudiantes con el género ingresado.\"}");
        }
    }

	@GetMapping("/carrera/{idCarrera}")
    @Operation(
            summary = "Retorna una lista de estudiantes por carrera y ciudad.",
            description = "Funcionalidad para obtener los estudiantes por carrera y ciudad ingresadas por parámetro.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getEstudiantesByCarreraByCiudad(@PathVariable int idCarrera, @RequestParam String ciudad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.getEstudiantesByCarreraByCiudad(idCarrera, ciudad));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR: No se existen estudiantes de la carrera y/o ciudad ingresadas.\"}");
        }
    }

}

	
