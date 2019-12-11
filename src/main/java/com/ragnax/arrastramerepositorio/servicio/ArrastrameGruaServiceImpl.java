package com.ragnax.arrastramerepositorio.servicio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ragnax.arrastramerepositorio.configuration.FactoryApiProperties;
import com.ragnax.arrastramerepositorio.controller.response.ArrastrameGrua;
import com.ragnax.arrastramerepositorio.entidad.*;
import com.ragnax.arrastramerepositorio.exception.LogicaImplException;
import com.ragnax.arrastramerepositorio.repository.FactoryArrastrameGruaDAO;
import com.ragnax.arrastramerepositorio.servicio.clientes.ZapalaClienteRest;
import com.ragnax.arrastramerepositorio.servicio.clientes.modelo.ZapalaRequest;
import com.ragnax.arrastramerepositorio.servicio.utilidades.ArrastrameGruaUtilidades;


@Service
public class ArrastrameGruaServiceImpl implements ArrastrameGruaService {
	//Segun se necesite se van creando llamadas al repositorio para devolver entities.
	@Autowired
	private FactoryArrastrameGruaDAO factoryArrastrameGruaDAO;
	
	@Autowired
	private ZapalaClienteRest zapalaClienteRest;
	
	@Autowired
	private FactoryApiProperties factoryApiProperties;
	/***********************************************************/
	/******TipoAsistencia TipoAsistencia TipoAsistencia ********/
	/***********************************************************/
	public ArrastrameGrua crearTipoAsistencia(TipoAsistencia objTipoAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoAsistencia").descending());
			
			Page<TipoAsistencia> pageNombreTipoAsistencia  = factoryArrastrameGruaDAO.getTipoAsistenciaRepository().findByNombreTipoAsistencia(objTipoAsistencia.getNombreTipoAsistencia(), pageByNombreDesc); 
			
			if(pageNombreTipoAsistencia.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoAsistencia").descending());
				
				Page<TipoAsistencia> pageIdTipoAsistencia = factoryArrastrameGruaDAO.getTipoAsistenciaRepository().findAll(pageByidDesc);
				
				Integer idTipoAsistencia = (!pageIdTipoAsistencia.isEmpty()) ? (Integer) pageIdTipoAsistencia.getContent().get(0).getIdTipoAsistencia() + 1 : 1; 
				
				objTipoAsistencia.setIdTipoAsistencia(idTipoAsistencia);
				
				factoryArrastrameGruaDAO.getTipoAsistenciaRepository().save(objTipoAsistencia);
				
				pageNombreTipoAsistencia  = factoryArrastrameGruaDAO.getTipoAsistenciaRepository().findByNombreTipoAsistencia(objTipoAsistencia.getNombreTipoAsistencia(), pageByNombreDesc);
				
				arrastrameGrua.setTipoAsistencia(pageNombreTipoAsistencia.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoAsistencia, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarTipoAsistencia(Integer id, TipoAsistencia objTipoAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
				
			Optional<TipoAsistencia> optPerTipoAsistencia = factoryArrastrameGruaDAO.getTipoAsistenciaRepository().findById(id);
			
			if(optPerTipoAsistencia!=null && optPerTipoAsistencia.isPresent()){
				
				Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoAsistencia").descending());
				
				Page<TipoAsistencia> pageNombreTipoAsistencia  = factoryArrastrameGruaDAO.getTipoAsistenciaRepository().findByNombreTipoAsistencia(objTipoAsistencia.getNombreTipoAsistencia(), pageByNombreDesc);
				
				/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoAsistencia.idTipoAsistencia = id 
				//... solo actualizar estado****/
				if((!pageNombreTipoAsistencia.isEmpty() && pageNombreTipoAsistencia.getContent().get(0).getIdTipoAsistencia()==id)
					|| (optPerTipoAsistencia.isPresent() && pageNombreTipoAsistencia.isEmpty())){
					objTipoAsistencia.setIdTipoAsistencia(id);
					
					factoryArrastrameGruaDAO.getTipoAsistenciaRepository().save(objTipoAsistencia);
					
					arrastrameGrua.setTipoAsistencia(objTipoAsistencia);
				}
				else {
					throw new LogicaImplException("No se puede actualizar TipoAsistencia, nombreTipoAsistencia ya existe en un identificador distinto");
				}
			
			}else {
				throw new LogicaImplException("No se puede actualizar TipoAsistencia, identificador no existe");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarTipoAsistencia(TipoAsistencia objTipoAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoAsistencia> optPerTipoAsistencia = factoryArrastrameGruaDAO.getTipoAsistenciaRepository().findById(objTipoAsistencia.getIdTipoAsistencia());
			
			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoAsistencia!=null && optPerTipoAsistencia.isPresent()){
				
				arrastrameGrua.setTipoAsistencia(optPerTipoAsistencia.get());
			
			}else {
				throw new LogicaImplException("No existe TipoAsistencia con identificador:" +objTipoAsistencia.getIdTipoAsistencia());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarTodoTipoAsistencia() throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<TipoAsistencia> listaTipoAsistencia = factoryArrastrameGruaDAO.getTipoAsistenciaRepository().findAll();

			if(listaTipoAsistencia!=null && !listaTipoAsistencia.isEmpty()){
				arrastrameGrua.setListaTipoAsistencia(listaTipoAsistencia);
			}else {
				throw new LogicaImplException("No existe lista de TipoAsistencia");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	/***********************************************************/
	/******TipoGruaVehiculo TipoGruaVehiculo TipoGruaVehiculo **/
	/***********************************************************/
	public ArrastrameGrua crearTipoGruaVehiculo(TipoGruaVehiculo objTipoGruaVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoGruaVehiculo").descending());
			
			Page<TipoGruaVehiculo> pageNombreTipoGruaVehiculo  = factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().findByNombreTipoGruaVehiculo(objTipoGruaVehiculo.getNombreTipoGruaVehiculo(), pageByNombreDesc); 
			
			if(pageNombreTipoGruaVehiculo.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoGruaVehiculo").descending());
				
				Page<TipoGruaVehiculo> pageIdTipoGruaVehiculo = factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().findAll(pageByidDesc);
				
				Integer idTipoGruaVehiculo = (!pageIdTipoGruaVehiculo.isEmpty()) ? (Integer) pageIdTipoGruaVehiculo.getContent().get(0).getIdTipoGruaVehiculo() + 1 : 1;
				
				objTipoGruaVehiculo.setIdTipoGruaVehiculo(idTipoGruaVehiculo);
				
				factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().save(objTipoGruaVehiculo);
				
				pageNombreTipoGruaVehiculo  = factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().findByNombreTipoGruaVehiculo(objTipoGruaVehiculo.getNombreTipoGruaVehiculo(), pageByNombreDesc);
				
				arrastrameGrua.setTipoGruaVehiculo(pageNombreTipoGruaVehiculo.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoGruaVehiculo, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarTipoGruaVehiculo(Integer id, TipoGruaVehiculo objTipoGruaVehiculo) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			TipoGruaVehiculo idTipoGruaVehiculo =  buscarTipoGruaVehiculo(new TipoGruaVehiculo(id)).getTipoGruaVehiculo();

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoGruaVehiculo").descending());

			Page<TipoGruaVehiculo> pageNombreTipoGruaVehiculo  = factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().findByNombreTipoGruaVehiculo(objTipoGruaVehiculo.getNombreTipoGruaVehiculo(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoGruaVehiculo.idTipoGruaVehiculo = id 
				//... solo actualizar estado****/
			if((!pageNombreTipoGruaVehiculo.isEmpty() && pageNombreTipoGruaVehiculo.getContent().get(0).getIdTipoGruaVehiculo()==id)
					|| (idTipoGruaVehiculo!=null && pageNombreTipoGruaVehiculo.isEmpty())){
				objTipoGruaVehiculo.setIdTipoGruaVehiculo(id);

				factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().save(objTipoGruaVehiculo);

				arrastrameGrua.setTipoGruaVehiculo(objTipoGruaVehiculo);
			}
			else {
				throw new LogicaImplException("No se puede actualizar TipoGruaVehiculo, nombreTipoGruaVehiculo ya existe en un identificador distinto");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarTipoGruaVehiculo(TipoGruaVehiculo objTipoGruaVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoGruaVehiculo> optPerTipoGruaVehiculo = factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().findById(objTipoGruaVehiculo.getIdTipoGruaVehiculo());
			
			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoGruaVehiculo!=null && optPerTipoGruaVehiculo.isPresent()){
				
				arrastrameGrua.setTipoGruaVehiculo(optPerTipoGruaVehiculo.get());
			
			}else {
				throw new LogicaImplException("No existe TipoGruaVehiculo con identificador:" +objTipoGruaVehiculo.getIdTipoGruaVehiculo());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarTodoTipoGruaVehiculo() throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<TipoGruaVehiculo> listaTipoGruaVehiculo = factoryArrastrameGruaDAO.getTipoGruaVehiculoRepository().findAll();

			if(listaTipoGruaVehiculo!=null && !listaTipoGruaVehiculo.isEmpty()){
				arrastrameGrua.setListaTipoGruaVehiculo(listaTipoGruaVehiculo);
			}else {
				throw new LogicaImplException("No existe lista de TipoGruaVehiculo");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	/***********************************************************************/
	/******TipoStatusEventoAsistencia TipoStatusEventoAsistencia  **********/
	/***********************************************************************/
	public ArrastrameGrua crearTipoStatusEventoAsistencia(TipoStatusEventoAsistencia objTipoStatusEventoAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoStatusEventoAsistencia").descending());
			
			Page<TipoStatusEventoAsistencia> pageNombreTipoStatusEventoAsistencia  = factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().findByNombreTipoStatusEventoAsistencia(objTipoStatusEventoAsistencia.getNombreTipoStatusEventoAsistencia(), pageByNombreDesc); 
			
			if(pageNombreTipoStatusEventoAsistencia.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoStatusEventoAsistencia").descending());
				
				Page<TipoStatusEventoAsistencia> pageIdTipoStatusEventoAsistencia = factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().findAll(pageByidDesc);
				
				Integer idTipoStatusEventoAsistencia = (!pageIdTipoStatusEventoAsistencia.isEmpty()) ? (Integer) pageIdTipoStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia() + 1 : 1;
				
				objTipoStatusEventoAsistencia.setIdTipoStatusEventoAsistencia(idTipoStatusEventoAsistencia);
				
				factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().save(objTipoStatusEventoAsistencia);
				
				pageNombreTipoStatusEventoAsistencia  = factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().findByNombreTipoStatusEventoAsistencia(objTipoStatusEventoAsistencia.getNombreTipoStatusEventoAsistencia(), pageByNombreDesc);
				
				arrastrameGrua.setTipoStatusEventoAsistencia(pageNombreTipoStatusEventoAsistencia.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoStatusEventoAsistencia, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarTipoStatusEventoAsistencia(Integer id, TipoStatusEventoAsistencia objTipoStatusEventoAsistencia) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			TipoStatusEventoAsistencia idTipoStatusEventoAsistencia = buscarTipoStatusEventoAsistencia(new TipoStatusEventoAsistencia(id)).getTipoStatusEventoAsistencia();

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoStatusEventoAsistencia").descending());

			Page<TipoStatusEventoAsistencia> pageNombreTipoStatusEventoAsistencia  = factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().findByNombreTipoStatusEventoAsistencia(objTipoStatusEventoAsistencia.getNombreTipoStatusEventoAsistencia(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoStatusEventoAsistencia.idTipoStatusEventoAsistencia = id 
				//... solo actualizar estado****/
			if((!pageNombreTipoStatusEventoAsistencia.isEmpty() && pageNombreTipoStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia()==id)
					|| (idTipoStatusEventoAsistencia!=null && pageNombreTipoStatusEventoAsistencia.isEmpty())){
				objTipoStatusEventoAsistencia.setIdTipoStatusEventoAsistencia(id);

				factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().save(objTipoStatusEventoAsistencia);

				arrastrameGrua.setTipoStatusEventoAsistencia(objTipoStatusEventoAsistencia);
			}
			else {
				throw new LogicaImplException("No se puede actualizar TipoStatusEventoAsistencia, nombreTipoStatusEventoAsistencia ya existe en un identificador distinto");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarTipoStatusEventoAsistencia(TipoStatusEventoAsistencia objTipoStatusEventoAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoStatusEventoAsistencia> optPerTipoStatusEventoAsistencia = factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().findById(objTipoStatusEventoAsistencia.getIdTipoStatusEventoAsistencia());
			
			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoStatusEventoAsistencia!=null && optPerTipoStatusEventoAsistencia.isPresent()){
				
				arrastrameGrua.setTipoStatusEventoAsistencia(optPerTipoStatusEventoAsistencia.get());
			
			}else {
				throw new LogicaImplException("No existe TipoStatusEventoAsistencia con identificador:" +objTipoStatusEventoAsistencia.getIdTipoStatusEventoAsistencia());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarTodoTipoStatusEventoAsistencia() throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<TipoStatusEventoAsistencia> listaTipoStatusEventoAsistencia = factoryArrastrameGruaDAO.getTipoStatusEventoAsistenciaRepository().findAll();

			if(listaTipoStatusEventoAsistencia!=null && !listaTipoStatusEventoAsistencia.isEmpty()){
				arrastrameGrua.setListaTipoStatusEventoAsistencia(listaTipoStatusEventoAsistencia);
			}else {
				throw new LogicaImplException("No existe lista de TipoStatusEventoAsistencia");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	/***********************************************************/
	/******TipoSuperficieAsistencia TipoSuperficieAsistencia****/
	/***********************************************************/
	public ArrastrameGrua crearTipoSuperficieAsistencia(TipoSuperficieAsistencia objTipoSuperficieAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		
		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoSuperficieAsistencia").descending());
			
			Page<TipoSuperficieAsistencia> pageNombreTipoSuperficieAsistencia  = factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().findByNombreTipoSuperficieAsistencia(objTipoSuperficieAsistencia.getNombreTipoSuperficieAsistencia(), pageByNombreDesc); 
			
			if(pageNombreTipoSuperficieAsistencia.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoSuperficieAsistencia").descending());
				
				Page<TipoSuperficieAsistencia> pageIdTipoSuperficieAsistencia = factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().findAll(pageByidDesc);
				
				Integer idTipoSuperficieAsistencia = (!pageIdTipoSuperficieAsistencia.isEmpty()) ? (Integer) pageIdTipoSuperficieAsistencia.getContent().get(0).getIdTipoSuperficieAsistencia() + 1 : 1;
				
				objTipoSuperficieAsistencia.setIdTipoSuperficieAsistencia(idTipoSuperficieAsistencia);
				
				factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().save(objTipoSuperficieAsistencia);
				
				pageNombreTipoSuperficieAsistencia  = factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().findByNombreTipoSuperficieAsistencia(objTipoSuperficieAsistencia.getNombreTipoSuperficieAsistencia(), pageByNombreDesc);
				
				arrastrameGrua.setTipoSuperficieAsistencia(pageNombreTipoSuperficieAsistencia.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoSuperficieAsistencia, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarTipoSuperficieAsistencia(Integer id, TipoSuperficieAsistencia objTipoSuperficieAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
				
			TipoSuperficieAsistencia idTipoSuperficieAsistencia = buscarTipoSuperficieAsistencia(new TipoSuperficieAsistencia(id)).getTipoSuperficieAsistencia();
			
				
				Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoSuperficieAsistencia").descending());
				
				Page<TipoSuperficieAsistencia> pageNombreTipoSuperficieAsistencia  = factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().findByNombreTipoSuperficieAsistencia(objTipoSuperficieAsistencia.getNombreTipoSuperficieAsistencia(), pageByNombreDesc);
				
				/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoSuperficieAsistencia.idTipoSuperficieAsistencia = id 
				//... solo actualizar estado****/
				if((!pageNombreTipoSuperficieAsistencia.isEmpty() && pageNombreTipoSuperficieAsistencia.getContent().get(0).getIdTipoSuperficieAsistencia()==id)
					|| (idTipoSuperficieAsistencia != null && pageNombreTipoSuperficieAsistencia.isEmpty())){
					objTipoSuperficieAsistencia.setIdTipoSuperficieAsistencia(id);
					
					factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().save(objTipoSuperficieAsistencia);
					
					arrastrameGrua.setTipoSuperficieAsistencia(objTipoSuperficieAsistencia);
				}
				else {
					throw new LogicaImplException("No se puede actualizar TipoSuperficieAsistencia, nombreTipoSuperficieAsistencia ya existe en un identificador distinto");
				}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarTipoSuperficieAsistencia(TipoSuperficieAsistencia objTipoSuperficieAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoSuperficieAsistencia> optPerTipoSuperficieAsistencia = factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().findById(objTipoSuperficieAsistencia.getIdTipoSuperficieAsistencia());
			
			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoSuperficieAsistencia!=null && optPerTipoSuperficieAsistencia.isPresent()){
				
				arrastrameGrua.setTipoSuperficieAsistencia(optPerTipoSuperficieAsistencia.get());
			
			}else {
				throw new LogicaImplException("No existe TipoSuperficieAsistencia con identificador:" +objTipoSuperficieAsistencia.getIdTipoSuperficieAsistencia());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarTodoTipoSuperficieAsistencia() throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<TipoSuperficieAsistencia> listaTipoSuperficieAsistencia = factoryArrastrameGruaDAO.getTipoSuperficieAsistenciaRepository().findAll();

			if(listaTipoSuperficieAsistencia!=null && !listaTipoSuperficieAsistencia.isEmpty()){
				arrastrameGrua.setListaTipoSuperficieAsistencia(listaTipoSuperficieAsistencia);
			}else {
				throw new LogicaImplException("No existe lista de TipoSuperficieAsistencia");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	/***********************************************************/
	/******TipoVehiculoAsistencia TipoVehiculoAsistencia *******/
	/***********************************************************/
	public ArrastrameGrua crearTipoVehiculoAsistencia(TipoVehiculoAsistencia objTipoVehiculoAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoVehiculoAsistencia").descending());
			
			Page<TipoVehiculoAsistencia> pageNombreTipoVehiculoAsistencia  = factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().findByNombreTipoVehiculoAsistencia(objTipoVehiculoAsistencia.getNombreTipoVehiculoAsistencia(), pageByNombreDesc); 
			
			if(pageNombreTipoVehiculoAsistencia.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoVehiculoAsistencia").descending());
				
				Page<TipoVehiculoAsistencia> pageIdTipoVehiculoAsistencia = factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().findAll(pageByidDesc);
				
				Integer idTipoVehiculoAsistencia = (!pageIdTipoVehiculoAsistencia.isEmpty()) ? (Integer) pageIdTipoVehiculoAsistencia.getContent().get(0).getIdTipoVehiculoAsistencia() + 1 : 1;
				
				objTipoVehiculoAsistencia.setIdTipoVehiculoAsistencia(idTipoVehiculoAsistencia);
				
				factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().save(objTipoVehiculoAsistencia);
				
				pageNombreTipoVehiculoAsistencia  = factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().findByNombreTipoVehiculoAsistencia(objTipoVehiculoAsistencia.getNombreTipoVehiculoAsistencia(), pageByNombreDesc);
				
				arrastrameGrua.setTipoVehiculoAsistencia(pageNombreTipoVehiculoAsistencia.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoVehiculoAsistencia, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarTipoVehiculoAsistencia(Integer id, TipoVehiculoAsistencia objTipoVehiculoAsistencia) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			TipoVehiculoAsistencia idTipoVehiculoAsistencia = buscarTipoVehiculoAsistencia(new TipoVehiculoAsistencia(id)).getTipoVehiculoAsistencia();

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoVehiculoAsistencia").descending());

			Page<TipoVehiculoAsistencia> pageNombreTipoVehiculoAsistencia  = factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().findByNombreTipoVehiculoAsistencia(objTipoVehiculoAsistencia.getNombreTipoVehiculoAsistencia(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoVehiculoAsistencia.idTipoVehiculoAsistencia = id 
				//... solo actualizar estado****/
			if((!pageNombreTipoVehiculoAsistencia.isEmpty() && pageNombreTipoVehiculoAsistencia.getContent().get(0).getIdTipoVehiculoAsistencia()==id)
					|| (idTipoVehiculoAsistencia != null && pageNombreTipoVehiculoAsistencia.isEmpty())){
				objTipoVehiculoAsistencia.setIdTipoVehiculoAsistencia(id);

				factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().save(objTipoVehiculoAsistencia);

				arrastrameGrua.setTipoVehiculoAsistencia(objTipoVehiculoAsistencia);
			}
			else {
				throw new LogicaImplException("No se puede actualizar TipoVehiculoAsistencia, nombreTipoVehiculoAsistencia ya existe en un identificador distinto");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarTipoVehiculoAsistencia(TipoVehiculoAsistencia objTipoVehiculoAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoVehiculoAsistencia> optPerTipoVehiculoAsistencia = factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().findById(objTipoVehiculoAsistencia.getIdTipoVehiculoAsistencia());
			
			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoVehiculoAsistencia!=null && optPerTipoVehiculoAsistencia.isPresent()){
				
				arrastrameGrua.setTipoVehiculoAsistencia(optPerTipoVehiculoAsistencia.get());
			
			}else {
				throw new LogicaImplException("No existe TipoVehiculoAsistencia con identificador:" +objTipoVehiculoAsistencia.getIdTipoVehiculoAsistencia());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarTodoTipoVehiculoAsistencia() throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<TipoVehiculoAsistencia> listaTipoVehiculoAsistencia = factoryArrastrameGruaDAO.getTipoVehiculoAsistenciaRepository().findAll();

			if(listaTipoVehiculoAsistencia!=null && !listaTipoVehiculoAsistencia.isEmpty()){
				arrastrameGrua.setListaTipoVehiculoAsistencia(listaTipoVehiculoAsistencia);
			}else {
				throw new LogicaImplException("No existe lista de TipoVehiculoAsistencia");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	/***********************************************************/
	/******EstadoRuedasVehiculo EstadoRuedasVehiculo ***********/
	/***********************************************************/
	public ArrastrameGrua crearEstadoRuedasVehiculo(EstadoRuedasVehiculo objEstadoRuedasVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreEstadoRuedasVehiculo").descending());
			
			Page<EstadoRuedasVehiculo> pageNombreEstadoRuedasVehiculo  = factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().findByNombreEstadoRuedasVehiculo(objEstadoRuedasVehiculo.getNombreEstadoRuedasVehiculo(), pageByNombreDesc); 
			
			if(pageNombreEstadoRuedasVehiculo.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEstadoRuedasVehiculo").descending());
				
				Page<EstadoRuedasVehiculo> pageIdEstadoRuedasVehiculo = factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().findAll(pageByidDesc);
				
				Integer idEstadoRuedasVehiculo = (!pageIdEstadoRuedasVehiculo.isEmpty()) ? (Integer) pageIdEstadoRuedasVehiculo.getContent().get(0).getIdEstadoRuedasVehiculo() + 1 : 1;
				
				objEstadoRuedasVehiculo.setIdEstadoRuedasVehiculo(idEstadoRuedasVehiculo);
				
				factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().save(objEstadoRuedasVehiculo);
				
				pageNombreEstadoRuedasVehiculo  = factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().findByNombreEstadoRuedasVehiculo(objEstadoRuedasVehiculo.getNombreEstadoRuedasVehiculo(), pageByNombreDesc);
				
				arrastrameGrua.setEstadoRuedasVehiculo(pageNombreEstadoRuedasVehiculo.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear EstadoRuedasVehiculo, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarEstadoRuedasVehiculo(Integer id, EstadoRuedasVehiculo objEstadoRuedasVehiculo) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			EstadoRuedasVehiculo idEstadoRuedasVehiculo = buscarEstadoRuedasVehiculo(new EstadoRuedasVehiculo(id)).getEstadoRuedasVehiculo();

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreEstadoRuedasVehiculo").descending());

			Page<EstadoRuedasVehiculo> pageNombreEstadoRuedasVehiculo  = factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().findByNombreEstadoRuedasVehiculo(objEstadoRuedasVehiculo.getNombreEstadoRuedasVehiculo(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreEstadoRuedasVehiculo.idEstadoRuedasVehiculo = id 
				//... solo actualizar estado****/
			if((!pageNombreEstadoRuedasVehiculo.isEmpty() && pageNombreEstadoRuedasVehiculo.getContent().get(0).getIdEstadoRuedasVehiculo()==id)
					|| (idEstadoRuedasVehiculo!=null && pageNombreEstadoRuedasVehiculo.isEmpty())){
				objEstadoRuedasVehiculo.setIdEstadoRuedasVehiculo(id);

				factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().save(objEstadoRuedasVehiculo);

				arrastrameGrua.setEstadoRuedasVehiculo(objEstadoRuedasVehiculo);
			}
			else {
				throw new LogicaImplException("No se puede actualizar EstadoRuedasVehiculo, nombreEstadoRuedasVehiculo ya existe en un identificador distinto");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarEstadoRuedasVehiculo(EstadoRuedasVehiculo objEstadoRuedasVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<EstadoRuedasVehiculo> optPerEstadoRuedasVehiculo = factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().findById(objEstadoRuedasVehiculo.getIdEstadoRuedasVehiculo());
			
			/***Si existe reemplazar por el nuevo*/
			if(optPerEstadoRuedasVehiculo!=null && optPerEstadoRuedasVehiculo.isPresent()){
				
				arrastrameGrua.setEstadoRuedasVehiculo(optPerEstadoRuedasVehiculo.get());
			
			}else {
				throw new LogicaImplException("No existe EstadoRuedasVehiculo con identificador:" +objEstadoRuedasVehiculo.getIdEstadoRuedasVehiculo());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarTodoEstadoRuedasVehiculo() throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<EstadoRuedasVehiculo> listaEstadoRuedasVehiculo = factoryArrastrameGruaDAO.getEstadoRuedasVehiculoRepository().findAll();

			if(listaEstadoRuedasVehiculo!=null && !listaEstadoRuedasVehiculo.isEmpty()){
				arrastrameGrua.setListaEstadoRuedasVehiculo(listaEstadoRuedasVehiculo);
			}else {
				throw new LogicaImplException("No existe lista de EstadoRuedasVehiculo");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	/***********************************************************/
	/******ClienteAsistencia ClienteAsistencia *****************/
	/***********************************************************/
	public ArrastrameGrua crearClienteAsistencia(ClienteAsistencia objClienteAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {

			Pageable pageByIdUsuario = PageRequest.of(0, 1, Sort.by("idUsuario").descending());
			
			Page<ClienteAsistencia> pageIdUsuario  = factoryArrastrameGruaDAO.getClienteAsistenciaRepository().findByIdUsuario(objClienteAsistencia.getIdUsuario(), pageByIdUsuario); 
			
			if(pageIdUsuario.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idClienteAsistencia").descending());
				
				Page<ClienteAsistencia> pageIdClienteAsistencia = factoryArrastrameGruaDAO.getClienteAsistenciaRepository().findAll(pageByidDesc);
				
				Integer idClienteAsistencia = (!pageIdClienteAsistencia.isEmpty()) ? (Integer) pageIdClienteAsistencia.getContent().get(0).getIdClienteAsistencia() + 1 : 1;
				
				objClienteAsistencia.setIdClienteAsistencia(idClienteAsistencia);
				
				factoryArrastrameGruaDAO.getClienteAsistenciaRepository().save(objClienteAsistencia);
				
				objClienteAsistencia  = buscarClienteAsistenciaxIdUsuario(objClienteAsistencia).getClienteAsistencia();
				
				arrastrameGrua.setClienteAsistencia(objClienteAsistencia);
			}else {
				throw new LogicaImplException("No se puede crear ClienteAsistencia, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarClienteAsistencia(Integer idUsuario, ClienteAsistencia objClienteAsistencia) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			Pageable pageByIdUsuario = PageRequest.of(0, 1, Sort.by("idUsuario").descending());

			Page<ClienteAsistencia> pageIdUsuario  = factoryArrastrameGruaDAO.getClienteAsistenciaRepository().findByIdUsuario(idUsuario, pageByIdUsuario);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreClienteAsistencia.idClienteAsistencia = id 
				//... solo actualizar estado****/
			if(!pageIdUsuario.isEmpty() && pageIdUsuario.getContent().get(0).getIdUsuario()==idUsuario){
				objClienteAsistencia.setIdUsuario(idUsuario);

				factoryArrastrameGruaDAO.getClienteAsistenciaRepository().save(objClienteAsistencia);

				arrastrameGrua.setClienteAsistencia(objClienteAsistencia);
			}
			else {
				throw new LogicaImplException("No se puede actualizar ClienteAsistencia, nombreClienteAsistencia ya existe en un identificador distinto");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarClienteAsistenciaxIdUsuario(ClienteAsistencia objClienteAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByIdUsuario = PageRequest.of(0, 1, Sort.by("idUsuario").descending());

			Page<ClienteAsistencia> pageIdUsuario  = factoryArrastrameGruaDAO.getClienteAsistenciaRepository().findByIdUsuario(objClienteAsistencia.getIdUsuario(), pageByIdUsuario);
			
			/***Si existe reemplazar por el nuevo*/
			if(!pageIdUsuario.isEmpty()){

				arrastrameGrua.setClienteAsistencia(pageIdUsuario.getContent().get(0));
			
			}else {
				throw new LogicaImplException("No existe ClienteAsistencia con identificador:" +objClienteAsistencia.getIdClienteAsistencia());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarTodoClienteAsistencia() throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<ClienteAsistencia> listaClienteAsistencia = factoryArrastrameGruaDAO.getClienteAsistenciaRepository().findAll();

			if(listaClienteAsistencia!=null && !listaClienteAsistencia.isEmpty()){
				arrastrameGrua.setListaClienteAsistencia(listaClienteAsistencia);
			}else {
				throw new LogicaImplException("No existe lista de ClienteAsistencia");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	/***********************************************************/
	/******GruaVehiculo GruaVehiculo ***************************/
	/***********************************************************/
	public ArrastrameGrua generarCodigoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			if(buscarTipoGruaVehiculo(objGruaVehiculo.getIdTipoGruaVehiculo()).getTipoGruaVehiculo().getIdTipoGruaVehiculo() > 0){

				String codigoGruaVehiculo = zapalaClienteRest.generarCodigoByNumeroByEncodear(new ZapalaRequest(
						ArrastrameGruaUtilidades.crearListaCadenaCodigoGrua(objGruaVehiculo))).getCodigoGenerado();
				
				/**Buscar si el codigo existe*/
				Pageable pageByCodigoGruaVehiculo = PageRequest.of(0, 1, Sort.by("codigoGruaVehiculo").descending());

				Page<GruaVehiculo> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findByCodigoGruaVehiculo(
						objGruaVehiculo.getCodigoGruaVehiculo(), pageByCodigoGruaVehiculo);

				if(pageCodigoGruaVehiculo.isEmpty()) {

					objGruaVehiculo.setCodigoGruaVehiculo(codigoGruaVehiculo);

					arrastrameGrua.setGruaVehiculo(objGruaVehiculo);
				}

			}else {
				throw new LogicaImplException("No se puede crear codigo de viaje, datos de validacion erroneos");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	
	public ArrastrameGrua crearGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		
		try {
			
			buscarTipoGruaVehiculo(objGruaVehiculo.getIdTipoGruaVehiculo());
			
			Pageable pageByCodigoGruaVehiculo = PageRequest.of(0, 1, Sort.by("codigoGruaVehiculo").descending());

			Page<GruaVehiculo> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findByCodigoGruaVehiculo(
					objGruaVehiculo.getCodigoGruaVehiculo(), pageByCodigoGruaVehiculo);
			
			if(pageCodigoGruaVehiculo.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idGruaVehiculo").descending());
				
				Page<GruaVehiculo> pageIdGruaVehiculo = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findAll(pageByidDesc);
				
				Integer idGruaVehiculo = (!pageIdGruaVehiculo.isEmpty()) ? (Integer) pageIdGruaVehiculo.getContent().get(0).getIdGruaVehiculo() + 1 : 1;
				
				objGruaVehiculo.setIdGruaVehiculo(idGruaVehiculo);
				
				objGruaVehiculo.setEstadoGruaVehiculo(true);
				
				factoryArrastrameGruaDAO.getGruaVehiculoRepository().save(objGruaVehiculo);
				
				objGruaVehiculo  = buscarGruaVehiculoxCodigoGruaVehiculo(objGruaVehiculo).getGruaVehiculo();
				
				arrastrameGrua.setGruaVehiculo(objGruaVehiculo);
			}else {
				throw new LogicaImplException("No se puede crear GruaVehiculo, parametros ya existen en identificador valido");
			}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua actualizarGruaVehiculo(Integer idUsuarioGruaVehiculo, GruaVehiculo objGruaVehiculo) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			if(idUsuarioGruaVehiculo > 0){

				Pageable pageByCodigoGruaVehiculo = PageRequest.of(0, 1, Sort.by("codigoGruaVehiculo").descending());

				Page<GruaVehiculo> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findByCodigoGruaVehiculo(
						objGruaVehiculo.getCodigoGruaVehiculo(), pageByCodigoGruaVehiculo);

				/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreGruaVehiculo.idGruaVehiculo = id 
				//... solo actualizar estado****/
				if(!pageCodigoGruaVehiculo.isEmpty() && pageCodigoGruaVehiculo.getContent().get(0).getIdUsuarioGruaVehiculo()==idUsuarioGruaVehiculo){
					objGruaVehiculo.setIdUsuarioGruaVehiculo(idUsuarioGruaVehiculo);

					factoryArrastrameGruaDAO.getGruaVehiculoRepository().save(objGruaVehiculo);

					arrastrameGrua.setGruaVehiculo(objGruaVehiculo);
				}
				else {
					throw new LogicaImplException("No se puede actualizar GruaVehiculo, nombreGruaVehiculo ya existe en un identificador distinto");
				}

			}else {
				throw new LogicaImplException("No se puede actualizar GruaVehiculo, identificador no existe");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarGruaVehiculoxCodigoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByCodigoGruaVehiculo = PageRequest.of(0, 1, Sort.by("codigoGruaVehiculo").descending());

			Page<GruaVehiculo> pageIdUsuario  = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findByCodigoGruaVehiculo(
					objGruaVehiculo.getCodigoGruaVehiculo(), pageByCodigoGruaVehiculo);
			
			/***Si existe reemplazar por el nuevo*/
			if(!pageIdUsuario.isEmpty()){

				arrastrameGrua.setGruaVehiculo(pageIdUsuario.getContent().get(0));
			
			}else {
				throw new LogicaImplException("No existe GruaVehiculo con identificador:" +objGruaVehiculo.getIdGruaVehiculo());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarGruaVehiculoxTipoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<GruaVehiculo> listaGruaVehiculo = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findByIdTipoGruaVehiculo(
					objGruaVehiculo.getIdTipoGruaVehiculo());

			if(listaGruaVehiculo!=null && !listaGruaVehiculo.isEmpty()){
				arrastrameGrua.setListaGruaVehiculo(listaGruaVehiculo);
			}else {
				throw new LogicaImplException("No existe lista de GruaVehiculo");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	public ArrastrameGrua listarGruaVehiculoxIdPaisxEstadoGruaVehiculo(GruaVehiculo objGruaVehiculo) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<GruaVehiculo> listaGruaVehiculo = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findByCodigoPaisPortalAndEstadoGruaVehiculo(
					objGruaVehiculo.getCodigoPaisPortal(), objGruaVehiculo.getEstadoGruaVehiculo());

			if(listaGruaVehiculo!=null && !listaGruaVehiculo.isEmpty()){
				arrastrameGrua.setListaGruaVehiculo(listaGruaVehiculo);
			}else {
				throw new LogicaImplException("No existe lista de GruaVehiculo");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
			
		return arrastrameGrua;
	}
	
	/***********************************************************/
	/******Asistencia Asistencia Asistencia ********************/
	/***********************************************************/
	/***Codigo generado al momento de guardar la asistencia***/
	
	public ArrastrameGrua crearAsistencia(Asistencia objAsistencia) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		
		try {

			buscarTipoAsistencia(objAsistencia.getIdTipoAsistencia());
			
			buscarTipoSuperficieAsistencia(objAsistencia.getIdTipoSuperficieAsistencia());
			
			buscarTipoVehiculoAsistencia(objAsistencia.getIdTipoVehiculoAsistencia());
			
			buscarClienteAsistenciaxIdUsuario(objAsistencia.getIdClienteAsistencia());
			
			buscarEstadoRuedasVehiculo(objAsistencia.getIdEstadoRuedasVehiculo());

			Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAsistencia").descending());

			Page<Asistencia> pageIdAsistencia = factoryArrastrameGruaDAO.getAsistenciaRepository().findAll(pageByidDesc);
			
			Integer idAsistencia = (!pageIdAsistencia.isEmpty()) ? (Integer) pageIdAsistencia.getContent().get(0).getIdAsistencia() + 1 : 1;
			
			objAsistencia.setFechaRegistroAsistencia(new Timestamp(new Date().getTime()));

			objAsistencia.setIdClienteAsistencia(buscarClienteAsistenciaxIdUsuario(objAsistencia.getIdClienteAsistencia()).getClienteAsistencia());

			objAsistencia.setIdAsistencia(idAsistencia);
			
			String codigoAsistencia = zapalaClienteRest.generarCodigoByNumeroByEncodear(new ZapalaRequest(
					ArrastrameGruaUtilidades.crearListaCadenaCodigoAsistencia(objAsistencia))).getCodigoGenerado();

			objAsistencia.setCodigoAsistencia(codigoAsistencia);

			factoryArrastrameGruaDAO.getAsistenciaRepository().save(objAsistencia);

			objAsistencia  = buscarAsistenciaxCodigoAsistencia(objAsistencia).getAsistencia();

			arrastrameGrua.setAsistencia(objAsistencia);

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}

	public ArrastrameGrua actualizarAsistencia(String codigoAsistencia, Asistencia objAsistencia) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			Pageable pageByCodigoAsistencia = PageRequest.of(0, 1, Sort.by("codigoAsistencia").descending());

			Page<Asistencia> pageAsistencia  = factoryArrastrameGruaDAO.getAsistenciaRepository().findByCodigoAsistencia(
					codigoAsistencia, pageByCodigoAsistencia); 

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreAsistencia.idAsistencia = id 
				//... solo actualizar estado****/
			if(!pageAsistencia.isEmpty() && pageAsistencia.getContent().get(0).getCodigoAsistencia()==codigoAsistencia){
				objAsistencia.setCodigoAsistencia(codigoAsistencia);

				factoryArrastrameGruaDAO.getAsistenciaRepository().save(objAsistencia);

				arrastrameGrua.setAsistencia(objAsistencia);
			}
			else {
				throw new LogicaImplException("No se puede actualizar Asistencia, nombreAsistencia ya existe en un identificador distinto");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarAsistenciaxCodigoAsistencia(Asistencia objAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByCodigoAsistencia = PageRequest.of(0, 1, Sort.by("codigoAsistencia").descending());
			
			Page<Asistencia> pageAsistencia  = factoryArrastrameGruaDAO.getAsistenciaRepository().findByCodigoAsistencia(
					objAsistencia.getCodigoAsistencia(), pageByCodigoAsistencia);
			
			/***Si existe reemplazar por el nuevo*/
			if(!pageAsistencia.isEmpty()){

				arrastrameGrua.setAsistencia(pageAsistencia.getContent().get(0));
			
			}else {
				throw new LogicaImplException("No existe Asistencia con identificador:" +objAsistencia.getIdAsistencia());
			}
			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua listarAsistenciaxTipoAsistencia(Asistencia objAsistencia) throws LogicaImplException{
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		try {
			List<Asistencia> listaAsistencia = factoryArrastrameGruaDAO.getAsistenciaRepository().findByIdTipoAsistencia(
					objAsistencia.getIdTipoAsistencia());

			if(listaAsistencia!=null && !listaAsistencia.isEmpty()){
				arrastrameGrua.setListaAsistencia(listaAsistencia);
			}else {
				throw new LogicaImplException("No existe lista de Asistencia");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
		return arrastrameGrua;
	}
	
	/*************************************************************/
	/******DisponibilidadGruaEvento DisponibilidadGruaEvento *****/
	/*************************************************************/
	public ArrastrameGrua crearDisponibilidadGruaEvento(DisponibilidadGruaEvento objDisponibilidadGruaEvento) throws LogicaImplException {

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			Timestamp tsInicial = new Timestamp(new Date().getTime());

			GruaVehiculo metGruaVehiculo = buscarGruaVehiculoxCodigoGruaVehiculo(objDisponibilidadGruaEvento.getIdGruaVehiculo()).getGruaVehiculo();
			//Grua debe estar Activa para crear disponibilidad grua.

			//Traer todos la Disponibilidad de Grua
			List<GruaVehiculo> listaGruaVehiculo = new ArrayList<GruaVehiculo>();

			listaGruaVehiculo.add(metGruaVehiculo);

			List<DisponibilidadGruaEvento> listaDisponibilidadGruaEvento  = factoryArrastrameGruaDAO.getDisponibilidadGruaEventoRepository().
					findByIdGruaVehiculoInAndEstadoDisponibilidadGruaEvento(listaGruaVehiculo, true); 
			/**NO debe existir disponibilidad para la misma grua.**/
			if(listaDisponibilidadGruaEvento.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idDisponibilidadGruaEvento").descending());

				Page<DisponibilidadGruaEvento> pageIdDisponibilidadGruaEvento = factoryArrastrameGruaDAO.getDisponibilidadGruaEventoRepository().findAll(pageByidDesc);

				Integer idDisponibilidadGruaEvento = (!pageIdDisponibilidadGruaEvento.isEmpty()) ? (Integer) pageIdDisponibilidadGruaEvento.getContent().get(0).getIdDisponibilidadGruaEvento() + 1 : 1;
				
				objDisponibilidadGruaEvento.setIdDisponibilidadGruaEvento(idDisponibilidadGruaEvento);
				
				objDisponibilidadGruaEvento.setEstadoDisponibilidadGruaEvento(true);
				
				objDisponibilidadGruaEvento.setFechaInicioDisponibilidadGruaEvento(tsInicial);

				factoryArrastrameGruaDAO.getDisponibilidadGruaEventoRepository().save(objDisponibilidadGruaEvento);

				objDisponibilidadGruaEvento = buscarDisponibilidadGruaEventoxCodigoGrua(objDisponibilidadGruaEvento).getDisponibilidadGruaEvento();

				arrastrameGrua.setDisponibilidadGruaEvento(objDisponibilidadGruaEvento);
			}else {
				throw new LogicaImplException("No se puede crear DisponibilidadGruaEvento, no existen grua disponible");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}

	public ArrastrameGrua actualizarDisponibilidadGruaEvento(String codigoGrua, DisponibilidadGruaEvento objDisponibilidadGruaEvento) throws LogicaImplException {
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {
			//Se valida que la actualizacion sea a la grua requerida.
			Pageable pageByCodigoDisponibilidadGruaEvento = PageRequest.of(0, 1, Sort.by("codigoGrua").descending());

			Page<GruaVehiculo> pageGruaVehiculo  = factoryArrastrameGruaDAO.getGruaVehiculoRepository().findByCodigoGruaVehiculo(codigoGrua, pageByCodigoDisponibilidadGruaEvento);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreDisponibilidadGruaEvento.idDisponibilidadGruaEvento = id 
							//... solo actualizar estado****/
			if(!pageGruaVehiculo.isEmpty() && pageGruaVehiculo.getContent().get(0).getCodigoGruaVehiculo()==objDisponibilidadGruaEvento.getIdGruaVehiculo().getCodigoGruaVehiculo()){

				factoryArrastrameGruaDAO.getDisponibilidadGruaEventoRepository().save(objDisponibilidadGruaEvento);

				arrastrameGrua.setDisponibilidadGruaEvento(objDisponibilidadGruaEvento);
			}
			else {
				throw new LogicaImplException("No se puede actualizar DisponibilidadGruaEvento, nombreDisponibilidadGruaEvento ya existe en un identificador distinto");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua listarDisponibilidadGruaEventoxActivoDisponibilidadGruaEvento(String codigoPais) throws LogicaImplException {
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		
		try {
			/**** Traer solo activos ****/
			List<GruaVehiculo> listaGruaVehiculoPais = listarGruaVehiculoxIdPaisxEstadoGruaVehiculo(
					new GruaVehiculo(codigoPais, true)).getListaGruaVehiculo(); 
			
			if(listaGruaVehiculoPais!=null) {
			
				List<DisponibilidadGruaEvento> listaDisponibilidadGruaEvento  = factoryArrastrameGruaDAO.getDisponibilidadGruaEventoRepository().
						findByIdGruaVehiculoInAndEstadoDisponibilidadGruaEvento(listaGruaVehiculoPais, true);
				
				/***Si existe reemplazar por el nuevo*/
				if(!listaDisponibilidadGruaEvento.isEmpty()){

					arrastrameGrua.setListaDisponibilidadGruaEvento(listaDisponibilidadGruaEvento);
				
				}else {
					throw new LogicaImplException("No existen DisponibilidadGruaEvento para gruas");
				}
			}else {
				throw new LogicaImplException("No existe DisponibilidadGruaEvento para el pais:" +codigoPais);
			}
			

			
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	/*Buscar disponibilidad de una grua especifica si esta activa*/
	public ArrastrameGrua buscarDisponibilidadGruaEventoxCodigoGrua(DisponibilidadGruaEvento objDisponibilidadGruaEvento) throws LogicaImplException {

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {
			List<GruaVehiculo> listaGruaVehiculoPais = new ArrayList<GruaVehiculo>();

			listaGruaVehiculoPais.add(buscarGruaVehiculoxCodigoGruaVehiculo(objDisponibilidadGruaEvento.getIdGruaVehiculo()).getGruaVehiculo());

			List<DisponibilidadGruaEvento> listaDisponibilidadGruaEvento  = factoryArrastrameGruaDAO.getDisponibilidadGruaEventoRepository().
					findByIdGruaVehiculoInAndEstadoDisponibilidadGruaEvento(listaGruaVehiculoPais, true);

			/***Si existe reemplazar por el nuevo*/
			if(!listaDisponibilidadGruaEvento.isEmpty()){
				//Traer el primero de la lista
				arrastrameGrua.setDisponibilidadGruaEvento(listaDisponibilidadGruaEvento.get(0));

			}else {
				throw new LogicaImplException("No existen DisponibilidadGruaEvento para grua: "+objDisponibilidadGruaEvento.getIdGruaVehiculo().getCodigoGruaVehiculo());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}
	
	/*************************************************************/
	/******EventoAsistencia EventoAsistencia EventoAsistencia ****/
	/*************************************************************/
	
	public ArrastrameGrua generarCodigoEventoAsistencia(EventoAsistencia objEventoAsistencia) throws LogicaImplException {

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			buscarAsistenciaxCodigoAsistencia(objEventoAsistencia.getIdAsistencia());

			buscarDisponibilidadGruaEventoxCodigoGrua(objEventoAsistencia.getIdDisponibilidadGruaEvento());

			EventoAsistencia eventoAsistencia = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findByIdAsistenciaAndIdDisponibilidadGruaEvento(
					objEventoAsistencia.getIdAsistencia(), objEventoAsistencia.getIdDisponibilidadGruaEvento());

			if(eventoAsistencia == null) {
				String codigoEventoAsistencia = zapalaClienteRest.generarCodigoByNumeroByEncodear(new ZapalaRequest(
						ArrastrameGruaUtilidades.crearListaCadenaEventoAsistencia(objEventoAsistencia))).getCodigoGenerado();

				/**Buscar si el codigo existe*/
				Pageable pageByCodigoEventoAsistencia = PageRequest.of(0, 1, Sort.by("codigoEventoAsistencia").descending());

				Page<EventoAsistencia> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findByCodigoEventoAsistencia(
						objEventoAsistencia.getCodigoEventoAsistencia(), pageByCodigoEventoAsistencia);

				if(pageCodigoGruaVehiculo.isEmpty()) {

					objEventoAsistencia.setCodigoEventoAsistencia(codigoEventoAsistencia);

					arrastrameGrua.setEventoAsistencia(objEventoAsistencia);
				}
			}else {
				throw new LogicaImplException("No se puede crear codigo de evento asistencia, datos de validacion erroneos");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}
	
	public ArrastrameGrua crearEventoAsistencia(EventoAsistencia objEventoAsistencia) throws LogicaImplException {
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			Timestamp tsInicial = new Timestamp(new Date().getTime());

			buscarAsistenciaxCodigoAsistencia(objEventoAsistencia.getIdAsistencia());

			buscarDisponibilidadGruaEventoxCodigoGrua(objEventoAsistencia.getIdDisponibilidadGruaEvento());;

			Pageable pageByCodigoEventoAsistencia = PageRequest.of(0, 1, Sort.by("codigoEventoAsistencia").descending());

			Page<EventoAsistencia> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findByCodigoEventoAsistencia(
					objEventoAsistencia.getCodigoEventoAsistencia(), pageByCodigoEventoAsistencia);

			if(pageCodigoGruaVehiculo.isEmpty()) {
				
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEventoAsistencia").descending());

				Page<EventoAsistencia> pageIdEventoAsistencia = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findAll(pageByidDesc);

				Integer idEventoAsistencia = (!pageIdEventoAsistencia.isEmpty()) ? (Integer) pageIdEventoAsistencia.getContent().get(0).getIdEventoAsistencia() + 1 : 1;

				objEventoAsistencia.setIdEventoAsistencia(idEventoAsistencia);

				objEventoAsistencia.setFechaInicioEventoAsistencia(tsInicial);

				factoryArrastrameGruaDAO.getEventoAsistenciaRepository().save(objEventoAsistencia);

				objEventoAsistencia  = buscarEventoAsistenciaxCodigoAsistencia(objEventoAsistencia).getEventoAsistencia();

				crearStatusEventoAsistencia(new StatusEventoAsistencia(tsInicial, objEventoAsistencia));

				arrastrameGrua.setEventoAsistencia(objEventoAsistencia);
			
			}else {
				throw new LogicaImplException("No se puede crear EventoAsistencia, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}

	
	public ArrastrameGrua actualizarEventoAsistencia(String codigoEventoAsistencia, EventoAsistencia objEventoAsistencia)
			throws LogicaImplException {
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();
		
		try {

			Pageable pageByCodigoEventoAsistencia = PageRequest.of(0, 1, Sort.by("codigoEventoAsistencia").descending());

			Page<EventoAsistencia> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findByCodigoEventoAsistencia(
					objEventoAsistencia.getCodigoEventoAsistencia(), pageByCodigoEventoAsistencia);

			if(!pageCodigoGruaVehiculo.isEmpty()) {
				/***Solo cambiar la fecha de fin de evento de disponibilidad ***/
				factoryArrastrameGruaDAO.getEventoAsistenciaRepository().save(objEventoAsistencia);

				objEventoAsistencia  = buscarEventoAsistenciaxCodigoAsistencia(objEventoAsistencia).getEventoAsistencia();

				arrastrameGrua.setEventoAsistencia(objEventoAsistencia);
			
			}else {
				throw new LogicaImplException("No se puede crear EventoAsistencia, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}

	
	public ArrastrameGrua buscarEventoAsistenciaxCodigoAsistencia(EventoAsistencia objEventoAsistencia)
			throws LogicaImplException {

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			buscarAsistenciaxCodigoAsistencia(objEventoAsistencia.getIdAsistencia());

			buscarDisponibilidadGruaEventoxCodigoGrua(objEventoAsistencia.getIdDisponibilidadGruaEvento());;

			Pageable pageByCodigoEventoAsistencia = PageRequest.of(0, 1, Sort.by("codigoEventoAsistencia").descending());

			Page<EventoAsistencia> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findByCodigoEventoAsistencia(
					objEventoAsistencia.getCodigoEventoAsistencia(), pageByCodigoEventoAsistencia);

			if(!pageCodigoGruaVehiculo.isEmpty()) {
				
				arrastrameGrua.setEventoAsistencia(pageCodigoGruaVehiculo.getContent().get(0));
			
			}else {
				throw new LogicaImplException("No se puede crear EventoAsistencia, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}
	
	public ArrastrameGrua buscarEventoAsistenciaxIdNegocio(EventoAsistencia objEventoAsistencia) throws LogicaImplException {

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			Pageable pageByCodigoEventoAsistencia = PageRequest.of(0, 1, Sort.by("idNegocio").descending());

			Page<EventoAsistencia> pageCodigoGruaVehiculo  = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findByIdNegocio(
					objEventoAsistencia.getIdNegocio(), pageByCodigoEventoAsistencia);

			if(!pageCodigoGruaVehiculo.isEmpty()) {
				arrastrameGrua.setEventoAsistencia(pageCodigoGruaVehiculo.getContent().get(0));
			}else {
				/**Si no tiene negocio asociado retornar null*/
				arrastrameGrua.setEventoAsistencia(null);
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}
	
	public ArrastrameGrua listarTodoEventoAsistenciaxTipoAsistencia(EventoAsistencia objEventoAsistencia)
			throws LogicaImplException {

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {

			List<Asistencia> listaAsistencia = listarAsistenciaxTipoAsistencia(objEventoAsistencia.getIdAsistencia()).getListaAsistencia();

			if(listaAsistencia!=null && listaAsistencia.size()>0){

				List<EventoAsistencia> listaEventoAsistencia  = factoryArrastrameGruaDAO.getEventoAsistenciaRepository().findByIdAsistenciaInAndFechaInicioEventoAsistenciaAfter(
						listaAsistencia, objEventoAsistencia.getFechaFinalEventoAsistencia());

				if(listaEventoAsistencia!=null){
					
					arrastrameGrua.setListaEventoAsistencia(listaEventoAsistencia);
				
				}else {
					throw new LogicaImplException("No se puede crear EventoAsistencia, parametros ya existen en identificador valido");
				}

			}else {
				throw new LogicaImplException("No se puede crear EventoAsistencia, disponibilidad grua no existe");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}

	public ArrastrameGrua crearStatusEventoAsistencia(StatusEventoAsistencia objStatusEventoAsistencia) throws LogicaImplException{

		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		//Si no existe fecha declarada, se agrega la fecha
		if(objStatusEventoAsistencia.getFechaStatusEventoAsistencia()==null) {

			objStatusEventoAsistencia.setFechaStatusEventoAsistencia(new Timestamp(new Date().getTime()));
		}

		try {
			//validar  Que existe el id de Negocio;
			buscarEventoAsistenciaxCodigoAsistencia(objStatusEventoAsistencia.getIdEventoAsistencia());

			/**Buscar si existe statusNegocio asociado idNegocio*/
			Pageable pageByCodigoDesc = PageRequest.of(0, 1, Sort.by("idStatusEventoAsistencia").descending());

			Page<StatusEventoAsistencia> pageStatusEventoAsistencia  = factoryArrastrameGruaDAO.getStatusEventoAsistenciaRepository().findByIdEventoAsistencia(
					objStatusEventoAsistencia.getIdEventoAsistencia(), pageByCodigoDesc);
			//IdTipoStatusEventoAsistencia()==3 es el maximo disponible para el flujo
			
			if(pageStatusEventoAsistencia.isEmpty() || pageStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia().getIdTipoStatusEventoAsistencia()<3){
				/**si no existe statusNegocio asociado idNegocio o existe pero el tipo status de negocio es menor que 3, obtener para crear*/
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idStatusEventoAsistencia").descending());

				Page<StatusEventoAsistencia> pageIdStatusEventoAsistencia = factoryArrastrameGruaDAO.getStatusEventoAsistenciaRepository().findAll(pageByidDesc);

				//Si existe status service aumentar en uno el contador.
				Integer idStatusEventoAsistencia = (!pageIdStatusEventoAsistencia.isEmpty()) ? (Integer) pageIdStatusEventoAsistencia.getContent().get(0).getIdStatusEventoAsistencia() + 1 : 1;

//				if(!pageStatusEventoAsistencia.isEmpty() && pageStatusEventoAsistencia.getContent().get(0)!=null && 
//						pageStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia().getIdTipoStatusEventoAsistencia()!= null && 
//						pageStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia().getIdTipoStatusEventoAsistencia()<3) {
//					idTipoStatusEventoAsistencia = ((Integer) pageStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia().getIdTipoStatusEventoAsistencia()<3) ?
//							(Integer) pageStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia().getIdTipoStatusEventoAsistencia()+ 1: null;
					
				Integer idTipoStatusEventoAsistencia = (!pageStatusEventoAsistencia.isEmpty() && pageStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia().getIdTipoStatusEventoAsistencia()<3) ? 
							(Integer) pageStatusEventoAsistencia.getContent().get(0).getIdTipoStatusEventoAsistencia().getIdTipoStatusEventoAsistencia()+ 1 : 1;

				objStatusEventoAsistencia.setIdStatusEventoAsistencia(idStatusEventoAsistencia);

				objStatusEventoAsistencia.setIdTipoStatusEventoAsistencia(new TipoStatusEventoAsistencia(idTipoStatusEventoAsistencia));

				factoryArrastrameGruaDAO.getStatusEventoAsistenciaRepository().save(objStatusEventoAsistencia);

				pageStatusEventoAsistencia  = factoryArrastrameGruaDAO.getStatusEventoAsistenciaRepository().findByIdEventoAsistencia(objStatusEventoAsistencia.getIdEventoAsistencia(), pageByCodigoDesc); 

				arrastrameGrua.setStatusEventoAsistencia(pageStatusEventoAsistencia.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear StatusEventoAsistencia, parametros ya existen en identificador valido");
			}



		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return arrastrameGrua;
	}

	public ArrastrameGrua listarStatusEventoAsistenciaxEventoAsistencia(StatusEventoAsistencia objStatusEventoAsistencia) throws LogicaImplException {
		
		ArrastrameGrua arrastrameGrua = new ArrastrameGrua();

		try {
			//Como la lista es pequeña, obtener ultimo status service por idNegocio... ordenar descendiente para obtener el ultimo
			List<StatusEventoAsistencia> listaStatusEventoAsistencia  = factoryArrastrameGruaDAO.getStatusEventoAsistenciaRepository().findByIdEventoAsistencia(
					objStatusEventoAsistencia.getIdEventoAsistencia());

			/***Busqueda por nombre existe en un tipoStatusEventoAsistencia No existe. o solo existe en el pageNombreTipoStatusEventoAsistencia.idTipoStatusEventoAsistencia = id 
			//... solo actualizar estado****/
			if(listaStatusEventoAsistencia!=null){

				arrastrameGrua.setListaStatusEventoAsistencia(listaStatusEventoAsistencia);
			}
			else {
				throw new LogicaImplException("No existe StatusEventoAsistencia para codigo de negocio:" +objStatusEventoAsistencia.getIdEventoAsistencia().getCodigoEventoAsistencia());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return arrastrameGrua;
	}
	
	public void limpiarCacheLocal() {
		
		
	}
}
