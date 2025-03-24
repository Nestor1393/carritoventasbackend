package com.ventas.Service.Impl;

import com.ventas.Service.IOrderDetailService;
import com.ventas.entities.OrderDetail;
import com.ventas.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail guardarOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void eliminarOrderDetail(Long id) {

    }

    @Override
    public Optional<OrderDetail> encontrarOrderDetailPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<OrderDetail> encontrarTodasLasOrderDetail() {
        return null;
    }
}
