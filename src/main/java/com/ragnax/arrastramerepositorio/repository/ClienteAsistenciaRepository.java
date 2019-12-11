package com.ragnax.arrastramerepositorio.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.ClienteAsistencia;

public interface ClienteAsistenciaRepository extends JpaRepository<ClienteAsistencia, Integer> {
	
	@Query("select tva from ClienteAsistencia tva where tva.idUsuario = :idUsuario")
	Page<ClienteAsistencia> findByIdUsuario(Integer idUsuario, Pageable page);

}
