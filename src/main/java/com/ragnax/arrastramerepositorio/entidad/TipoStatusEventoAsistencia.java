package com.ragnax.arrastramerepositorio.entidad;


import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : TipoAsistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_status_evento_asistencia")

public class TipoStatusEventoAsistencia{
 
	@Id
	@OrderBy
	@Column(name="id_tipo_evento_status_asistencia")
	private Integer idTipoStatusEventoAsistencia;
	
	@Column(name="nombre_tipo_evento_status_asistencia")
	private String nombreTipoStatusEventoAsistencia;
	
	@OneToMany(mappedBy="idTipoStatusEventoAsistencia")
	private List<StatusEventoAsistencia> status_eventos_asistencias;
	
	public TipoStatusEventoAsistencia() {
		super();
	}

	public TipoStatusEventoAsistencia(Integer idTipoStatusEventoAsistencia) {
		super();
		this.idTipoStatusEventoAsistencia = idTipoStatusEventoAsistencia;
	}
	
	public TipoStatusEventoAsistencia(Integer idTipoStatusEventoAsistencia, String nombreTipoStatusEventoAsistencia) {
		super();
		this.idTipoStatusEventoAsistencia = idTipoStatusEventoAsistencia;
		this.nombreTipoStatusEventoAsistencia = nombreTipoStatusEventoAsistencia;
	}

	public Integer getIdTipoStatusEventoAsistencia() {
		return idTipoStatusEventoAsistencia;
	}

	public void setIdTipoStatusEventoAsistencia(Integer idTipoStatusEventoAsistencia) {
		this.idTipoStatusEventoAsistencia = idTipoStatusEventoAsistencia;
	}

	public String getNombreTipoStatusEventoAsistencia() {
		return nombreTipoStatusEventoAsistencia;
	}

	public void setNombreTipoStatusEventoAsistencia(String nombreTipoStatusEventoAsistencia) {
		this.nombreTipoStatusEventoAsistencia = nombreTipoStatusEventoAsistencia;
	}

	public List<StatusEventoAsistencia> getStatus_eventos_asistencias() {
		return status_eventos_asistencias;
	}

	public void setStatus_eventos_asistencias(List<StatusEventoAsistencia> status_eventos_asistencias) {
		this.status_eventos_asistencias = status_eventos_asistencias;
	}
	
}
