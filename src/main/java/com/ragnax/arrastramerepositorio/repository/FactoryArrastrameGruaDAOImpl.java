package com.ragnax.arrastramerepositorio.repository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

@Repository
public class FactoryArrastrameGruaDAOImpl implements FactoryArrastrameGruaDAO {
	
	@Autowired
	private AsistenciaRepository asistenciaRepository;	
	
	public AsistenciaRepository getAsistenciaRepository() {
		return asistenciaRepository;
	}
	
	@Autowired
	private ClienteAsistenciaRepository clienteAsistenciaRepository;	
	
	public ClienteAsistenciaRepository getClienteAsistenciaRepository() {
		return clienteAsistenciaRepository;
	}
	
	@Autowired
	private DisponibilidadGruaEventoRepository disponibilidadGruaEventoRepository;	
	
	public DisponibilidadGruaEventoRepository getDisponibilidadGruaEventoRepository() {
		return disponibilidadGruaEventoRepository;
	}
	
	@Autowired
	private EstadoRuedasVehiculoRepository estadoRuedasVehiculoRepository;	
	
	public EstadoRuedasVehiculoRepository getEstadoRuedasVehiculoRepository() {
		return estadoRuedasVehiculoRepository;
	}
	
	@Autowired
	private EventoAsistenciaRepository eventoAsistenciaRepository;	
	
	public EventoAsistenciaRepository getEventoAsistenciaRepository() {
		return eventoAsistenciaRepository;
	}
	
	@Autowired
	private GruaVehiculoRepository gruaVehiculoRepository;	
	
	public GruaVehiculoRepository getGruaVehiculoRepository() {
		return gruaVehiculoRepository;
	}
	
	@Autowired
	private StatusEventoAsistenciaRepository statusAsistenciaRepository;	
	
	public StatusEventoAsistenciaRepository getStatusEventoAsistenciaRepository() {
		return statusAsistenciaRepository;
	}
	
	@Autowired
	private TipoAsistenciaRepository tipoAsistenciaRepository;	
	
	public TipoAsistenciaRepository getTipoAsistenciaRepository() {
		return tipoAsistenciaRepository;
	}
	
	@Autowired
	private TipoGruaVehiculoRepository tipoGruaVehiculoRepository;	
	
	public TipoGruaVehiculoRepository getTipoGruaVehiculoRepository() {
		return tipoGruaVehiculoRepository;
	}
	
	@Autowired
	private TipoStatusEventoAsistenciaRepository tipoStatusEventoAsistenciaRepository;	
	
	public TipoStatusEventoAsistenciaRepository getTipoStatusEventoAsistenciaRepository() {
		return tipoStatusEventoAsistenciaRepository;
	}
	
	@Autowired
	private TipoSuperficieAsistenciaRepository tipoSuperficieAsistenciaRepository;	
	
	public TipoSuperficieAsistenciaRepository getTipoSuperficieAsistenciaRepository() {
		return tipoSuperficieAsistenciaRepository;
	}
	
	@Autowired
	private TipoVehiculoAsistenciaRepository tipoVehiculoAsistenciaRepository;	
	
	public TipoVehiculoAsistenciaRepository getTipoVehiculoAsistenciaRepository() {
		return tipoVehiculoAsistenciaRepository;
	}
}
