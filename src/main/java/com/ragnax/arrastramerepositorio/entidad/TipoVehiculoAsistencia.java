package com.ragnax.arrastramerepositorio.entidad;


import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : TipoVehiculoAsistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_vehiculo_asistencia")

public class TipoVehiculoAsistencia{
	//Tipo de vehiculo que declara la asistencia
	@Id
	@OrderBy
	@Column(name="id_tipo_vehiculo_asistencia")
	private Integer idTipoVehiculoAsistencia;
	
	@Column(name="nombre_tipo_vehiculo_asistencia")
	private String nombreTipoVehiculoAsistencia;
	
	@Column(name="prioridad_tipo_vehiculo_asistencia")
	private Integer prioridadTipoVehiculoAsistencia;
	
	@OneToMany(mappedBy="idTipoVehiculoAsistencia")
	private List<Asistencia> asistencias;
	
	public TipoVehiculoAsistencia() {
		super();
	}

	public TipoVehiculoAsistencia(Integer idTipoVehiculoAsistencia) {
		super();
		this.idTipoVehiculoAsistencia = idTipoVehiculoAsistencia;
	}
	
	public TipoVehiculoAsistencia(String nombreTipoVehiculoAsistencia,
			Integer prioridadTipoVehiculoAsistencia) {
		super();
		this.nombreTipoVehiculoAsistencia = nombreTipoVehiculoAsistencia;
		this.prioridadTipoVehiculoAsistencia = prioridadTipoVehiculoAsistencia;
	}

	public Integer getIdTipoVehiculoAsistencia() {
		return idTipoVehiculoAsistencia;
	}

	public void setIdTipoVehiculoAsistencia(Integer idTipoVehiculoAsistencia) {
		this.idTipoVehiculoAsistencia = idTipoVehiculoAsistencia;
	}

	public String getNombreTipoVehiculoAsistencia() {
		return nombreTipoVehiculoAsistencia;
	}

	public void setNombreTipoVehiculoAsistencia(String nombreTipoVehiculoAsistencia) {
		this.nombreTipoVehiculoAsistencia = nombreTipoVehiculoAsistencia;
	}

	public Integer getPrioridadTipoVehiculoAsistencia() {
		return prioridadTipoVehiculoAsistencia;
	}

	public void setPrioridadTipoVehiculoAsistencia(Integer prioridadTipoVehiculoAsistencia) {
		this.prioridadTipoVehiculoAsistencia = prioridadTipoVehiculoAsistencia;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
}
