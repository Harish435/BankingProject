package com.hclmini.bankingapp.Repository;

import com.hclmini.bankingapp.Entity.CostomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepo extends JpaRepository<CostomerAccount ,String> {
}
