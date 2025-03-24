package com.ventas.repository;

import com.ventas.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    @Query(value = "select city.id_city, city.city_name, count(address.id_address) as address, state.id_state from  state join  city  on state.id_state = city.id_state left join address on city.id_city = address.id_city  group by city.id_city;", nativeQuery = true)
    List<Object[]>  encontrarCiudadDirecciones();

    @Query(value = "select * from city where city.id_state = :id_state", nativeQuery = true)
    List<Object[]> consultarCiudadesPorEstado(@Param("id_state") Long id_state);

}
