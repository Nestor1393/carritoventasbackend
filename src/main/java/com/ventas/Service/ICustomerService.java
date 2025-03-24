package com.ventas.Service;

import com.ventas.entities.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Customer guardarCustomer(Customer customer);

    void eliminarCustomer(Long id);

    Optional<Customer> encontrarCustomerPorId(Long id);

    List<Customer> encontrarTodosLosCustomers();

    List<Object[]> encontrarTodosLosClientesCompletos();

    List<Object[]>  encontrarClientes();
}
