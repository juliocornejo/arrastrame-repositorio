package com.ragnax.arrastramerepositorio.servicio;

import com.ragnax.arrastramerepositorio.controller.response.*;
import com.ragnax.arrastramerepositorio.entidad.*;
import com.ragnax.arrastramerepositorio.exception.LogicaImplException;

public interface ArrastrameGruaService {
	
	public ArrastrameGrua crearTipoAsistencia(TipoAsistencia objTipoAsistencia) throws LogicaImplException;
	public ArrastrameGrua actualizarTipoAsistencia(Integer id, TipoAsistencia objTipoAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarTipoAsistencia(TipoAsistencia objTipoAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarTodoTipoAsistencia() throws LogicaImplException;
	
	public ArrastrameGrua crearTipoGruaVehiculo(TipoGruaVehiculo objTipoGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua actualizarTipoGruaVehiculo(Integer id, TipoGruaVehiculo objTipoGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua buscarTipoGruaVehiculo(TipoGruaVehiculo objTipoGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua listarTodoTipoGruaVehiculo() throws LogicaImplException;
	
	public ArrastrameGrua crearTipoStatusEventoAsistencia(TipoStatusEventoAsistencia objTipoStatusAsistencia) throws LogicaImplException;
	public ArrastrameGrua actualizarTipoStatusEventoAsistencia(Integer id, TipoStatusEventoAsistencia objTipoStatusAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarTipoStatusEventoAsistencia(TipoStatusEventoAsistencia objTipoStatusAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarTodoTipoStatusEventoAsistencia() throws LogicaImplException;
	
	public ArrastrameGrua crearTipoSuperficieAsistencia(TipoSuperficieAsistencia objTipoSuperficieAsistencia) throws LogicaImplException;
	public ArrastrameGrua actualizarTipoSuperficieAsistencia(Integer id, TipoSuperficieAsistencia objTipoSuperficieAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarTipoSuperficieAsistencia(TipoSuperficieAsistencia objTipoSuperficieAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarTodoTipoSuperficieAsistencia() throws LogicaImplException;
	
	public ArrastrameGrua crearTipoVehiculoAsistencia(TipoVehiculoAsistencia objTipoVehiculoAsistencia) throws LogicaImplException;
	public ArrastrameGrua actualizarTipoVehiculoAsistencia(Integer id, TipoVehiculoAsistencia objTipoVehiculoAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarTipoVehiculoAsistencia(TipoVehiculoAsistencia objTipoVehiculoAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarTodoTipoVehiculoAsistencia() throws LogicaImplException;
	
	public ArrastrameGrua crearEstadoRuedasVehiculo(EstadoRuedasVehiculo objEstadoRuedasVehiculo) throws LogicaImplException;
	public ArrastrameGrua actualizarEstadoRuedasVehiculo(Integer id, EstadoRuedasVehiculo objEstadoRuedasVehiculo) throws LogicaImplException;
	public ArrastrameGrua buscarEstadoRuedasVehiculo(EstadoRuedasVehiculo objEstadoRuedasVehiculo) throws LogicaImplException;
	public ArrastrameGrua listarTodoEstadoRuedasVehiculo() throws LogicaImplException;
	
	public ArrastrameGrua crearClienteAsistencia(ClienteAsistencia objClienteAsistencia) throws LogicaImplException;
	public ArrastrameGrua actualizarClienteAsistencia(Integer idUsuario, ClienteAsistencia objClienteAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarClienteAsistenciaxIdUsuario(ClienteAsistencia objClienteAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarTodoClienteAsistencia() throws LogicaImplException;
	
	public ArrastrameGrua generarCodigoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua crearGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua actualizarGruaVehiculo(Integer idUsuarioGruaVehiculo, GruaVehiculo objGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua buscarGruaVehiculoxCodigoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua listarGruaVehiculoxTipoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException;
	public ArrastrameGrua listarGruaVehiculoxIdPaisxEstadoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException;
	
	public ArrastrameGrua crearAsistencia(Asistencia objAsistencia) throws LogicaImplException;
	public ArrastrameGrua actualizarAsistencia(String codigoAsistencia, Asistencia objAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarAsistenciaxCodigoAsistencia(Asistencia objAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarAsistenciaxTipoAsistencia(Asistencia objAsistencia) throws LogicaImplException;
	
	public ArrastrameGrua crearDisponibilidadGruaEvento(DisponibilidadGruaEvento objDisponibilidadGruaEvento) throws LogicaImplException;
	public ArrastrameGrua actualizarDisponibilidadGruaEvento(String codigoGrua, DisponibilidadGruaEvento objDisponibilidadGruaEvento) throws LogicaImplException;
	public ArrastrameGrua buscarDisponibilidadGruaEventoxCodigoGrua(DisponibilidadGruaEvento objDisponibilidadGruaEvento) throws LogicaImplException;
	public ArrastrameGrua listarDisponibilidadGruaEventoxActivoDisponibilidadGruaEvento(String codigoPais) throws LogicaImplException;
	
	public ArrastrameGrua generarCodigoEventoAsistencia(EventoAsistencia objEventoAsistencia) throws LogicaImplException;
	public ArrastrameGrua crearEventoAsistencia(EventoAsistencia objEventoAsistencia) throws LogicaImplException;
	public ArrastrameGrua actualizarEventoAsistencia(String codigoEventoAsistencia, EventoAsistencia objEventoAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarEventoAsistenciaxCodigoAsistencia(EventoAsistencia objEventoAsistencia) throws LogicaImplException;
	public ArrastrameGrua buscarEventoAsistenciaxIdNegocio(EventoAsistencia objEventoAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarTodoEventoAsistenciaxTipoAsistencia(EventoAsistencia objEventoAsistencia) throws LogicaImplException;
	
	public ArrastrameGrua crearStatusEventoAsistencia(StatusEventoAsistencia objStatusEventoAsistencia) throws LogicaImplException;
	public ArrastrameGrua listarStatusEventoAsistenciaxEventoAsistencia(StatusEventoAsistencia objStatusEventoAsistencia) throws LogicaImplException;
	
	public void limpiarCacheLocal();
	
}
