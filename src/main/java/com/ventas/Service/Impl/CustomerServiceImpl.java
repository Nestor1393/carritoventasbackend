package com.ventas.Service.Impl;

import com.ventas.Service.ICustomerService;
import com.ventas.entities.Customer;
import com.ventas.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer guardarCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void eliminarCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> encontrarCustomerPorId(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> encontrarTodosLosCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public List<Object[]> encontrarTodosLosClientesCompletos() {
        return customerRepository.encontrarTodosLosClientesCompletos();
    }

    @Override
    public List<Object[]> encontrarClientes() {
        return  customerRepository.encontrarClientes();
    }

}
