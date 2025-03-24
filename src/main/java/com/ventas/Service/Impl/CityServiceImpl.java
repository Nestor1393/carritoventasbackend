package com.ventas.Service.Impl;

import com.ventas.Service.ICityService;
import com.ventas.entities.City;
import com.ventas.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CityServiceImpl implements ICityService {


    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> listarAllCity() {
        return  (List<City>) cityRepository.findAll();
    }

    @Override
    public City guardarCity(City city) {
       return cityRepository.save(city);
    }

    @Override
    public Optional<City> encontrarCityPorId(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public List<Object[]> encontrarCiudadDirecciones() {
        return cityRepository.encontrarCiudadDirecciones();
    }

    @Override
    public void eliminarCiudad(Long id) {
        cityRepository.deleteById(id);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveCity(City city) {
        String SQL = "INSERT INTO city (city_name, id_state) VALUES (?, ?)";
        return jdbcTemplate.update(SQL, new Object[]{city.getCity_name(),city.getId_state()});
    }

    @Override
    public List<Object[]> consultarCiudadesPorEstado(Long id_state) {
        return cityRepository.consultarCiudadesPorEstado(id_state);
    }



}
