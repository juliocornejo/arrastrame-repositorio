package com.ragnax.arrastramerepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface TipoAsistenciaRepository extends JpaRepository<TipoAsistencia, Integer> {
	
	
	@Query("select tvc from TipoAsistencia tvc where tvc.nombreTipoAsistencia = :nombreTipoAsistencia")
	Page<TipoAsistencia> findByNombreTipoAsistencia(String nombreTipoAsistencia, Pageable page);
	
	List<TipoAsistencia> findAll();
	
	
}
