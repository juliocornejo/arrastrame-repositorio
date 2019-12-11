package com.ragnax.arrastramerepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
	
	
	@Query("select a from Asistencia a where a.codigoAsistencia = :codigoAsistencia")
	Page<Asistencia> findByCodigoAsistencia(String codigoAsistencia, Pageable page);
	
	List<Asistencia> findByIdTipoAsistencia(TipoAsistencia idTipoAsistencia);
	
}
