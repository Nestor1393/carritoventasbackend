package com.ventas.controllers;

import com.ventas.Service.ICategoryService;
import com.ventas.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;


    //================(ENDPOINT PARA REGISTRAR UNA CATEGORIA MEDIANTE REACT) =================

    @CrossOrigin(origins = "http://localhost:5173")
    @RequestMapping(value = "/guardar/categoria/react", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object[]> registrarCategoriaReact(Model model, @RequestBody Map<String, String> body) {

        String nombreCategoria = body.get("nombreCategoria");

        Category category = new Category();
        category.setCategory_name(nombreCategoria);
        Category categoriaGuardada = null;
        categoriaGuardada = iCategoryService.guardarCategoria(category);

        Map<String, String> respuesta = new HashMap<>();
        Map<String, Object> categorias = new HashMap<>();
        Object[] lista = new Object[2];

        if (categoriaGuardada != null) {

            respuesta.put("respuesta", "La categoria se registró correctamente");
            categorias.put("categoriasLista", iCategoryService.encontrarTodasLasCategorias());

            lista[0] = respuesta;
            lista[1] = categorias;

        } else {
            respuesta.put("respuesta", "La categoria no pudo ser registrada");

            lista[0]= respuesta;
        }

        return ResponseEntity.ok(lista);
    }

    //=========================================================================================

    @GetMapping("/consultar/todas/categorias")
    public List<Object[]> encontrarCategoriaProductos(){

        return  iCategoryService.encontrarCategoriaProducto();

    }

    //============================================================================================
    //CONSULTAR TODAS LAS CATEGORIAS DESDE REACT
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/consultar/todas/categorias/react")
    public List<Category> encontrarCategoriasReact(){

        return  iCategoryService.encontrarTodasLasCategorias();

    }

    @PostMapping(path = "/actualizar/categoria", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> actualizarCategoria( Category category){
        String respuesta = "";

        Category categoriaGuardada = null;
        categoriaGuardada =iCategoryService.guardarCategoria(category);

        if(categoriaGuardada != null){
            respuesta = "La Categoria se actualizó correctamente";
        }else{
            respuesta = "La Categoria no se pudo actualizar";
        }
        return ResponseEntity.ok(respuesta);
    }


    @DeleteMapping("/eliminar/categoria")
    public ResponseEntity<String> eliminarCategoria(@RequestParam("idCategoria") Long idCategoria){
        String mensaje = "";

        iCategoryService.eliminarCategoria(idCategoria);

        Optional<Category> categoriaBuscada = iCategoryService.encontrarCategoriaPorId(idCategoria);

        if(categoriaBuscada.isEmpty()){
            mensaje = "La Categoria fue eliminada correctamente";
        }else{
            mensaje = "La Categoria no fue eliminda";
        }

        return ResponseEntity.ok(mensaje);
    }

    //===================================================================================
    //CONSULTAR CATEGORIA POR ID

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping ("/consultar/categoria/id")
    public ResponseEntity<Category> consultarCategoriaPorId(@RequestParam("idCategoria") Long idCategoria){

        Category categoria = null;
        Optional<Category> categoriaBuscada = iCategoryService.encontrarCategoriaPorId(idCategoria);

        if(categoriaBuscada.isPresent()){
            categoria = categoriaBuscada.get();
        }

        return ResponseEntity.ok(categoria);
    }

    //=====================================================================================
    //ELIMINAR CATEGORIA DESDE REACT
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/eliminar/categoria/react/{idCategoria}")
    public ResponseEntity<Object> eliminarCategoriaReact(@PathVariable Long idCategoria){
        String mensaje = "";
        Map<String, Object> respuesta = new HashMap<>();

        iCategoryService.eliminarCategoria(idCategoria);

        Optional<Category> categoriaBuscada = iCategoryService.encontrarCategoriaPorId(idCategoria);

        if(categoriaBuscada.isEmpty()){
            mensaje = "La Categoria fue eliminada correctamente";

            respuesta.put("mensaje",mensaje);
            respuesta.put("categorias", iCategoryService.encontrarTodasLasCategorias());

        }else{
            mensaje = "La Categoria no fue eliminda";
            respuesta.put("mensaje",mensaje);
            respuesta.put("categorias", null);

        }

        return ResponseEntity.ok(respuesta);
    }

    //===============================================================================
    //ACTUALIZAR

    @CrossOrigin(origins = "http://localhost:5173")
    @RequestMapping(value = "/actualizar/categoria/react", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> actualizarCategoriaReact(Model model, @RequestBody Map<String, String> body) {

        String nombreCategoria = body.get("nombreCategoria");
        long idCategoria = Long.parseLong(body.get("idCategoria"));

        Category category = new Category();
        category.setCategory_name(nombreCategoria);
        category.setId_category(idCategoria);
        Category categoriaGuardada = null;
        categoriaGuardada = iCategoryService.guardarCategoria(category);

        Map<String, Object> respuesta = new HashMap<>();

        if (categoriaGuardada != null) {

            respuesta.put("respuesta", "La categoria se actualizó correctamente");
            respuesta.put("categoriasLista", iCategoryService.encontrarTodasLasCategorias());

        } else {
            respuesta.put("respuesta", "La categoria no pudo ser registrada");
            respuesta.put("categoriasLista", iCategoryService.encontrarTodasLasCategorias());

        }

        return ResponseEntity.ok(respuesta);
    }
}
