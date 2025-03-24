package com.ventas.repository;

import com.ventas.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query(value = "select category.*, count(product.id_product) as productos from category left join supplier on category.id_category = supplier.id_category\n" +
            "left join product on supplier.id_supplier = product.id_supplier group by category.id_category;", nativeQuery = true)
    List<Object[]> encontrarCategoriaProducto();
}
