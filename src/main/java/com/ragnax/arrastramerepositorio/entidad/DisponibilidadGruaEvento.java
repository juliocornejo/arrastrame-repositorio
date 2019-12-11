package com.ragnax.arrastramerepositorio.entidad;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : DisponibilidadGruaEvento
 * en la base de Datos representa 
 */
@Entity
@Table (name="disponibilidad_grua_evento")

public class DisponibilidadGruaEvento{
	//Es necesario que la grua se declare activo para poder recibir solicitudes de grua
	@Id
	@OrderBy
	@Column(name="id_disponibilidad_grua_evento")
	private Integer idDisponibilidadGruaEvento;
	
	@ManyToOne
	@JoinColumn(name="fk_id_grua")
	private GruaVehiculo idGruaVehiculo;
	
	@Column(name="estado_disponibilidad_grua_evento")
	private Boolean estadoDisponibilidadGruaEvento;
	
	@Column(name="ubicacion_disponibilidad_grua_evento")
	private String ubicacionDisponibilidadGruaEvento;
	
	@Column(name="fecha_inicio_disponibilidad_grua_evento")
	private Timestamp fechaInicioDisponibilidadGruaEvento;
	
	@Column(name="fecha_fin_disponibilidad_grua_evento")
	private Timestamp fechaFinDisponibilidadGruaEvento;
	
	@OneToMany(mappedBy="idDisponibilidadGruaEvento")
	private List<EventoAsistencia> eventos_asistencias;
	
	public DisponibilidadGruaEvento() {
		super();
	}

	public DisponibilidadGruaEvento(GruaVehiculo idGruaVehiculo) {
		super();
		this.idGruaVehiculo = idGruaVehiculo;
	}
	
	public DisponibilidadGruaEvento(GruaVehiculo idGruaVehiculo, String ubicacionDisponibilidadGruaEvento) {
		super();
		this.idGruaVehiculo = idGruaVehiculo;
		this.ubicacionDisponibilidadGruaEvento = ubicacionDisponibilidadGruaEvento;
	}

	public Integer getIdDisponibilidadGruaEvento() {
		return idDisponibilidadGruaEvento;
	}

	public void setIdDisponibilidadGruaEvento(Integer idDisponibilidadGruaEvento) {
		this.idDisponibilidadGruaEvento = idDisponibilidadGruaEvento;
	}

	public GruaVehiculo getIdGruaVehiculo() {
		return idGruaVehiculo;
	}

	public void setIdGruaVehiculo(GruaVehiculo idGruaVehiculo) {
		this.idGruaVehiculo = idGruaVehiculo;
	}

	public Boolean getEstadoDisponibilidadGruaEvento() {
		return estadoDisponibilidadGruaEvento;
	}

	public void setEstadoDisponibilidadGruaEvento(Boolean estadoDisponibilidadGruaEvento) {
		this.estadoDisponibilidadGruaEvento = estadoDisponibilidadGruaEvento;
	}

	public String getUbicacionDisponibilidadGruaEvento() {
		return ubicacionDisponibilidadGruaEvento;
	}

	public void setUbicacionDisponibilidadGruaEvento(String ubicacionDisponibilidadGruaEvento) {
		this.ubicacionDisponibilidadGruaEvento = ubicacionDisponibilidadGruaEvento;
	}

	public Timestamp getFechaInicioDisponibilidadGruaEvento() {
		return fechaInicioDisponibilidadGruaEvento;
	}

	public void setFechaInicioDisponibilidadGruaEvento(Timestamp fechaInicioDisponibilidadGruaEvento) {
		this.fechaInicioDisponibilidadGruaEvento = fechaInicioDisponibilidadGruaEvento;
	}

	public Timestamp getFechaFinDisponibilidadGruaEvento() {
		return fechaFinDisponibilidadGruaEvento;
	}

	public void setFechaFinDisponibilidadGruaEvento(Timestamp fechaFinDisponibilidadGruaEvento) {
		this.fechaFinDisponibilidadGruaEvento = fechaFinDisponibilidadGruaEvento;
	}

	public List<EventoAsistencia> getEventos_asistencias() {
		return eventos_asistencias;
	}

	public void setEventos_asistencias(List<EventoAsistencia> eventos_asistencias) {
		this.eventos_asistencias = eventos_asistencias;
	}
	
}
