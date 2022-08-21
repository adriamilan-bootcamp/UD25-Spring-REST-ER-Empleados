package com.example.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empleados.dao.IEmpleadoDAO;
import com.example.empleados.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	IEmpleadoDAO empleadoDao;
	
	@Override
	public List<Empleado> listEmpleados() {
		return empleadoDao.findAll();
	}

	@Override
	public Empleado empleadoXID(Long id) {
		return empleadoDao.findById(id).get();
	}

	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	public Empleado editEmpleado(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	public void deleteEmpleado(Long id) {
		empleadoDao.deleteById(id);
	}

}
