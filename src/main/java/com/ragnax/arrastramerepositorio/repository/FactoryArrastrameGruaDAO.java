package com.ragnax.arrastramerepositorio.repository;

public interface FactoryArrastrameGruaDAO {
	
//	public FeeComisionRepository getFeeComisionRepository();
	public AsistenciaRepository getAsistenciaRepository();
	public ClienteAsistenciaRepository getClienteAsistenciaRepository();
	public DisponibilidadGruaEventoRepository getDisponibilidadGruaEventoRepository();
	public EstadoRuedasVehiculoRepository getEstadoRuedasVehiculoRepository();
	public EventoAsistenciaRepository getEventoAsistenciaRepository();
	public GruaVehiculoRepository getGruaVehiculoRepository();
	public StatusEventoAsistenciaRepository getStatusEventoAsistenciaRepository();
	public TipoAsistenciaRepository	getTipoAsistenciaRepository();	
	public TipoGruaVehiculoRepository getTipoGruaVehiculoRepository();
	public TipoStatusEventoAsistenciaRepository getTipoStatusEventoAsistenciaRepository();
	public TipoSuperficieAsistenciaRepository getTipoSuperficieAsistenciaRepository();
	public TipoVehiculoAsistenciaRepository getTipoVehiculoAsistenciaRepository(); 
	
}
