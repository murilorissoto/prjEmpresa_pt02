package com.senai.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.PrjEmpresa.entities.*;
import com.senai.PrjEmpresa.repositories.*;

@Service
public class DepartamentoService {

private final DepartamentoRepository DepartamentoRepository;
	
	@Autowired
	public DepartamentoService( DepartamentoRepository DepartamentoRepository) {
		this.DepartamentoRepository = DepartamentoRepository;
	}
	
	public Departamento saveDepartamento (Departamento departamento) {
		return DepartamentoRepository.save(departamento);
	}
	
	public Departamento getDepartamentoBy (Long depcodigo) {
		return DepartamentoRepository.findById(depcodigo).orElse(null);
	}
	
	public List<Departamento> getAllDepartamento(){
		return DepartamentoRepository.findAll();
	}
	
	public void deleteDepartamento (Long depcodigo) {
		DepartamentoRepository.deleteById(depcodigo);
	}
		
		public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
			Optional<Departamento> DepartamentoOptional = DepartamentoRepository.findById(depcodigo);
			if (DepartamentoOptional.isPresent()) {
				Departamento DepartamentoExistente = DepartamentoOptional.get();
					DepartamentoExistente.setdepnome(novoDepartamento.getnome());
				DepartamentoExistente.setdepnome(novoDepartamento.getnome());
					return DepartamentoRepository.save(DepartamentoExistente);
			}else{
				return null;
			}
	}

}


