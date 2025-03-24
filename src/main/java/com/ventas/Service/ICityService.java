package com.ventas.Service;

import com.ventas.entities.Address;
import com.ventas.entities.City;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICityService {

    List<City> listarAllCity();

    City guardarCity(City city);

    Optional<City> encontrarCityPorId(Long id);

    List<Object[]>  encontrarCiudadDirecciones();

    void eliminarCiudad(Long id);

    int saveCity(City city);

    List<Object[]> consultarCiudadesPorEstado(Long id_state);

}
