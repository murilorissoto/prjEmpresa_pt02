package com.senai.PrjEmpresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depcodigo;
	
	private String depnome;
	
	public Departamento(Long depcodigo, String depnome ) {
		super();
		this.depcodigo = depcodigo;
		this.depnome = depnome;
	}
	
	public Long Getdepcodigo() {
		return depcodigo;
	}
	
	public void setdepcodigo(Long depcodigo) {
		this.depcodigo = depcodigo;
	}

	public String getnome() {
		return depnome;
	}

	public void setdepnome(String depnome) {
		this.depnome = depnome;
	}
				
	}
	

	

