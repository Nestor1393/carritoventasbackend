package com.ventas.Service;

import com.ventas.DTO.PersonDTO;
import com.ventas.entities.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPersonService {

    Person guardarPersona(Person person);

    void eliminarPersona(Long id);

    Optional<Person> encontrarPersonPorId(Long id);

    List<Object[]> encontrarPersonDtoPorId(Long id_person);

    List<Person> encontrarTodasLasPersonas();

    Optional<Person> findByEmail(String idFacebook);
    Optional<Person> findByIdFacebook(String idFacebook);
    Optional<Person> findByIdGoogle(String idGoogle);
}
