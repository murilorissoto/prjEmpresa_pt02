package com.senai.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.PrjEmpresa.entities.*;
import com.senai.PrjEmpresa.services.*;

@RestController
@RequestMapping("/departamento")
public class DepartamentoControler {
	
	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoControler(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; 
	}

	@GetMapping("/(id)")
	public ResponseEntity<Departamento> getdepartamento(@PathVariable Long depcodigo) {
		Departamento departamento = departamentoService.getDepartamentoBy(depcodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);

	}

	@GetMapping("/{id}")
	public Departamento getDepartamento(@PathVariable Long depcodigo) {
		return departamentoService.getDepartamentoBy(depcodigo);
	}
	
	public List<Departamento> getAllDepartamento() {
		return departamentoService.getAllDepartamento();
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long id) {
		departamentoService.deleteDepartamento(id);
	}

		@GetMapping
		public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Departamento> departamento = departamentoService.getAllDepartamento();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(departamento);
		}
		
		@PutMapping("/{id}")
		public Departamento updateDepartamento(@PathVariable Long depcodigo, @RequestBody Departamento departamento) {
		    return departamentoService.updateDepartamento(depcodigo, departamento);
		}
}
