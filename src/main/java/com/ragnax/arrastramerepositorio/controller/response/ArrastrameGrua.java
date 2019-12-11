package com.ragnax.arrastramerepositorio.controller.response;

import java.io.Serializable;
import java.util.List;

import com.ragnax.arrastramerepositorio.entidad.*;

public class ArrastrameGrua implements Serializable{

	private static final long serialVersionUID = -4301293450469130528L;
	
	private TipoAsistencia tipoAsistencia;
	private TipoGruaVehiculo tipoGruaVehiculo;
	private TipoStatusEventoAsistencia tipoStatusEventoAsistencia;
	private TipoSuperficieAsistencia tipoSuperficieAsistencia;
	private TipoVehiculoAsistencia tipoVehiculoAsistencia;
	private EstadoRuedasVehiculo estadoRuedasVehiculo;
	private ClienteAsistencia clienteAsistencia;
	private GruaVehiculo gruaVehiculo;
	private Asistencia asistencia;
	private DisponibilidadGruaEvento disponibilidadGruaEvento;
	private EventoAsistencia eventoAsistencia;
	private StatusEventoAsistencia statusEventoAsistencia;
	
	private List<TipoAsistencia> listaTipoAsistencia;
	private List<TipoGruaVehiculo> listaTipoGruaVehiculo;
	private List<TipoStatusEventoAsistencia> listaTipoStatusEventoAsistencia;
	private List<TipoSuperficieAsistencia> listaTipoSuperficieAsistencia;
	private List<TipoVehiculoAsistencia> listaTipoVehiculoAsistencia;
	private List<EstadoRuedasVehiculo> listaEstadoRuedasVehiculo;
	private List<ClienteAsistencia> listaClienteAsistencia;
	private List<GruaVehiculo> listaGruaVehiculo;
	private List<Asistencia> listaAsistencia;
	private List<DisponibilidadGruaEvento> listaDisponibilidadGruaEvento;
	private List<EventoAsistencia> listaEventoAsistencia;
	private List<StatusEventoAsistencia> listaStatusEventoAsistencia;
	
	public ArrastrameGrua() {
		super();
	}

	public TipoAsistencia getTipoAsistencia() {
		return tipoAsistencia;
	}

	public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	public TipoGruaVehiculo getTipoGruaVehiculo() {
		return tipoGruaVehiculo;
	}

	public void setTipoGruaVehiculo(TipoGruaVehiculo tipoGruaVehiculo) {
		this.tipoGruaVehiculo = tipoGruaVehiculo;
	}

	public TipoStatusEventoAsistencia getTipoStatusEventoAsistencia() {
		return tipoStatusEventoAsistencia;
	}

	public void setTipoStatusEventoAsistencia(TipoStatusEventoAsistencia tipoStatusEventoAsistencia) {
		this.tipoStatusEventoAsistencia = tipoStatusEventoAsistencia;
	}

	public TipoSuperficieAsistencia getTipoSuperficieAsistencia() {
		return tipoSuperficieAsistencia;
	}

	public void setTipoSuperficieAsistencia(TipoSuperficieAsistencia tipoSuperficieAsistencia) {
		this.tipoSuperficieAsistencia = tipoSuperficieAsistencia;
	}

	public TipoVehiculoAsistencia getTipoVehiculoAsistencia() {
		return tipoVehiculoAsistencia;
	}

	public void setTipoVehiculoAsistencia(TipoVehiculoAsistencia tipoVehiculoAsistencia) {
		this.tipoVehiculoAsistencia = tipoVehiculoAsistencia;
	}

	public EstadoRuedasVehiculo getEstadoRuedasVehiculo() {
		return estadoRuedasVehiculo;
	}

	public void setEstadoRuedasVehiculo(EstadoRuedasVehiculo estadoRuedasVehiculo) {
		this.estadoRuedasVehiculo = estadoRuedasVehiculo;
	}

	public ClienteAsistencia getClienteAsistencia() {
		return clienteAsistencia;
	}

	public void setClienteAsistencia(ClienteAsistencia clienteAsistencia) {
		this.clienteAsistencia = clienteAsistencia;
	}

	public GruaVehiculo getGruaVehiculo() {
		return gruaVehiculo;
	}

	public void setGruaVehiculo(GruaVehiculo gruaVehiculo) {
		this.gruaVehiculo = gruaVehiculo;
	}

