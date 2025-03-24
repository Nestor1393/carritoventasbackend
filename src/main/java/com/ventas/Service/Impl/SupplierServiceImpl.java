package com.ventas.Service.Impl;

import com.ventas.Service.ISupplierService;
import com.ventas.entities.Supplier;
import com.ventas.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Supplier guardarProveedor(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void eliminarProveedor(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Optional<Supplier> encontrarProveedorPorId(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> encontrarTodosLosProveedores() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public List<Object[]> obteberProveedoresPorCategoria(Long id_categoria) {
        return supplierRepository.obteberProveedoresPorCategoria(id_categoria);
    }

    @Override
    public List<Object[]> obtenerProveedores() {
        return supplierRepository.obtenerProveedores();
    }

    @Override
    public List<Object[]> obtenerTodosProveedores() {
        return supplierRepository.obtenerTodosProveedores();
    }
}
