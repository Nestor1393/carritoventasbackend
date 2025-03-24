package com.ventas.Service;


import com.ventas.entities.Address;

import java.util.Optional;

public interface IAddressService {

    Address  guardarAddress(Address address);
    void eliminarAddress(Long id);
    Optional<Address> encontrarAddressPorId(Long id);

}
