package com.ragnax.arrastramerepositorio.entidad;


import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : TipoAsistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_asistencia")

public class TipoAsistencia{
 
	@Id
	@OrderBy
	@Column(name="id_tipo_asistencia")
	private Integer idTipoAsistencia;
	
	@Column(name="nombre_tipo_asistencia")
	private String nombreTipoAsistencia;
	
	@Column(name="prioridad_tipo_asistencia")
	private Integer prioridadTipoAsistencia;
	
	@OneToMany(mappedBy="idTipoAsistencia")
	private List<Asistencia> asistencias;
	
	public TipoAsistencia() {
		super();
	}

	public TipoAsistencia(Integer idTipoAsistencia) {
		super();
		this.idTipoAsistencia = idTipoAsistencia;
	}
	
	
	public TipoAsistencia(String nombreTipoAsistencia, Integer prioridadTipoAsistencia) {
		super();
		this.nombreTipoAsistencia= nombreTipoAsistencia;
		this.prioridadTipoAsistencia = prioridadTipoAsistencia;
	}

	public Integer getIdTipoAsistencia() {
		return idTipoAsistencia;
	}

	public void setIdTipoAsistencia(Integer idTipoAsistencia) {
		this.idTipoAsistencia = idTipoAsistencia;
	}

	public String getNombreTipoAsistencia() {
		return nombreTipoAsistencia;
	}

	public void setNombreTipoAsistencia(String nombreTipoAsistencia) {
		this.nombreTipoAsistencia = nombreTipoAsistencia;
	}
}
