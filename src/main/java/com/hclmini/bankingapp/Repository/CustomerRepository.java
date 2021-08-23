package com.hclmini.bankingapp.Repository;

import com.hclmini.bankingapp.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customers,String> {
    Optional<Customers> findByCustomerNumber(Long customerNumber);
}
