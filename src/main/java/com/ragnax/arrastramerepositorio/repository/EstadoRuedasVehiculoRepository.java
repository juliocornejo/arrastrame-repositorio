package com.ragnax.arrastramerepositorio.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface EstadoRuedasVehiculoRepository extends JpaRepository<EstadoRuedasVehiculo, Integer> {
	
	@Query("select tva from EstadoRuedasVehiculo tva where tva.nombreEstadoRuedasVehiculo = :nombreEstadoRuedasVehiculo")
	Page<EstadoRuedasVehiculo> findByNombreEstadoRuedasVehiculo(String nombreEstadoRuedasVehiculo, Pageable page);
}
