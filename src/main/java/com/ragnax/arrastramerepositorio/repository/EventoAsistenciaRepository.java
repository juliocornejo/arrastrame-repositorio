package com.ragnax.arrastramerepositorio.repository;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface EventoAsistenciaRepository extends JpaRepository<EventoAsistencia, Integer> {
	
	@Query("select ea from EventoAsistencia ea where ea.codigoEventoAsistencia = :codigoEventoAsistencia")
	Page<EventoAsistencia> findByCodigoEventoAsistencia(String codigoEventoAsistencia, Pageable page);
	
	@Query("select ea from EventoAsistencia ea where ea.idNegocio = :idNegocio")
	Page<EventoAsistencia> findByIdNegocio(String idNegocio, Pageable page);
	
	EventoAsistencia findByIdAsistenciaAndIdDisponibilidadGruaEvento(Asistencia IdAsistencia, DisponibilidadGruaEvento IdDisponibilidadGruaEvento);
	
	List<EventoAsistencia> findByIdAsistenciaInAndFechaInicioEventoAsistenciaAfter(List<Asistencia> listaAsistencia, Timestamp fechaInicioEventoAsistencia);
	
	EventoAsistencia findByFechaInicioEventoAsistenciaBetween(Timestamp fechaInicioEventoAsistenciaA, Timestamp fechaInicioEventoAsistenciaB);
	
}
