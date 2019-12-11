package com.ragnax.arrastramerepositorio.entidad;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : EventoAsistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="evento_asistencia")

public class EventoAsistencia{
 
	@Id
	@OrderBy
	@Column(name="id_evento_asistencia")
	private Integer idEventoAsistencia;
	
	@Column(name="codigo_evento_asistencia")
	private String codigoEventoAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_asistencia")
	private Asistencia idAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_disponibilidad_grua_evento")
	private DisponibilidadGruaEvento idDisponibilidadGruaEvento;
	
	@Column(name="fk_id_negocio")
	private String idNegocio;
	
	@Column(name="fecha_inicio_evento_asistencia")
	private Timestamp fechaInicioEventoAsistencia;
	
	@Column(name="fecha_final_evento_asistencia")
	private Timestamp fechaFinalEventoAsistencia;
	
	@OneToMany(mappedBy="idEventoAsistencia")
	private List<StatusEventoAsistencia> status_asistencias;
	
	public EventoAsistencia() {
		super();
	}

	public EventoAsistencia(String codigoEventoAsistencia) {
		super();
		this.codigoEventoAsistencia = codigoEventoAsistencia;
	}
	
	public EventoAsistencia(Asistencia idAsistencia, DisponibilidadGruaEvento idDisponibilidadGruaEvento, String idNegocio) {
		super();
		this.idAsistencia = idAsistencia;
		this.idDisponibilidadGruaEvento = idDisponibilidadGruaEvento;
		this.idNegocio = idNegocio;
	}

	public Integer getIdEventoAsistencia() {
		return idEventoAsistencia;
	}

	public void setIdEventoAsistencia(Integer idEventoAsistencia) {
		this.idEventoAsistencia = idEventoAsistencia;
	}

	public String getCodigoEventoAsistencia() {
		return codigoEventoAsistencia;
	}

	public void setCodigoEventoAsistencia(String codigoEventoAsistencia) {
		this.codigoEventoAsistencia = codigoEventoAsistencia;
	}

	public Asistencia getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Asistencia idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public DisponibilidadGruaEvento getIdDisponibilidadGruaEvento() {
		return idDisponibilidadGruaEvento;
	}

	public void setIdDisponibilidadGruaEvento(DisponibilidadGruaEvento idDisponibilidadGruaEvento) {
		this.idDisponibilidadGruaEvento = idDisponibilidadGruaEvento;
	}

	public String getIdNegocio() {
		return idNegocio;
	}

	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}

	public Timestamp getFechaInicioEventoAsistencia() {
		return fechaInicioEventoAsistencia;
	}

	public void setFechaInicioEventoAsistencia(Timestamp fechaInicioEventoAsistencia) {
		this.fechaInicioEventoAsistencia = fechaInicioEventoAsistencia;
	}

	public Timestamp getFechaFinalEventoAsistencia() {
		return fechaFinalEventoAsistencia;
	}

	public void setFechaFinalEventoAsistencia(Timestamp fechaFinalEventoAsistencia) {
		this.fechaFinalEventoAsistencia = fechaFinalEventoAsistencia;
	}

	public List<StatusEventoAsistencia> getStatus_asistencias() {
		return status_asistencias;
	}

	public void setStatus_asistencias(List<StatusEventoAsistencia> status_asistencias) {
		this.status_asistencias = status_asistencias;
	}
}
