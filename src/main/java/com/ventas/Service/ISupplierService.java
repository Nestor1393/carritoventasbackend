package com.ventas.Service;

import com.ventas.entities.Supplier;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {

    Supplier guardarProveedor(Supplier supplier);

    void eliminarProveedor(Long id);

    Optional<Supplier> encontrarProveedorPorId(Long id);

    List<Supplier> encontrarTodosLosProveedores();

    List<Object[]> obteberProveedoresPorCategoria(Long id_categoria);

    List<Object[]> obtenerProveedores();

    List<Object[]> obtenerTodosProveedores();

}
