package com.ventas.repository;

import com.ventas.entities.State;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository  extends CrudRepository<State, Long> {

    @Query(value = "select state.*, count(address.id_address) as address from state \n" +
            "left join city on state.id_state = city.id_state left join address on city.id_city = address.id_city  group by state.id_state;",
            nativeQuery = true)
    List<Object[]> encontrarEstadosDirecciones();



}
