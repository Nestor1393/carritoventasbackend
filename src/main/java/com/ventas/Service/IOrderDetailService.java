package com.ventas.Service;

import com.ventas.entities.OrderDetail;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {

    OrderDetail guardarOrderDetail(OrderDetail orderDetail);

    void eliminarOrderDetail(Long id);

    Optional<OrderDetail> encontrarOrderDetailPorId(Long id);

    List<OrderDetail> encontrarTodasLasOrderDetail();



}
