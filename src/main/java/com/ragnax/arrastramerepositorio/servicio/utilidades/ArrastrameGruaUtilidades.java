package com.ragnax.arrastramerepositorio.servicio.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.ragnax.arrastramerepositorio.entidad.*;

public class ArrastrameGruaUtilidades {

	public static List<String> crearListaCadenaCodigoGrua(GruaVehiculo objGruaVehiculo){

		List<String> listaCadena = new ArrayList<String>(); 

		String codigoGrua = objGruaVehiculo.getIdTipoGruaVehiculo().getIdTipoGruaVehiculo()+""+
				objGruaVehiculo.getIdUsuarioGruaVehiculo()+ objGruaVehiculo.getCodigoPaisPortal()+
				objGruaVehiculo.getAnhoGruaVehiculo();
		
		codigoGrua = codigoGrua.trim();
		
		codigoGrua = codigoGrua.replace("\\s", "").replace(" ", "");
		
		codigoGrua = codigoGrua.toLowerCase();

		listaCadena.add(codigoGrua);

		return listaCadena;

	}
	
	public static List<String> crearListaCadenaCodigoAsistencia(Asistencia objAsistencia){
//			, String strFormat){

		List<String> listaCadena = new ArrayList<String>(); 
		
		//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.

		String codigoAsistencia =objAsistencia.getIdTipoAsistencia().getIdTipoAsistencia()+""+
				objAsistencia.getIdTipoSuperficieAsistencia().getIdTipoSuperficieAsistencia()+""+ 
				objAsistencia.getIdTipoVehiculoAsistencia().getIdTipoVehiculoAsistencia()+""+
				objAsistencia.getIdClienteAsistencia().getIdUsuario()+""+
				objAsistencia.getIdEstadoRuedasVehiculo().getIdEstadoRuedasVehiculo();
		
		codigoAsistencia = codigoAsistencia.trim();
		codigoAsistencia = codigoAsistencia.replace("\\s", "").replace(" ", "");
		codigoAsistencia = codigoAsistencia.toLowerCase();

		listaCadena.add(codigoAsistencia);
		//String ahoraYYYY_MM_dd_HH_MM_SS= new SimpleDateFormat(strFormat).format(objAsistencia.getFechaRegistroAsistencia());
		return listaCadena;

	}
	
