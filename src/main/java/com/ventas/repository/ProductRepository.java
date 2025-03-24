package com.ventas.repository;

import com.ventas.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    @Query(value = "select product.*, count(order_detail.id_order_detail) as vendidos, supplier.*, category.*\n" +
            " from category  join supplier on category.id_category = supplier.id_category\n" +
            " join product on product.id_supplier = supplier.id_supplier left join order_detail on product.id_product = order_detail.id_product\n" +
            " group by product.id_product order by id_product asc;", nativeQuery = true)
    List<Object[]> encontrarProductosVentaDetalle();

    @Modifying
    @Query(value = "update product set stock = stock - :cantidad  where id_product = :id_producto ;", nativeQuery = true)
    void actualizarStockProducto(@Param("cantidad") Integer cantidad, @Param("id_producto") Long id_producto);


    @Query(value= "select sum(cantidad) as cantidad_producto,  product.product_name  from order_detail join\n" +
            " product on order_detail.id_product = product.id_product\n" +
            " group by product.id_product order by cantidad_producto desc limit 10;", nativeQuery = true)
    List<Object[]> consultarTopTenProductosVendidos();

    @Query(value = "select sum(cantidad) as cantidad_producto,  product.product_name  from order_detail join\n" +
            "product on order_detail.id_product = product.id_product\n" +
            "group by product.id_product order by cantidad_producto asc limit 10;", nativeQuery = true)
    List<Object[]> consultarProductosMenosVendidos();
}

