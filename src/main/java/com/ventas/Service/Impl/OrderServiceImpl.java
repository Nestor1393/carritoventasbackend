package com.ventas.Service.Impl;

import com.ventas.Service.IOrderService;
import com.ventas.entities.Order;
import com.ventas.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order guardarOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void eliminarOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> encontrarOrderPorId(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> encontrarTodasLasOrder() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Object[] encontrarFolioActual() {
        return orderRepository.encontrarFolioActual();
    }

    @Override
    public List<Object[]> encontrarOrderPorFecha(String fechaInicio, String fechaFin) {
        return orderRepository.encontrarOrderPorFecha(fechaInicio, fechaFin);
    }

    @Override
    public List<Object[]> encontrarDetalleVenta(Integer idVenta) {
        return orderRepository.encontrarDetalleVenta(idVenta);
    }

    @Override
    public List<Object[]> encontrarVentasPorMes() {
        return orderRepository.encontrarVentasPorMes();
    }

    @Override
    public List<Object[]> encontrarProductosVendidosPorMes(Integer idMes) {
        return orderRepository.encontrarProductosVendidosPorMes(idMes);
    }

    @Override
    public List<Object[]> encontrarTopTresProductosMasVendidosPorMes(Integer idMes) {
        return orderRepository.encontrarTopTresProductosMasVendidosPorMes(idMes);
    }

    @Override
    public List<Object[]> encontrarProductoMasVendidoPorMes(Integer idMes) {
        return orderRepository.encontrarProductoMasVendidoPorMes(idMes);
    }
}
