package com.ragnax.arrastramerepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface TipoSuperficieAsistenciaRepository extends JpaRepository<TipoSuperficieAsistencia, Integer> {
	
	
	@Query("select tvc from TipoSuperficieAsistencia tvc where tvc.nombreTipoSuperficieAsistencia = :nombreTipoSuperficieAsistencia")
	Page<TipoSuperficieAsistencia> findByNombreTipoSuperficieAsistencia(String nombreTipoSuperficieAsistencia, Pageable page);
	
	List<TipoSuperficieAsistencia> findAll();
	
	
}
