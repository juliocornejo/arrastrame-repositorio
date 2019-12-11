package com.ragnax.arrastramerepositorio.entidad;

import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : ClienteAsistencia
 * en la base de Datos representa 
 */
@Entity
@Table (name="cliente_asistencia")

public class ClienteAsistencia{
	//usuario activo que declara la asistencia
	@Id
	@OrderBy
	@Column(name="id_cliente_asistencia")
	private Integer idClienteAsistencia;
	
	@Column(name="fk_id_usuario")
	private Integer idUsuario;
	
	@Column(name="ubicacion_actual_cliente")
	private String ubicacionActualCliente;
	
	@Column(name="activo_cliente")
	private Boolean activoCliente;
	
	@OneToMany(mappedBy="idClienteAsistencia")
	private List<Asistencia> asistencias;
	
	public ClienteAsistencia() {
		super();
	}

	public ClienteAsistencia(Integer idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}
	
	public ClienteAsistencia(Integer idUsuario, String ubicacionActualCliente, Boolean activoCliente) {
		super();
		this.idUsuario = idUsuario;
		this.ubicacionActualCliente = ubicacionActualCliente;
		this.activoCliente = activoCliente;
	}

	public Integer getIdClienteAsistencia() {
		return idClienteAsistencia;
	}

	public void setIdClienteAsistencia(Integer idClienteAsistencia) {
		this.idClienteAsistencia = idClienteAsistencia;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUbicacionActualCliente() {
		return ubicacionActualCliente;
	}

	public void setUbicacionActualCliente(String ubicacionActualCliente) {
		this.ubicacionActualCliente = ubicacionActualCliente;
	}
	
	public Boolean getActivoCliente() {
		return activoCliente;
	}

	public void setActivoCliente(Boolean activoCliente) {
		this.activoCliente = activoCliente;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
}
