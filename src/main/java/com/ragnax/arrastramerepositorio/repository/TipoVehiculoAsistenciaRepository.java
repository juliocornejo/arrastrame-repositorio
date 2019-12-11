package com.ragnax.arrastramerepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface TipoVehiculoAsistenciaRepository extends JpaRepository<TipoVehiculoAsistencia, Integer> {
	
	
	@Query("select tva from TipoVehiculoAsistencia tva where tva.nombreTipoVehiculoAsistencia = :nombreTipoVehiculoAsistencia")
	Page<TipoVehiculoAsistencia> findByNombreTipoVehiculoAsistencia(String nombreTipoVehiculoAsistencia, Pageable page);
	
	List<TipoVehiculoAsistencia> findAll();
	
	
}
