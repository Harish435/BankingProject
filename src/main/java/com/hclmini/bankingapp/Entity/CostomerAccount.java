package com.hclmini.bankingapp.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customeraccount")
public class CostomerAccount {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CUST_ACC_REF_ID")
    private Long id;

    private Long accountNumber;

    private Long customerNumber;

    public CostomerAccount() {
    }

    public CostomerAccount(Long id, Long accountNumber, Long customerNumber) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customerNumber = customerNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }
}
