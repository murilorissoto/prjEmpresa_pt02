package com.senai.PrjEmpresa.entities;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="/funcionario")
public class Funcionario {
	
	
	@ManyToOne
	private Departamento departamento;
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;
	
	private String funnome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;
	
	private double funsalario;
	
	public Long getFuncodigo() {
		return funcodigo;
	}
	
	public Funcionario(Long funcodigo, String funnome ) {
		super();
		this.funcodigo = funcodigo;
		this.funnome = funnome;
	}
	
	public Long Getfuncodigo() {
		return funcodigo;
	}
	
	public void setfuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getnome() {
		return funnome;
	}

	public void setfunnome(String funnome) {
		this.funnome = funnome;
	}
	
	public LocalDate getnascimento() {
		return funnascimento;
	}

	public void setfunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}
	public Double getsalario() {
		return funsalario;
	}

	public void setfunsalario(Double funsalario) {
		this.funsalario = funsalario;
	}
	}
	
