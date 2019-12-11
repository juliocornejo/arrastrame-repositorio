package com.ragnax.arrastramerepositorio.entidad;


import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : EstadoRuedasVehiculo
 * en la base de Datos representa 
 */
@Entity
@Table (name="estado_ruedas_vehiculo")

public class EstadoRuedasVehiculo{
 
	@Id
	@OrderBy
	@Column(name="id_estado_ruedas_vehiculo")
	private Integer idEstadoRuedasVehiculo;
	
	@Column(name="nombre_estado_ruedas_vehiculo")
	private String nombreEstadoRuedasVehiculo;
	
	@Column(name="prioridad_estado_ruedas_vehiculo")
	private Integer prioridadEstadoRuedasVehiculo;
	
	@OneToMany(mappedBy="idEstadoRuedasVehiculo")
	private List<Asistencia> asistencias;
	
	public EstadoRuedasVehiculo() {
		super();
	}

	public EstadoRuedasVehiculo(Integer idEstadoRuedasVehiculo) {
		super();
		this.idEstadoRuedasVehiculo = idEstadoRuedasVehiculo;
	}
	
	public EstadoRuedasVehiculo(String nombreEstadoRuedasVehiculo, Integer prioridadEstadoRuedasVehiculo ) {
		super();
		this.nombreEstadoRuedasVehiculo = nombreEstadoRuedasVehiculo;
		this.prioridadEstadoRuedasVehiculo = prioridadEstadoRuedasVehiculo;
	}

	public Integer getIdEstadoRuedasVehiculo() {
		return idEstadoRuedasVehiculo;
	}

	public void setIdEstadoRuedasVehiculo(Integer idEstadoRuedasVehiculo) {
		this.idEstadoRuedasVehiculo = idEstadoRuedasVehiculo;
	}

	public String getNombreEstadoRuedasVehiculo() {
		return nombreEstadoRuedasVehiculo;
	}

	public void setNombreEstadoRuedasVehiculo(String nombreEstadoRuedasVehiculo) {
		this.nombreEstadoRuedasVehiculo = nombreEstadoRuedasVehiculo;
	}

	public Integer getPrioridadEstadoRuedasVehiculo() {
		return prioridadEstadoRuedasVehiculo;
	}

	public void setPrioridadEstadoRuedasVehiculo(Integer prioridadEstadoRuedasVehiculo) {
		this.prioridadEstadoRuedasVehiculo = prioridadEstadoRuedasVehiculo;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
}
