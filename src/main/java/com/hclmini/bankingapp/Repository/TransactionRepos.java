package com.hclmini.bankingapp.Repository;

import com.hclmini.bankingapp.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepos extends JpaRepository<Transactions,String> {
    public Optional<List<Transactions>> findByAccountNumber(Long accountNumber);

}
