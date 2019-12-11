package com.ragnax.arrastramerepositorio.entidad;

import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EventoAsistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="status_evento_asistencia")

public class StatusEventoAsistencia{
 
	@Id
	@OrderBy
	@Column(name="id_status_evento_asistencia")
	private Integer idStatusEventoAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_status_evento_asistencia")
	private TipoStatusEventoAsistencia idTipoStatusEventoAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_evento_asistencia")
	private EventoAsistencia idEventoAsistencia;
	
	
	@Column(name="fecha_status_evento_asistencia")
	private Timestamp fechaStatusEventoAsistencia;
	
//	@Column(name="fecha_final_evento_status_evento_asistencia")
//	private Timestamp fechaFinalEventoStatusEventoAsistencia;
	
	public StatusEventoAsistencia() {
		super();
	}
	
	public StatusEventoAsistencia(Timestamp fechaStatusEventoAsistencia, EventoAsistencia idEventoAsistencia) {
		super();
		this.idEventoAsistencia = idEventoAsistencia;
		this.fechaStatusEventoAsistencia = fechaStatusEventoAsistencia;
	}

	public Integer getIdStatusEventoAsistencia() {
		return idStatusEventoAsistencia;
	}

	public void setIdStatusEventoAsistencia(Integer idStatusEventoAsistencia) {
		this.idStatusEventoAsistencia = idStatusEventoAsistencia;
	}

	public TipoStatusEventoAsistencia getIdTipoStatusEventoAsistencia() {
		return idTipoStatusEventoAsistencia;
	}

	public void setIdTipoStatusEventoAsistencia(TipoStatusEventoAsistencia idTipoStatusEventoAsistencia) {
		this.idTipoStatusEventoAsistencia = idTipoStatusEventoAsistencia;
	}

	public EventoAsistencia getIdEventoAsistencia() {
		return idEventoAsistencia;
	}

	public void setIdEventoAsistencia(EventoAsistencia idEventoAsistencia) {
		this.idEventoAsistencia = idEventoAsistencia;
	}

	public Timestamp getFechaStatusEventoAsistencia() {
		return fechaStatusEventoAsistencia;
	}

	public void setFechaStatusEventoAsistencia(Timestamp fechaStatusEventoAsistencia) {
		this.fechaStatusEventoAsistencia = fechaStatusEventoAsistencia;
	}

}
