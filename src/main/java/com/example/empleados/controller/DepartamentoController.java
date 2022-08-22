package com.example.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empleados.dto.Departamento;
import com.example.empleados.service.DepartamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl departamentoService;
	
	@GetMapping("/departamentos")
	public List<Departamento> listDepartamentos() {
		return departamentoService.listDepartamentos();
	}
	
	@GetMapping("/departamento/{id}")
	public Departamento departamentoXID(@PathVariable(name="id") Long id) {
		return departamentoService.departamentoXID(id);
	}
	
	@PostMapping("/departamento")
	public Departamento saveDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	
	@PutMapping("/departamento/{id}")
	public Departamento editDepartamento(@PathVariable(name="id") Long id, @RequestBody Departamento departamento) {
		Departamento departamentoSelected = new Departamento();
		Departamento departamentoUpdated = new Departamento();
		
		departamentoSelected = departamentoService.departamentoXID(id);
		departamentoSelected.setNombre(departamento.getNombre());
		departamentoSelected.setPresupuesto(departamento.getPresupuesto());
		
		departamentoUpdated = departamentoService.editDepartamento(departamentoSelected);
		
		return departamentoUpdated;
	}
	
	@DeleteMapping("/departamento/{id}")
	public void deleteDepartamento(@PathVariable(name="id") Long id) {
		departamentoService.deleteDepartamento(id);
	}

}
