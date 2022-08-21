package com.example.empleados.service;

import java.util.List;

import com.example.empleados.dto.Empleado;

public interface IEmpleadoService {

	public List<Empleado> listEmpleados();
	
	public Empleado empleadoXID(Long id);
	
	public Empleado saveEmpleado(Empleado empleado);
	
	public Empleado editEmpleado(Empleado empleado);
	
	public void deleteEmpleado(Long id);
	
}
