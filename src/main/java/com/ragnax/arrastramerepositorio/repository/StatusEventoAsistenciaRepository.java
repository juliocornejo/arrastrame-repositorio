package com.ragnax.arrastramerepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface StatusEventoAsistenciaRepository extends JpaRepository<StatusEventoAsistencia, Integer> {
	
	List<StatusEventoAsistencia> findByIdEventoAsistencia(EventoAsistencia idEventoAsistencia);
	
	@Query("select sea from StatusEventoAsistencia sea where sea.idEventoAsistencia = :idEventoAsistencia")
	Page<StatusEventoAsistencia> findByIdEventoAsistencia(EventoAsistencia idEventoAsistencia, Pageable page);
}