	public Asistencia getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}

	public DisponibilidadGruaEvento getDisponibilidadGruaEvento() {
		return disponibilidadGruaEvento;
	}

	public void setDisponibilidadGruaEvento(DisponibilidadGruaEvento disponibilidadGruaEvento) {
		this.disponibilidadGruaEvento = disponibilidadGruaEvento;
	}

	public EventoAsistencia getEventoAsistencia() {
		return eventoAsistencia;
	}

	public void setEventoAsistencia(EventoAsistencia eventoAsistencia) {
		this.eventoAsistencia = eventoAsistencia;
	}

	public StatusEventoAsistencia getStatusEventoAsistencia() {
		return statusEventoAsistencia;
	}

	public void setStatusEventoAsistencia(StatusEventoAsistencia statusEventoAsistencia) {
		this.statusEventoAsistencia = statusEventoAsistencia;
	}

	public List<TipoAsistencia> getListaTipoAsistencia() {
		return listaTipoAsistencia;
	}

	public void setListaTipoAsistencia(List<TipoAsistencia> listaTipoAsistencia) {
		this.listaTipoAsistencia = listaTipoAsistencia;
	}

	public List<TipoGruaVehiculo> getListaTipoGruaVehiculo() {
		return listaTipoGruaVehiculo;
	}

	public void setListaTipoGruaVehiculo(List<TipoGruaVehiculo> listaTipoGruaVehiculo) {
		this.listaTipoGruaVehiculo = listaTipoGruaVehiculo;
	}

	public List<TipoStatusEventoAsistencia> getListaTipoStatusEventoAsistencia() {
		return listaTipoStatusEventoAsistencia;
	}

	public void setListaTipoStatusEventoAsistencia(List<TipoStatusEventoAsistencia> listaTipoStatusEventoAsistencia) {
		this.listaTipoStatusEventoAsistencia = listaTipoStatusEventoAsistencia;
	}

	public List<TipoSuperficieAsistencia> getListaTipoSuperficieAsistencia() {
		return listaTipoSuperficieAsistencia;
	}

	public void setListaTipoSuperficieAsistencia(List<TipoSuperficieAsistencia> listaTipoSuperficieAsistencia) {
		this.listaTipoSuperficieAsistencia = listaTipoSuperficieAsistencia;
	}

	public List<TipoVehiculoAsistencia> getListaTipoVehiculoAsistencia() {
		return listaTipoVehiculoAsistencia;
	}

	public void setListaTipoVehiculoAsistencia(List<TipoVehiculoAsistencia> listaTipoVehiculoAsistencia) {
		this.listaTipoVehiculoAsistencia = listaTipoVehiculoAsistencia;
	}

	public List<EstadoRuedasVehiculo> getListaEstadoRuedasVehiculo() {
		return listaEstadoRuedasVehiculo;
	}

	public void setListaEstadoRuedasVehiculo(List<EstadoRuedasVehiculo> listaEstadoRuedasVehiculo) {
		this.listaEstadoRuedasVehiculo = listaEstadoRuedasVehiculo;
	}

	public List<ClienteAsistencia> getListaClienteAsistencia() {
		return listaClienteAsistencia;
	}

	public void setListaClienteAsistencia(List<ClienteAsistencia> listaClienteAsistencia) {
		this.listaClienteAsistencia = listaClienteAsistencia;
	}

	public List<GruaVehiculo> getListaGruaVehiculo() {
		return listaGruaVehiculo;
	}

	public void setListaGruaVehiculo(List<GruaVehiculo> listaGruaVehiculo) {
		this.listaGruaVehiculo = listaGruaVehiculo;
	}

	public List<Asistencia> getListaAsistencia() {
		return listaAsistencia;
	}

	public void setListaAsistencia(List<Asistencia> listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}

	public List<DisponibilidadGruaEvento> getListaDisponibilidadGruaEvento() {
		return listaDisponibilidadGruaEvento;
	}

	public void setListaDisponibilidadGruaEvento(List<DisponibilidadGruaEvento> listaDisponibilidadGruaEvento) {
		this.listaDisponibilidadGruaEvento = listaDisponibilidadGruaEvento;
	}

	public List<EventoAsistencia> getListaEventoAsistencia() {
		return listaEventoAsistencia;
	}

	public void setListaEventoAsistencia(List<EventoAsistencia> listaEventoAsistencia) {
		this.listaEventoAsistencia = listaEventoAsistencia;
	}

	public List<StatusEventoAsistencia> getListaStatusEventoAsistencia() {
		return listaStatusEventoAsistencia;
	}

	public void setListaStatusEventoAsistencia(List<StatusEventoAsistencia> listaStatusEventoAsistencia) {
		this.listaStatusEventoAsistencia = listaStatusEventoAsistencia;
	}
}
