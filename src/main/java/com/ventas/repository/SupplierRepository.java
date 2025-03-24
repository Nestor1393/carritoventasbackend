package com.ventas.repository;

import com.ventas.entities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    @Query(value = "select * from supplier where supplier.id_category = :id_categoria", nativeQuery = true)
    List<Object[]> obteberProveedoresPorCategoria(@Param("id_categoria") Long id_categoria);

    @Query(value = "select * from supplier", nativeQuery = true)
    List<Object[]> obtenerProveedores();

    @Query(value = "select supplier.*, count(product.id_product) productos_asingados from supplier left join \n" +
            "product on product.id_supplier = supplier.id_supplier group by supplier.id_supplier;", nativeQuery = true)
    List<Object[]> obtenerTodosProveedores();

}
