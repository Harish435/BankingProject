package com.hclmini.bankingapp.Repository;

import com.hclmini.bankingapp.Entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long> {
    Optional<Accounts> findByAccountNumber(Long accountNumber);
}
