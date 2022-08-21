package com.example.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empleados.dao.IDepartamentoDAO;
import com.example.empleados.dto.Departamento;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

	@Autowired
	IDepartamentoDAO departamentoDao;
	
	@Override
	public List<Departamento> listDepartamentos() {
		return departamentoDao.findAll();
	}

	@Override
	public Departamento departamentoXID(Long id) {
		return departamentoDao.findById(id).get();
	}

	@Override
	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoDao.save(departamento);
	}

	@Override
	public Departamento editDepartamento(Departamento departamento) {
		return departamentoDao.save(departamento);
	}

	@Override
	public void deleteDepartamento(Long id) {
		departamentoDao.deleteById(id);
	}

}
