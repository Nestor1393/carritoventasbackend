package com.ventas.Service;

import com.fasterxml.jackson.datatype.jdk8.OptionalSerializer;
import com.ventas.entities.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    Order guardarOrder(Order order);

    void eliminarOrder(Long id);

    Optional<Order> encontrarOrderPorId(Long id);

    List<Order> encontrarTodasLasOrder();

    Object[] encontrarFolioActual();

    List<Object[]> encontrarOrderPorFecha(String fechaInicio, String fechaFin);

    List<Object[]> encontrarDetalleVenta(Integer idVenta);

    List<Object[]> encontrarVentasPorMes();

    List<Object[]> encontrarProductosVendidosPorMes(Integer idMes);

    List<Object[]> encontrarTopTresProductosMasVendidosPorMes(Integer idMes);

    List<Object[]> encontrarProductoMasVendidoPorMes(Integer idMes);
}
