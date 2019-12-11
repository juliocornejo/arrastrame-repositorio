package com.ragnax.arrastramerepositorio.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.arrastramerepositorio.entidad.*;

public interface DisponibilidadGruaEventoRepository extends JpaRepository<DisponibilidadGruaEvento, Integer> {
	
	List<DisponibilidadGruaEvento> findByEstadoDisponibilidadGruaEvento(Boolean estadoDisponibilidadGruaEvento);
	
	List<DisponibilidadGruaEvento> findByIdGruaVehiculoInAndEstadoDisponibilidadGruaEvento(List<GruaVehiculo> listaGruaVehiculo, Boolean estadoDisponibilidadGruaEvento);
}
