package com.ragnax.arrastramerepositorio.entidad;


import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : TipoSuperficieAsistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_superficie_asistencia")

public class TipoSuperficieAsistencia{
 
	@Id
	@OrderBy
	@Column(name="id_tipo_superficie_asistencia")
	private Integer idTipoSuperficieAsistencia;
	
	@Column(name="nombre_tipo_superficie_asistencia")
	private String nombreTipoSuperficieAsistencia;
	
	@Column(name="prioridad_tipo_superficie_asistencia")
	private Integer prioridadTipoSuperficieAsistencia;
	
	@OneToMany(mappedBy="idTipoSuperficieAsistencia")
	private List<Asistencia> asistencias;
	
	public TipoSuperficieAsistencia() {
		super();
	}

	public TipoSuperficieAsistencia(Integer idTipoSuperficieAsistencia) {
		super();
		this.idTipoSuperficieAsistencia = idTipoSuperficieAsistencia;
	}
	
	public TipoSuperficieAsistencia(String nombreTipoSuperficieAsistencia, Integer prioridadTipoSuperficieAsistencia) {
		super();
		this.nombreTipoSuperficieAsistencia = nombreTipoSuperficieAsistencia;
		this.prioridadTipoSuperficieAsistencia = prioridadTipoSuperficieAsistencia;
	}

	public Integer getIdTipoSuperficieAsistencia() {
		return idTipoSuperficieAsistencia;
	}

	public void setIdTipoSuperficieAsistencia(Integer idTipoSuperficieAsistencia) {
		this.idTipoSuperficieAsistencia = idTipoSuperficieAsistencia;
	}

	public String getNombreTipoSuperficieAsistencia() {
		return nombreTipoSuperficieAsistencia;
	}

	public void setNombreTipoSuperficieAsistencia(String nombreTipoSuperficieAsistencia) {
		this.nombreTipoSuperficieAsistencia = nombreTipoSuperficieAsistencia;
	}

	public Integer getPrioridadTipoSuperficieAsistencia() {
		return prioridadTipoSuperficieAsistencia;
	}

	public void setPrioridadTipoSuperficieAsistencia(Integer prioridadTipoSuperficieAsistencia) {
		this.prioridadTipoSuperficieAsistencia = prioridadTipoSuperficieAsistencia;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	
}
