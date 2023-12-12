package com.senai.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.PrjEmpresa.entities.*;
import com.senai.PrjEmpresa.repositories.*;

@Service
public class FuncionarioService {

private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService( FuncionarioRepository FuncionarioRepository) {
		this.funcionarioRepository = FuncionarioRepository;
	}
	
	public Funcionario saveFuncionario (Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> getFuncionarioByfunnomeAproximado(String funnome){
		  return funcionarioRepository.findByNomeContaining(funnome);
	}
	
	public boolean deletefuncionario(Long id) {
		Optional<Funcionario> FuncionarioExistente = funcionarioRepository.findById(id);
		if (FuncionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Funcionario getFuncionarioBy (Long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public void deleteFuncionario (Long funcodigo) {
		funcionarioRepository.deleteById(funcodigo);
	}
		
		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
			Optional<Funcionario> FuncionarioOptional = funcionarioRepository.findById(funcodigo);
			if (FuncionarioOptional.isPresent()) {
				Funcionario FuncionarioExistente = FuncionarioOptional.get();
					FuncionarioExistente.setfunnome(novoFuncionario.getnome());
					FuncionarioExistente.setfunnascimento(novoFuncionario.getnascimento());
					FuncionarioExistente.setfunsalario(novoFuncionario.getsalario());
					
					
					if (novoFuncionario.getDepartamento() != null) {
						FuncionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
					}
					return funcionarioRepository.save(FuncionarioExistente);
			}else{
				return null;
			}
	}

		public Funcionario getFuncionarioById(Long funcodigo) {
			// TODO Auto-generated method stub
			return null;
		}

}
