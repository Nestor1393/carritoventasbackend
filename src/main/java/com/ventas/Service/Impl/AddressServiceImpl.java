package com.ventas.Service.Impl;

import com.ventas.Service.IAddressService;
import com.ventas.entities.Address;
import com.ventas.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address guardarAddress(Address address) {
       return addressRepository.save(address);
    }

    @Override
    public void eliminarAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Optional<Address> encontrarAddressPorId(Long id) {

       return addressRepository.findById(id);
    }
}
