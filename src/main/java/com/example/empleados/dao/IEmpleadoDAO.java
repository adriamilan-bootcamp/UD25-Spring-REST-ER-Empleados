package com.example.empleados.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empleados.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {

}
