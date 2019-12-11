package com.ragnax.arrastramerepositorio.entidad;


import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : TipoGruaVehiculo
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_grua_vehiculo")

public class TipoGruaVehiculo{
 
	@Id
	@OrderBy
	@Column(name="id_tipo_grua_vehiculo")
	private Integer idTipoGruaVehiculo;
	
	@Column(name="nombre_tipo_grua_vehiculo")
	private String nombreTipoGruaVehiculo;
	
	@Column(name="prioridad_tipo_grua_vehiculo")
	private Integer prioridadTipoGruaVehiculo;
	
	@OneToMany(mappedBy="idTipoGruaVehiculo")
	private List<GruaVehiculo> gruas_vehiculos;
	
	public TipoGruaVehiculo() {
		super();
	}

	public TipoGruaVehiculo(Integer idTipoGruaVehiculo) {
		super();
		this.idTipoGruaVehiculo = idTipoGruaVehiculo;
	}
	
	public TipoGruaVehiculo(String nombreTipoGruaVehiculo, Integer prioridadTipoGruaVehiculo) {
		super();
		this.nombreTipoGruaVehiculo = nombreTipoGruaVehiculo;
		this.prioridadTipoGruaVehiculo = prioridadTipoGruaVehiculo;
	}

	public Integer getIdTipoGruaVehiculo() {
		return idTipoGruaVehiculo;
	}

	public void setIdTipoGruaVehiculo(Integer idTipoGruaVehiculo) {
		this.idTipoGruaVehiculo = idTipoGruaVehiculo;
	}

	public String getNombreTipoGruaVehiculo() {
		return nombreTipoGruaVehiculo;
	}

	public void setNombreTipoGruaVehiculo(String nombreTipoGruaVehiculo) {
		this.nombreTipoGruaVehiculo = nombreTipoGruaVehiculo;
	}

	public Integer getPrioridadTipoGruaVehiculo() {
		return prioridadTipoGruaVehiculo;
	}

	public void setPrioridadTipoGruaVehiculo(Integer prioridadTipoGruaVehiculo) {
		this.prioridadTipoGruaVehiculo = prioridadTipoGruaVehiculo;
	}

	public List<GruaVehiculo> getGruas_vehiculos() {
		return gruas_vehiculos;
	}

	public void setGruas_vehiculos(List<GruaVehiculo> gruas_vehiculos) {
		this.gruas_vehiculos = gruas_vehiculos;
	}
	
}
