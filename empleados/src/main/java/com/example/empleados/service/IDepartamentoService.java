package com.example.empleados.service;

import java.util.List;

import com.example.empleados.dto.Departamento;

public interface IDepartamentoService {
	
	public List<Departamento> listDepartamentos();

	public Departamento departamentoXID(Long id);
	
	public Departamento saveDepartamento(Departamento departamento);
	
	public Departamento editDepartamento(Departamento departamento);
	
	public void deleteDepartamento(Long id);
	
}
