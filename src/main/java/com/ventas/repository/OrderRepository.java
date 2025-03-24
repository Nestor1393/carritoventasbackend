package com.ventas.repository;

import com.ventas.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT  LPAD((IFNULL(MAX(id_order), 0) + 1), 6, '0')  as id_max FROM orden;", nativeQuery = true)
    Object[] encontrarFolioActual();

    //@Query(value = "select * from orden where order_date between :fecha_inicio and :fecha_fin ;", nativeQuery = true)
    @Query(value = "SELECT * FROM orden WHERE order_date >= :fecha_inicio AND order_date < DATE_ADD( :fecha_fin , INTERVAL 1 DAY); ;", nativeQuery = true)
    List<Object[]> encontrarOrderPorFecha(@Param("fecha_inicio") String fechaInicio, @Param("fecha_fin") String fechaFin);

    @Query(value = "select p.product_name, od.cantidad, p.price, od.costo as total from\n" +
            " order_detail as od  join product as p on od.id_product = p.id_product \n" +
            " where id_order = :id_venta ;", nativeQuery = true)
    List<Object[]> encontrarDetalleVenta(@Param("id_venta") Integer idVenta);

    @Query(value = "SELECT month(order_date) as mes, count(*) as total_registros\n" +
            "from orden where YEAR(order_date) = YEAR(CURDATE())  group by mes;", nativeQuery = true)
    List<Object[]> encontrarVentasPorMes();

    @Query(value = "select product.product_name, sum(order_detail.cantidad) as suma from order_detail join\n" +
            " orden on order_detail.id_order = orden.id_order join product on product.id_product = order_detail.id_product\n" +
            " where month(orden.order_date) = :id_mes  group by product.id_product order by suma desc ;", nativeQuery = true)
    List<Object[]> encontrarProductosVendidosPorMes(@Param("id_mes") Integer idMes);


    @Query(value = "select distinct sum(order_detail.cantidad) as suma from order_detail join\n" +
            " orden on order_detail.id_order = orden.id_order join product on product.id_product = order_detail.id_product\n" +
            " where month(orden.order_date) = :id_mes  group by product.id_product order by suma desc limit 3;", nativeQuery = true)
    List<Object[]> encontrarTopTresProductosMasVendidosPorMes(@Param("id_mes") Integer idMes);

    @Query(value = "select distinct product.product_name, sum(order_detail.cantidad) as suma from order_detail join\n" +
            " orden on order_detail.id_order = orden.id_order join product on product.id_product = order_detail.id_product\n" +
            " where month(orden.order_date) = :id_mes  group by product.id_product order by suma desc limit 1;", nativeQuery = true)
    List<Object[]> encontrarProductoMasVendidoPorMes(@Param("id_mes") Integer idMes);
}

