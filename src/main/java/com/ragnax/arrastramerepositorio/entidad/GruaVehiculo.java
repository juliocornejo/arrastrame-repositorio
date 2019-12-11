package com.ragnax.arrastramerepositorio.entidad;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for : GruaVehiculo
 * en la base de Datos representa 
 */
@Entity
@Table (name="grua_vehiculo")

public class GruaVehiculo{
 
	@Id
	@OrderBy
	@Column(name="id_grua_vehiculo")
	private Integer idGruaVehiculo;
	
	@Column(name="codigo_grua_vehiculo")
	private String codigoGruaVehiculo;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_grua_vehiculo")
	private TipoGruaVehiculo idTipoGruaVehiculo;
	
	@Column(name="fk_id_usuario_grua_vehiculo")
	private Integer idUsuarioGruaVehiculo;
	
	@Column(name="fk_id_pais_portal_grua")
	private String codigoPaisPortal;
	
	@Column(name="anho_grua_vehiculo")
	private Integer anhoGruaVehiculo;
	
	@Column(name="precio_base", precision=7, scale=2)
	private BigDecimal precioBase;
	
	@Column(name="precio_kilometro_grua", precision=7, scale=2)
	private BigDecimal precioKilometroGrua;
	
	@Column(name="patente_grua_vehiculo")
	private String patenteGruaVehiculo;
	
	@Column(name="estado_grua_vehiculo")
	private Boolean estadoGruaVehiculo;
	
	@OneToMany(mappedBy="idGruaVehiculo")
	private List<DisponibilidadGruaEvento> disponibilidades_gruas_evento;
	
	public GruaVehiculo() {
		super();
	}
	
	public GruaVehiculo(String codigoGruaVehiculo) {
		super();
		this.codigoGruaVehiculo = codigoGruaVehiculo;
	}
	
	public GruaVehiculo(String codigoPaisPortal, Boolean estadoGruaVehiculo) {
		super();
		this.codigoPaisPortal = codigoPaisPortal;
		this.estadoGruaVehiculo = estadoGruaVehiculo;
	}
	
	public GruaVehiculo(String codigoPaisPortal, Boolean estadoGruaVehiculo, TipoGruaVehiculo idTipoGruaVehiculo) {
		super();
		this.codigoPaisPortal = codigoPaisPortal;
		this.estadoGruaVehiculo = estadoGruaVehiculo;
		this.idTipoGruaVehiculo = idTipoGruaVehiculo;
	}
	
	public GruaVehiculo(TipoGruaVehiculo idTipoGruaVehiculo, Integer idUsuarioGruaVehiculo, String codigoPaisPortal,
			Integer anhoGruaVehiculo, BigDecimal precioBase, BigDecimal precioKilometroGrua,
			String patenteGruaVehiculo) {
		super();
		this.idTipoGruaVehiculo = idTipoGruaVehiculo;
		this.idUsuarioGruaVehiculo = idUsuarioGruaVehiculo;
		this.codigoPaisPortal = codigoPaisPortal;
		this.anhoGruaVehiculo = anhoGruaVehiculo;
		this.precioBase = precioBase;
		this.precioKilometroGrua = precioKilometroGrua;
		this.patenteGruaVehiculo = patenteGruaVehiculo;
	}

	public Integer getIdGruaVehiculo() {
		return idGruaVehiculo;
	}

	public void setIdGruaVehiculo(Integer idGruaVehiculo) {
		this.idGruaVehiculo = idGruaVehiculo;
	}

	public String getCodigoGruaVehiculo() {
		return codigoGruaVehiculo;
	}

	public void setCodigoGruaVehiculo(String codigoGruaVehiculo) {
		this.codigoGruaVehiculo = codigoGruaVehiculo;
	}

	public TipoGruaVehiculo getIdTipoGruaVehiculo() {
		return idTipoGruaVehiculo;
	}

	public void setIdTipoGruaVehiculo(TipoGruaVehiculo idTipoGruaVehiculo) {
		this.idTipoGruaVehiculo = idTipoGruaVehiculo;
	}

	public Integer getIdUsuarioGruaVehiculo() {
		return idUsuarioGruaVehiculo;
	}

	public void setIdUsuarioGruaVehiculo(Integer idUsuarioGruaVehiculo) {
		this.idUsuarioGruaVehiculo = idUsuarioGruaVehiculo;
	}
	
	public String getCodigoPaisPortal() {
		return codigoPaisPortal;
	}

	public void setCodigoPaisPortal(String codigoPaisPortal) {
		this.codigoPaisPortal = codigoPaisPortal;
	}

	public Integer getAnhoGruaVehiculo() {
		return anhoGruaVehiculo;
	}

	public void setAnhoGruaVehiculo(Integer anhoGruaVehiculo) {
		this.anhoGruaVehiculo = anhoGruaVehiculo;
	}

	public BigDecimal getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}

	public BigDecimal getPrecioKilometroGrua() {
		return precioKilometroGrua;
	}

	public void setPrecioKilometroGrua(BigDecimal precioKilometroGrua) {
		this.precioKilometroGrua = precioKilometroGrua;
	}

	public String getPatenteGruaVehiculo() {
		return patenteGruaVehiculo;
	}

	public void setPatenteGruaVehiculo(String patenteGruaVehiculo) {
		this.patenteGruaVehiculo = patenteGruaVehiculo;
	}

	public Boolean getEstadoGruaVehiculo() {
		return estadoGruaVehiculo;
	}

	public void setEstadoGruaVehiculo(Boolean estadoGruaVehiculo) {
		this.estadoGruaVehiculo = estadoGruaVehiculo;
	}

	public List<DisponibilidadGruaEvento> getDisponibilidades_gruas_evento() {
		return disponibilidades_gruas_evento;
	}

	public void setDisponibilidades_gruas_evento(List<DisponibilidadGruaEvento> disponibilidades_gruas_evento) {
		this.disponibilidades_gruas_evento = disponibilidades_gruas_evento;
	}
	
}
