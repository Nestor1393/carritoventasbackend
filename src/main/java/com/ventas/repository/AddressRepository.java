package com.ventas.repository;

import com.ventas.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository  extends CrudRepository<Address, Long> {
}
