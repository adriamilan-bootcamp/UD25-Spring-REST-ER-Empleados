package com.example.empleados.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="presupuesto")
	private Double presupuesto;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<Empleado> empleados;

	//Constructor por defecto
	public Departamento() {
		
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param presupuesto
	 */
	public Departamento(Long id, String nombre, Double presupuesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the presupuesto
	 */
	public Double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleado")
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> empleado) {
		this.empleados = empleado;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + "]";
	}
	
}
