package com.ventas.Service;

import com.ventas.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category guardarCategoria(Category category);
    void eliminarCategoria(Long id);
    Optional<Category> encontrarCategoriaPorId(Long id);
    List<Category> encontrarTodasLasCategorias();

    List<Object[]> encontrarCategoriaProducto();
}