	public static List<String> crearListaCadenaEventoAsistencia(EventoAsistencia objEventoAsistencia){

		List<String> listaCadena = new ArrayList<String>(); 
		
		//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.

		String codigoEventoAsistencia = objEventoAsistencia.getIdAsistencia().getIdAsistencia()+""+
				objEventoAsistencia.getIdDisponibilidadGruaEvento().getIdDisponibilidadGruaEvento();
		
		codigoEventoAsistencia = codigoEventoAsistencia.trim();
		
		codigoEventoAsistencia = codigoEventoAsistencia.replace("\\s", "").replace(" ", "");
		
		codigoEventoAsistencia = codigoEventoAsistencia.toLowerCase();

		listaCadena.add(codigoEventoAsistencia);
		//String ahoraYYYY_MM_dd_HH_MM_SS= new SimpleDateFormat(strFormat).format(objAsistencia.getFechaRegistroAsistencia());
		return listaCadena;

	}
	
	
//	public static String obtenerCodigoGrua(GruaVehiculo objGruaVehiculo){
//
//		try {
//			if(objGruaVehiculo.getIdTipoGruaVehiculo().getIdTipoGruaVehiculo()!=null &&
//					objGruaVehiculo.getIdUsuarioGruaVehiculo()>0 &&
//					objGruaVehiculo.getAnhoGruaVehiculo()>0 && objGruaVehiculo.getPatenteGruaVehiculo()!=null) {
//				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.
//
//				String codigoGrua = objGruaVehiculo.getIdTipoGruaVehiculo().getIdTipoGruaVehiculo()+""+
//						objGruaVehiculo.getIdUsuarioGruaVehiculo()+ objGruaVehiculo.getIdPais()+
//						objGruaVehiculo.getAnhoGruaVehiculo();
//				
//				codigoGrua = codigoGrua.trim();
//				codigoGrua = codigoGrua.replace("\\s", "").replace(" ", "");
//				codigoGrua = codigoGrua.toLowerCase();
//				
//				codigoGrua = Encriptar1_1.generarCodigoByNumeroByEncodear(codigoGrua, objGruaVehiculo.getPatenteGruaVehiculo());
//				
//				return codigoGrua;
//			}
//
//		} catch (Exception e) {
//			return null;
//		}
//
//		return null;
//	}
	
//	public static String obtenerCodigoAsistencia(Asistencia objAsistencia){
//
//		try {
//			if(objAsistencia.getIdTipoAsistencia()!=null && objAsistencia.getIdTipoSuperficieAsistencia() != null
//					&& objAsistencia.getIdTipoVehiculoAsistencia()!=null && objAsistencia.getIdClienteAsistencia()!=null
//					&& objAsistencia.getIdEstadoRuedasVehiculo()!=null){
//				
//				SimpleDateFormat sdf = new SimpleDateFormat();
//				Date tFecha = DateMapper.TimestampToDateUtil(objAsistencia.getFechaRegistroAsistencia());
//				
//				String ahoraYYYY_MM_dd_HH_MM_SS= AppDate.obtenerFechaEnFormato(tFecha, TipoFormatoFecha.DD_MM_YYYY_HH_MM_SS);
//				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.
//
//				String codigoAsistencia =objAsistencia.getIdTipoAsistencia().getIdTipoAsistencia()+""+
//						objAsistencia.getIdTipoSuperficieAsistencia().getIdTipoSuperficieAsistencia()+""+ 
//						objAsistencia.getIdTipoVehiculoAsistencia().getIdTipoVehiculoAsistencia()+""+
//						objAsistencia.getIdClienteAsistencia().getIdUsuario()+""+
//						objAsistencia.getIdEstadoRuedasVehiculo().getIdEstadoRuedasVehiculo();
//				
//				codigoAsistencia = codigoAsistencia.trim();
//				codigoAsistencia = codigoAsistencia.replace("\\s", "").replace(" ", "");
//				codigoAsistencia = codigoAsistencia.toLowerCase();
//				
//				codigoAsistencia = Encriptar1_1.generarCodigoByNumeroByEncodear(codigoAsistencia, ahoraYYYY_MM_dd_HH_MM_SS);
//				
//				return codigoAsistencia;
//			}
//
//		} catch (Exception e) {
//			return null;
//		}
//
//		return null;
//	}
	
//	public static String obtenerCodigoEventoAsistencia(EventoAsistencia objEventoAsistencia){
//
//		try {
//			if(objEventoAsistencia.getIdAsistencia().getIdAsistencia()!=null &&
//					objEventoAsistencia.getIdDisponibilidadGruaEvento().getIdDisponibilidadGruaEvento()>0) {
//				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.
//
//				String codigoEventoAsistencia = objEventoAsistencia.getIdAsistencia().getIdAsistencia()+""+
//						objEventoAsistencia.getIdDisponibilidadGruaEvento().getIdDisponibilidadGruaEvento();
//				
//				codigoEventoAsistencia = codigoEventoAsistencia.trim();
//				
//				codigoEventoAsistencia = codigoEventoAsistencia.replace("\\s", "").replace(" ", "");
//				
//				codigoEventoAsistencia = codigoEventoAsistencia.toLowerCase();
//				
//				codigoEventoAsistencia = Encriptar1_1.generarCodigoByNumero(codigoEventoAsistencia);
//				
//				return codigoEventoAsistencia;
//			}
//
//		} catch (Exception e) {
//			return null;
//		}
//
//		return null;
//	}
	
//	public static String obtenerDetallePago(DetallePago objDetallePago){
//
//		try {
//			if(objDetallePago.getIdTipoMoneda()!=null && objDetallePago.getIdPago().getIdPago() >0) {
//				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.
//				Integer pagoEnCuotas = (objDetallePago.getPagoEnCuotas()) ? 1 : 0; 
//				
//				String codigoDetallePago = objDetallePago.getIdTipoMoneda()+""+pagoEnCuotas+objDetallePago.getIdPago().getIdPago();
//				
//				codigoDetallePago = codigoDetallePago.trim();
//				
//				codigoDetallePago = codigoDetallePago.replace("\\s", "").replace(" ", "");
//				
//				codigoDetallePago = codigoDetallePago.toLowerCase();
//				
//				codigoDetallePago = Encriptar1_1.generarCodigoByNumeroByEncodear(codigoDetallePago, objDetallePago.getIdMedioPago().getCodigoMedioPago());
//				
//				return codigoDetallePago;
//			}
//		} catch (Exception e) {
//			return null;
//		}
//		return null;
//	}

} 
