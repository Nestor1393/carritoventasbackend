package com.ventas.controllers;


import com.ventas.Service.ISupplierService;
import com.ventas.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupplierRestController {

    @Autowired
    private ISupplierService iSupplierService;

    @GetMapping("/consultar/proveedores/completos")
    public List<Object[]>  consultarProveedoresCompletos(){

        return  iSupplierService.obtenerTodosProveedores();
    }

    @DeleteMapping("/eliminar/proveedor")
    public ResponseEntity<String>  eliminarProveedor(@RequestParam("idProveedor") Long idProveedor){

        String respuesta = "";

        iSupplierService.eliminarProveedor(idProveedor);
        Optional <Supplier> provedorBuscado = iSupplierService.encontrarProveedorPorId(idProveedor);

        if(provedorBuscado.isEmpty()){
            respuesta = "El Proveedor fue eliminado correctamente";
        }else if (provedorBuscado.isPresent()){
            respuesta = "El Proveedor no pudo ser eliminado";
        }

        return ResponseEntity.ok(respuesta);
    }


@PutMapping(path ="/actualizar/proveedor/{idProveedor}" , consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> actualizarProveedor(@PathVariable Long idProveedor, Supplier proveedor){

        String respuesta = "";

        proveedor.setId_supplier(idProveedor);

        Supplier proveedorGuardado = null;
        proveedorGuardado = iSupplierService.guardarProveedor(proveedor);

        if(proveedorGuardado != null){
            respuesta = "El proveedor se actualizó correctamente";
        }else{

            respuesta = "El proveedor no se pudo actualizar";
        }

        return ResponseEntity.ok(respuesta);
    }
}

