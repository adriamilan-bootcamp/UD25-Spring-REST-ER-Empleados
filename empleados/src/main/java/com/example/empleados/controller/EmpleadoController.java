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

import com.example.empleados.dto.Empleado;
import com.example.empleados.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoService;
	
	@GetMapping("/empleados")
	public List<Empleado> listEmpleados() {
		return empleadoService.listEmpleados();
	}
	
	@GetMapping("/empleado/{id}")
	public Empleado empleadoXID(@PathVariable(name="id") Long id) {
		return empleadoService.empleadoXID(id);
	}
	
	@PostMapping("/empleado")
	public Empleado saveEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.saveEmpleado(empleado);
	}
	
	@PutMapping("/empleado/{id}")
	public Empleado editEmpleado(@PathVariable(name="id") Long id, @RequestBody Empleado empleado) {
		Empleado empleadoSelected = new Empleado();
		Empleado empleadoUpdated = new Empleado();
		
		empleadoSelected = empleadoService.empleadoXID(id);
		empleadoSelected.setNombre(empleado.getNombre());
		empleadoSelected.setApellidos(empleado.getApellidos());
		empleadoSelected.setDNI(empleado.getDNI());
		empleadoSelected.setDepartamento(empleado.getDepartamento());
		
		empleadoUpdated = empleadoService.saveEmpleado(empleadoSelected);
		
		return empleadoUpdated;
	}
	
	@DeleteMapping("/empleado/{id}")
	public void deleteEmpleado(@PathVariable(name="id") Long id) {
		empleadoService.deleteEmpleado(id);
	}
	
}
