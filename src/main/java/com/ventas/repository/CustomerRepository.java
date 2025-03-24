package com.ventas.repository;

import com.ventas.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "select state.*, city.*, address.*, person.*, customer.*  \n" +
            "from state join city on state.id_state = city.id_state  join address on city.id_city = address.id_city\n" +
            "join person on address.id_address = person.id_address join customer on person.id_person = customer.id_person;", nativeQuery = true)
    List<Object[]> encontrarTodosLosClientesCompletos();


    @Query(value = "select customer.id_customer, person.email, person.first_name, person.last_name from person join customer  on \n" +
            "person.id_person = customer.id_person;", nativeQuery = true)
    List<Object[]>  encontrarClientes();

}
