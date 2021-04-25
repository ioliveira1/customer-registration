package com.ioliveira.customer.repositories;

import com.ioliveira.customer.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Transactional(readOnly = true)
    List<Address> findByCustomerId(final Integer customerId);

}
