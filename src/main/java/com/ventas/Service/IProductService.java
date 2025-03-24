package com.ventas.Service;

import com.ventas.entities.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product guardarProducto(Product product);

   void  eliminarProducto(Long id);

   Optional<Product>  encontrarProductoPorId(Long id);

   List<Product> encontrarTodosLosProductos();

    List<Object[]> encontrarProductosVentaDetalle();

    void actualizarStockProducto(Integer cantidad, Long id_producto);

    List<Object[]> consultarTopTenProductosVendidos();

    List<Object[]> consultarProductosMenosVendidos();
}
