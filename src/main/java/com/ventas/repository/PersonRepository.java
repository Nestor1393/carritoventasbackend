package com.ventas.repository;

import com.ventas.DTO.PersonDTO;
import com.ventas.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "SELECT * FROM person where id_person = :id_person ;", nativeQuery = true)
    List<Object[]> encontrarPersonDtoPorId(@Param("id_person") Long id_person);

    Optional<Person> findByEmail(String idFacebook);
    Optional<Person> findByIdFacebook(String idFacebook);
    Optional<Person> findByIdGoogle(String idGoogle);


}
