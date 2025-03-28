package com.ventas.controllers;

import com.ventas.Service.ICategoryService;
import com.ventas.Service.IProductService;
import com.ventas.Service.ISupplierService;
import com.ventas.entities.Category;
import com.ventas.entities.Product;
import com.ventas.entities.Supplier;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductResController {

    @Autowired
    private ISupplierService iSupplierService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IProductService iProductService;

    //CONSULTAR TOP TEN DE PRODUCTOS MÁS VENDIDOS

    @CrossOrigin(origins = {"http://localhost:3000/","https://carritoventasfrontend-production.up.railway.app"})
    @GetMapping("/consultar/productos/mas/vendidos")
    public List<Object[]> consultarTopTenProductosVendidos(){

        return iProductService.consultarTopTenProductosVendidos();
    }

//=========================================================
    //CONSULTAR TOP TEN DE PRODUCTOS MENOS VENDIDOS

    @CrossOrigin(origins = {"http://localhost:3000/","https://carritoventasfrontend-production.up.railway.app"})
    @GetMapping("/consultar/productos/menos/vendidos")
    public List<Object[]> consultarProductosMenosVendidos(){

        return iProductService.consultarProductosMenosVendidos();
    }

    //=========================================================
    //CONSULTAR TODOS LOS PRODUCTOS DESDE REACT
    @CrossOrigin(origins = {"http://localhost:3000/","https://carritoventasfrontend-production.up.railway.app"})
    @GetMapping("/consultar/todos/productos/react")
    public List<Product> encontrarProductosReact(){

        return  iProductService.encontrarTodosLosProductos();

    }

    @GetMapping("/consultar/categorias")
    public List<Category> obtenerCategorias(){

       return iCategoryService.encontrarTodasLasCategorias();
    }

    @PostMapping(path = "/actualizar/producto", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> actualizarProducto(Product  producto){

        Product productoGuardado = null;
        productoGuardado =   iProductService.guardarProducto(producto);
        String respuesta = "";

      if(productoGuardado != null){
          respuesta = "Producto actualizado correctamente";
      }else{
          respuesta = "No se puedo guardar el producto";
      }

        return ResponseEntity.ok(respuesta);
    }


    @GetMapping("/consultar/todos/proveedores")
    public List<Object[]> obtenerProveedores(){

        return iSupplierService.obtenerProveedores();
    }

    @GetMapping("/consultar/proveedores")
    public List<Object[]> obteberProveedoresPorCategoria(@RequestParam("idCategoria") Long idCategoria){

        return iSupplierService.obteberProveedoresPorCategoria(idCategoria);
    }

    @GetMapping("/consultar/productos/detalleventa")
    public List<Object[]> encontrarProductosVentaDetalle(){

        return iProductService.encontrarProductosVentaDetalle();
    }



    @DeleteMapping("/eliminar/producto")
    public ResponseEntity<String> eliminarProducto(@RequestParam("idProducto") Long idProducto){

        iProductService.eliminarProducto(idProducto);

       Optional<Product> product = iProductService.encontrarProductoPorId(idProducto);
        String mensajeRespuesta = "";
        if(product.isEmpty()){
            mensajeRespuesta  = "El Producto fue eliminado correctamente";
        }else{
            mensajeRespuesta  = "El Producto no fue eliminado";
        }

        return ResponseEntity.ok(mensajeRespuesta);
    }

}
