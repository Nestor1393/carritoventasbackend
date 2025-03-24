package com.ventas.Service.Impl;

import com.ventas.DTO.PersonDTO;
import com.ventas.Service.IPersonService;
import com.ventas.entities.Person;
import com.ventas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person guardarPersona(Person person) {
       return personRepository.save(person);
    }

    @Override
    public void eliminarPersona(Long id) {
    personRepository.deleteById(id);
    }

    @Override
    public Optional<Person> encontrarPersonPorId(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Object[]> encontrarPersonDtoPorId(Long id_person) {
        return personRepository.encontrarPersonDtoPorId(id_person);
    }


    @Override
    public List<Person> encontrarTodasLasPersonas() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> findByEmail(String idFacebook) {
        return personRepository.findByEmail(idFacebook);
    }

    @Override
    public Optional<Person> findByIdFacebook(String idFacebook) {
        return personRepository.findByIdFacebook(idFacebook);
    }

    @Override
    public Optional<Person> findByIdGoogle(String idGoogle) {
        return personRepository.findByIdGoogle(idGoogle);
    }


}
