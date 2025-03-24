package com.ventas.controllers;

import com.ventas.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    ICustomerService iCustomerService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/consultar/clientes/react")
    public List<Object[]> consultarClientes(){

        return  iCustomerService.encontrarClientes();
    }
}
