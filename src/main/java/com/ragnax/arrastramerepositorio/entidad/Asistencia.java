package com.ragnax.arrastramerepositorio.entidad;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : Asistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="asistencia")

public class Asistencia{
	//declaracion de la asistencia por parte del usuario
	@Id
	@OrderBy
	@Column(name="id_asistencia")
	private Integer idAsistencia;
	
	@Column(name="codigo_asistencia")
	private String codigoAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_asistencia")
	private TipoAsistencia idTipoAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_superficie_asistencia")
	private TipoSuperficieAsistencia idTipoSuperficieAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_vehiculo_asistencia")
	private TipoVehiculoAsistencia idTipoVehiculoAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_cliente_asistencia")
	private ClienteAsistencia idClienteAsistencia;
	
	@ManyToOne
	@JoinColumn(name="fk_id_estado_ruedas_vehiculo")
	private EstadoRuedasVehiculo idEstadoRuedasVehiculo;
	
	@Column(name="fecha_registro_asistencia")
	private Timestamp fechaRegistroAsistencia;
	
	@Column(name="ubicacion_asistencia")
	private String ubicacionAsistencia;
	
	@OneToMany(mappedBy="idAsistencia")
	private List<EventoAsistencia> eventos_asistencias;

	public Asistencia() {
		super();
	}
	
	public Asistencia(String codigoAsistencia, TipoAsistencia idTipoAsistencia) {
		super();
		this.codigoAsistencia = codigoAsistencia;
		this.idTipoAsistencia = idTipoAsistencia;
	}
	
	
	
	public Asistencia(TipoAsistencia idTipoAsistencia, TipoSuperficieAsistencia idTipoSuperficieAsistencia,
			TipoVehiculoAsistencia idTipoVehiculoAsistencia, ClienteAsistencia idClienteAsistencia,
			EstadoRuedasVehiculo idEstadoRuedasVehiculo, String ubicacionAsistencia) {
		super();
		this.idTipoAsistencia = idTipoAsistencia;
		this.idTipoSuperficieAsistencia = idTipoSuperficieAsistencia;
		this.idTipoVehiculoAsistencia = idTipoVehiculoAsistencia;
		this.idClienteAsistencia = idClienteAsistencia;
		this.idEstadoRuedasVehiculo = idEstadoRuedasVehiculo;
		this.ubicacionAsistencia = ubicacionAsistencia;
	}

	public Asistencia(TipoAsistencia idTipoAsistencia) {
		super();
		this.idTipoAsistencia = idTipoAsistencia;
	}

	public Integer getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public String getCodigoAsistencia() {
		return codigoAsistencia;
	}

	public void setCodigoAsistencia(String codigoAsistencia) {
		this.codigoAsistencia = codigoAsistencia;
	}

	public TipoAsistencia getIdTipoAsistencia() {
		return idTipoAsistencia;
	}

	public void setIdTipoAsistencia(TipoAsistencia idTipoAsistencia) {
		this.idTipoAsistencia = idTipoAsistencia;
	}

	public TipoSuperficieAsistencia getIdTipoSuperficieAsistencia() {
		return idTipoSuperficieAsistencia;
	}

	public void setIdTipoSuperficieAsistencia(TipoSuperficieAsistencia idTipoSuperficieAsistencia) {
		this.idTipoSuperficieAsistencia = idTipoSuperficieAsistencia;
	}

	public TipoVehiculoAsistencia getIdTipoVehiculoAsistencia() {
		return idTipoVehiculoAsistencia;
	}

	public void setIdTipoVehiculoAsistencia(TipoVehiculoAsistencia idTipoVehiculoAsistencia) {
		this.idTipoVehiculoAsistencia = idTipoVehiculoAsistencia;
	}

	public ClienteAsistencia getIdClienteAsistencia() {
		return idClienteAsistencia;
	}

	public void setIdClienteAsistencia(ClienteAsistencia idClienteAsistencia) {
		this.idClienteAsistencia = idClienteAsistencia;
	}

	public EstadoRuedasVehiculo getIdEstadoRuedasVehiculo() {
		return idEstadoRuedasVehiculo;
	}

	public void setIdEstadoRuedasVehiculo(EstadoRuedasVehiculo idEstadoRuedasVehiculo) {
		this.idEstadoRuedasVehiculo = idEstadoRuedasVehiculo;
	}

	public Timestamp getFechaRegistroAsistencia() {
		return fechaRegistroAsistencia;
	}

	public void setFechaRegistroAsistencia(Timestamp fechaRegistroAsistencia) {
		this.fechaRegistroAsistencia = fechaRegistroAsistencia;
	}

	public String getUbicacionAsistencia() {
		return ubicacionAsistencia;
	}

	public void setUbicacionAsistencia(String ubicacionAsistencia) {
		this.ubicacionAsistencia = ubicacionAsistencia;
	}

	public List<EventoAsistencia> getEventos_asistencias() {
		return eventos_asistencias;
	}

	public void setEventos_asistencias(List<EventoAsistencia> eventos_asistencias) {
		this.eventos_asistencias = eventos_asistencias;
	}
	
}
