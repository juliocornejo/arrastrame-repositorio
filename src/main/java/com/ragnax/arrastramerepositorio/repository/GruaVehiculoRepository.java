package com.ragnax.arrastramerepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface GruaVehiculoRepository extends JpaRepository<GruaVehiculo, Integer> {
	
	@Query("select gv from GruaVehiculo gv where gv.codigoGruaVehiculo = :codigoGruaVehiculo")
	Page<GruaVehiculo> findByCodigoGruaVehiculo(String codigoGruaVehiculo, Pageable page);
	
	List<GruaVehiculo> findByIdTipoGruaVehiculo(TipoGruaVehiculo idTipoGruaVehiculo);
	
	List<GruaVehiculo> findByCodigoPaisPortalAndEstadoGruaVehiculo(String codigoPaisPortal, Boolean estadoGruaVehiculo);
	
}
