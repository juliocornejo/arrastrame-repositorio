package com.ragnax.arrastramerepositorio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragnax.arrastramerepositorio.controller.response.RagnaxError;
import com.ragnax.arrastramerepositorio.entidad.*;
import com.ragnax.arrastramerepositorio.exception.LogicaImplException;
import com.ragnax.arrastramerepositorio.servicio.ArrastrameGruaService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping
public class ArrastrameGruaController {
	
	/****@GetMapping  no soporta Errors****/
	@Autowired
	ArrastrameGruaService factoryArrastrameTripService;

	@GetMapping(value = "${servicio.app.uri.limpiarCache}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void clearAllCaches() {
		factoryArrastrameTripService.limpiarCacheLocal();
	}

	/***************************************************/
	/*************** TipoAsistencia  *******************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Asistencia", response = TipoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAsistencia.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAsistencia>  crearTipoAsistencia(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoAsistencia objTipoAsistencia, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearTipoAsistencia(objTipoAsistencia).getTipoAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Tipo de Asistencia", response = TipoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAsistencia.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAsistencia>  actualizarTipoAsistencia(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoAsistencia objTipoAsistencia,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipoasistencia, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarTipoAsistencia(
				Integer.parseInt(idtipoasistencia), objTipoAsistencia).getTipoAsistencia(),HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Asistencia", response = TipoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAsistencia.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAsistencia>  buscarTipoAsistencia(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipoasistencia)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.buscarTipoAsistencia(
				new TipoAsistencia(Integer.parseInt(idtipoasistencia))).getTipoAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Tipos de Asistencia", response = TipoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAsistencia.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoTipoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoAsistencia>>  listarTodoTipoAsistencia()  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarTodoTipoAsistencia().getListaTipoAsistencia(), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** TipoGruaVehiculo  *****************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Grua Vehiculo", response = TipoGruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoGruaVehiculo.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoGruaVehiculo>  crearTipoGruaVehiculo(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoGruaVehiculo objTipoGruaVehiculo, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearTipoGruaVehiculo(
				objTipoGruaVehiculo).getTipoGruaVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Tipo de Grua Vehiculo", response = TipoGruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoGruaVehiculo.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoGruaVehiculo>  actualizarTipoGruaVehiculo(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoGruaVehiculo objTipoGruaVehiculo,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipoasistencia, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarTipoGruaVehiculo(
				Integer.parseInt(idtipoasistencia), objTipoGruaVehiculo).getTipoGruaVehiculo(),HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Grua Vehiculo", response = TipoGruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoGruaVehiculo.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoGruaVehiculo>  buscarTipoGruaVehiculo(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipoasistencia)  throws LogicaImplException{

		

		return new ResponseEntity<>(factoryArrastrameTripService.buscarTipoGruaVehiculo(
				new TipoGruaVehiculo(Integer.parseInt(idtipoasistencia))).getTipoGruaVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Tipos de Grua Vehiculo", response = TipoGruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoGruaVehiculo.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoTipoGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoGruaVehiculo>>  listarTodoTipoGruaVehiculo()  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarTodoTipoGruaVehiculo().getListaTipoGruaVehiculo(), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** TipoStatusEventoAsistencia ********/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Status Evento Asistencia", response = TipoStatusEventoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoStatusEventoAsistencia.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoStatusEventoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoStatusEventoAsistencia>  crearTipoStatusEventoAsistencia(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoStatusEventoAsistencia objTipoStatusEventoAsistencia, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearTipoStatusEventoAsistencia(
				objTipoStatusEventoAsistencia).getTipoStatusEventoAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Tipo de Status Evento Asistencia", response = TipoStatusEventoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoStatusEventoAsistencia.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoStatusEventoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoStatusEventoAsistencia>  actualizarTipoStatusEventoAsistencia(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoStatusEventoAsistencia objTipoStatusEventoAsistencia,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipostatuseventoasistencia, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarTipoStatusEventoAsistencia(
				Integer.parseInt(idtipostatuseventoasistencia), objTipoStatusEventoAsistencia).getTipoStatusEventoAsistencia(),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Status Evento Asistencia", response = TipoStatusEventoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoStatusEventoAsistencia.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoStatusEventoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoStatusEventoAsistencia>  buscarTipoStatusEventoAsistencia(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipostatuseventoasistencia)  throws LogicaImplException{

		

		return new ResponseEntity<>(factoryArrastrameTripService.buscarTipoStatusEventoAsistencia(
				new TipoStatusEventoAsistencia(Integer.parseInt(idtipostatuseventoasistencia))).getTipoStatusEventoAsistencia(),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Tipos de Status Evento Asistencia", response = TipoStatusEventoAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoStatusEventoAsistencia.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoTipoStatusEventoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoStatusEventoAsistencia>>  listarTodoTipoStatusEventoAsistencia()  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarTodoTipoStatusEventoAsistencia().getListaTipoStatusEventoAsistencia()
				, HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** TipoSuperficieAsistencia ********/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Superficie Asistencia", response = TipoSuperficieAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoSuperficieAsistencia.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoSuperficieAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoSuperficieAsistencia>  crearTipoSuperficieAsistencia(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoSuperficieAsistencia objTipoSuperficieAsistencia, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearTipoSuperficieAsistencia(
				objTipoSuperficieAsistencia).getTipoSuperficieAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Tipo de Superficie Asistencia", response = TipoSuperficieAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoSuperficieAsistencia.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoSuperficieAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoSuperficieAsistencia>  actualizarTipoSuperficieAsistencia(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoSuperficieAsistencia objTipoSuperficieAsistencia,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtiposuperficieasistencia, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarTipoSuperficieAsistencia(
				Integer.parseInt(idtiposuperficieasistencia), objTipoSuperficieAsistencia).getTipoSuperficieAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Superficie Asistencia", response = TipoSuperficieAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoSuperficieAsistencia.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoSuperficieAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoSuperficieAsistencia>  buscarTipoSuperficieAsistencia(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtiposuperficieasistencia)  throws LogicaImplException{

		

		return new ResponseEntity<>(factoryArrastrameTripService.buscarTipoSuperficieAsistencia(
				new TipoSuperficieAsistencia(Integer.parseInt(idtiposuperficieasistencia))).getTipoSuperficieAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Tipo de Superficie de Asistencia", response = TipoSuperficieAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoSuperficieAsistencia.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoTipoSuperficieAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoSuperficieAsistencia>>  listarTodoTipoSuperficieAsistencia()  throws LogicaImplException{

		return new ResponseEntity<>(
				factoryArrastrameTripService.listarTodoTipoSuperficieAsistencia().getListaTipoSuperficieAsistencia()
				, HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** EstadoRuedasVehiculo ********/
	/***************************************************/
	@ApiOperation(value = "Crear Estado de Ruedas del Vehiculo", response = EstadoRuedasVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EstadoRuedasVehiculo.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearEstadoRuedasVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadoRuedasVehiculo>  crearEstadoRuedasVehiculo(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid EstadoRuedasVehiculo objEstadoRuedasVehiculo, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearEstadoRuedasVehiculo(
				objEstadoRuedasVehiculo).getEstadoRuedasVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Estado de Ruedas del Vehiculo", response = EstadoRuedasVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EstadoRuedasVehiculo.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarEstadoRuedasVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadoRuedasVehiculo>  actualizarEstadoRuedasVehiculo(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid EstadoRuedasVehiculo objEstadoRuedasVehiculo,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idestadoruedasvehiculo, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarEstadoRuedasVehiculo(
				Integer.parseInt(idestadoruedasvehiculo), objEstadoRuedasVehiculo).getEstadoRuedasVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Estado de Ruedas del Vehiculo", response = EstadoRuedasVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EstadoRuedasVehiculo.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarEstadoRuedasVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadoRuedasVehiculo>  buscarEstadoRuedasVehiculo(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idestadoruedasvehiculo)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.buscarEstadoRuedasVehiculo(
				new EstadoRuedasVehiculo(Integer.parseInt(idestadoruedasvehiculo))).getEstadoRuedasVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Estado de Ruedas del Vehiculo", response = EstadoRuedasVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EstadoRuedasVehiculo.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoEstadoRuedasVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadoRuedasVehiculo>>  listarTodoEstadoRuedasVehiculo()  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarTodoEstadoRuedasVehiculo().getListaEstadoRuedasVehiculo()
				, HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** ClienteAsistencia  ***********************/
	/***************************************************/
	
	@ApiOperation(value = "Crear Cliente Asistencia", response = ClienteAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ClienteAsistencia.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearClienteAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteAsistencia>  crearClienteAsistencia(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ClienteAsistencia objClienteAsistencia, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearClienteAsistencia(
				objClienteAsistencia).getClienteAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Cliente Asistencia", response = ClienteAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ClienteAsistencia.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarClienteAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteAsistencia>  actualizarClienteAsistencia(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid ClienteAsistencia objClienteAsistencia,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idusuario, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarClienteAsistencia(
				Integer.parseInt(idusuario), objClienteAsistencia).getClienteAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "BuscarCliente Asistencia por id de usuario", response = ClienteAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ClienteAsistencia.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarClienteAsistenciaxIdUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteAsistencia> buscarClienteAsistenciaxIdUsuario(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idusuario)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.buscarClienteAsistenciaxIdUsuario(
				new ClienteAsistencia(Integer.parseInt(idusuario))).getClienteAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Clientes Asistencia", response = ClienteAsistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ClienteAsistencia.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoClienteAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteAsistencia>>  listarTodoClienteAsistencia()  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarTodoClienteAsistencia().getListaClienteAsistencia()
				, HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** GruaVehiculo  ***********************/
	/***************************************************/
	
	@ApiOperation(value = "Crear Grua de Vehiculo", response = GruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = GruaVehiculo.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GruaVehiculo>  crearGruaVehiculo(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid GruaVehiculo objGruaVehiculo, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearGruaVehiculo(
				objGruaVehiculo).getGruaVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Grua de Vehiculo", response = GruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = GruaVehiculo.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GruaVehiculo>  actualizarGruaVehiculo(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid GruaVehiculo objGruaVehiculo,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idUsuarioGruaVehiculo, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarGruaVehiculo(
				Integer.parseInt(idUsuarioGruaVehiculo), objGruaVehiculo).getGruaVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar GruaVehiculo por Codigo de GruaVehiculo", response = GruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = GruaVehiculo.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarGruaVehiculoxCodigoGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GruaVehiculo>  buscarGruaVehiculo(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigogruavehiculo)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.buscarGruaVehiculoxCodigoGruaVehiculo(
				new GruaVehiculo(codigogruavehiculo)).getGruaVehiculo(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar GruaVehiculo por Tipo Grua Vehiculo", response = GruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = GruaVehiculo.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarGruaVehiculoxTipoGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GruaVehiculo>>  listarGruaVehiculoxTipoGruaVehiculo(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipogruaasistencia)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarGruaVehiculoxTipoGruaVehiculo(
				new GruaVehiculo(null, null, new TipoGruaVehiculo(Integer.parseInt(idtipogruaasistencia)))).getListaGruaVehiculo(),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Grua Vehiculo por Id Pais por estado grua vehiculo", response = GruaVehiculo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = GruaVehiculo.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarGruaVehiculoxIdPaisxEstadoGruaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GruaVehiculo>>  listarGruaVehiculoxIdPaisxEstadoGruaVehiculo(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigopais,
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String estadogruavehiculo)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarGruaVehiculoxIdPaisxEstadoGruaVehiculo(
				new GruaVehiculo(codigopais, Boolean.parseBoolean(estadogruavehiculo))).getListaGruaVehiculo() , 
				HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** Asistencia  ***********************/
	/***************************************************/
	
	@ApiOperation(value = "Crear Asistencia", response = Asistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Asistencia.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Asistencia>  crearAsistencia( @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Asistencia objAsistencia, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearAsistencia(
				objAsistencia).getAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Asistencia", response = Asistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Asistencia.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Asistencia>  actualizarAsistencia(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid Asistencia objAsistencia,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoasistencia, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarAsistencia(
				codigoasistencia, objAsistencia).getAsistencia(),HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Asistencia por Codigo de Asistencia", response = Asistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Asistencia.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarAsistenciaxCodigoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Asistencia>  buscarAsistencia(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoasistencia)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.buscarAsistenciaxCodigoAsistencia(
				new Asistencia(codigoasistencia, null)).getAsistencia(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Asistencia por TipoAsistencia", response = Asistencia.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Asistencia.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarAsistenciaxTipoAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Asistencia>> listarAsistenciaxTipoAsistencia(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipoasistencia)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarAsistenciaxTipoAsistencia(
				new Asistencia(new TipoAsistencia(Integer.parseInt(idtipoasistencia)))).getListaAsistencia(), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** DisponibilidadGrua  ***********************/
	/***************************************************/
	
	@ApiOperation(value = "Crear Disponibilidad de Grua", response = DisponibilidadGruaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = DisponibilidadGruaEvento.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearDisponibilidadGruaEvento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DisponibilidadGruaEvento>  crearDisponibilidadGruaEvento(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid DisponibilidadGruaEvento objDisponibilidadGruaEvento, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.crearDisponibilidadGruaEvento(
				objDisponibilidadGruaEvento).getDisponibilidadGruaEvento(), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Disponibilidad Grua Evento", response = DisponibilidadGruaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = DisponibilidadGruaEvento.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarDisponibilidadGruaEvento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DisponibilidadGruaEvento>  actualizarDisponibilidadGrua(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid DisponibilidadGruaEvento objDisponibilidadGruaEvento,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigogrua, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.actualizarDisponibilidadGruaEvento(
				codigogrua, objDisponibilidadGruaEvento).getDisponibilidadGruaEvento(),HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Disponibilidad Grua por Codigo de la Grua", response = DisponibilidadGruaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = DisponibilidadGruaEvento.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarDisponibilidadGruaEventoxCodigoGrua}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DisponibilidadGruaEvento>  buscarDisponibilidadGrua(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigogrua)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.buscarDisponibilidadGruaEventoxCodigoGrua(
				new DisponibilidadGruaEvento(new GruaVehiculo(codigogrua))).getDisponibilidadGruaEvento(), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Disponibilidad Grua Evento por Activo Disponibilidad", response = DisponibilidadGruaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = DisponibilidadGruaEvento.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarDisponibilidadGruaEventoxIdPaisxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DisponibilidadGruaEvento>>  listarDisponibilidadGruaEventoxIdPaisxActivo(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigopais)  throws LogicaImplException{

		return new ResponseEntity<>(factoryArrastrameTripService.listarDisponibilidadGruaEventoxActivoDisponibilidadGruaEvento(
				codigopais).getListaDisponibilidadGruaEvento(), HttpStatus.OK);

	}

}
