package com.ventas.Service.Impl;

import com.ventas.Service.ICategoryService;
import com.ventas.entities.Category;
import com.ventas.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Category guardarCategoria(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> encontrarCategoriaPorId(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> encontrarTodasLasCategorias() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public List<Object[]> encontrarCategoriaProducto() {
        return categoryRepository.encontrarCategoriaProducto();
    }
}
