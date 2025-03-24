package com.ventas.Service.Impl;

import com.ventas.Service.IProductService;
import com.ventas.entities.Product;
import com.ventas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product guardarProducto(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void eliminarProducto(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Optional<Product> encontrarProductoPorId(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> encontrarTodosLosProductos() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Object[]> encontrarProductosVentaDetalle() {
        return productRepository.encontrarProductosVentaDetalle();
    }

    @Override
    @Transactional
    public void actualizarStockProducto(Integer cantidad, Long id_producto) {
        productRepository.actualizarStockProducto(cantidad, id_producto);
    }

    @Override
    public List<Object[]> consultarTopTenProductosVendidos() {
        return productRepository.consultarTopTenProductosVendidos();
    }

    @Override
    public List<Object[]> consultarProductosMenosVendidos() {
        return productRepository.consultarProductosMenosVendidos();
    }
}
