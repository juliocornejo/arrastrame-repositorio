package com.ragnax.arrastramerepositorio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface TipoStatusEventoAsistenciaRepository extends JpaRepository<TipoStatusEventoAsistencia, Integer> {
	
	
	@Query("select tsa from TipoStatusEventoAsistencia tsa where tsa.nombreTipoStatusEventoAsistencia = :nombreTipoStatusEventoAsistencia")
	Page<TipoStatusEventoAsistencia> findByNombreTipoStatusEventoAsistencia(String nombreTipoStatusEventoAsistencia, Pageable page);

	
	
}
