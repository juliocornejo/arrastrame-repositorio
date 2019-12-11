package com.ragnax.arrastramerepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface TipoGruaVehiculoRepository extends JpaRepository<TipoGruaVehiculo, Integer> {
	
	
	@Query("select tgv from TipoGruaVehiculo tgv where tgv.nombreTipoGruaVehiculo = :nombreTipoGruaVehiculo")
	Page<TipoGruaVehiculo> findByNombreTipoGruaVehiculo(String nombreTipoGruaVehiculo, Pageable page);
	
	List<TipoGruaVehiculo> findAll();
	
	
}
