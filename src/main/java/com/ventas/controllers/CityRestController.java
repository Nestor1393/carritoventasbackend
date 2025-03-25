package com.ventas.controllers;

import com.ventas.Service.ICityService;
import com.ventas.Service.IStateService;
import com.ventas.entities.City;
import com.ventas.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
//@CrossOrigin("*")
public class CityRestController {
    @Autowired
   private ICityService iCityService;

    @Autowired
    private IStateService iStateService;


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody City city){
        String respuesta = "";
        /*
        int resultado = iCityService.saveCity(city);

        if(resultado == 1){
            respuesta = "Ciudad eregistrada con exito";
        }

         */
        System.out.println("getCity_name: "+city.getCity_name()+" getId_state: "+city.getId_state().getId_state());

    return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }


    @GetMapping("/consultar/ciudades/estado")
    public List<Object[]> consultarCiudadesPorEstado(@RequestParam("idEstado") Long idEstado){

        return  iCityService.consultarCiudadesPorEstado(idEstado);
    }
    @GetMapping("/consultar/estados/select")
    public List<Object[]> consultarEstados(){

         return iStateService.encontrarEstadosDirecciones();

    }

}
