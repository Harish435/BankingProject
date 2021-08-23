package com.hclmini.bankingapp.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="TX_ID")
    private Long id;

    private Long accountNumber;

    @Temporal(TemporalType.TIME)
    private Date txDateTime;

    private String txType;

    private Double txAmount;

    public Transactions() {
    }

    public Transactions(Long id, Long accountNumber, Date txDateTime, String txType, Double txAmount) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.txDateTime = txDateTime;
        this.txType = txType;
        this.txAmount = txAmount;
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

    public Date getTxDateTime() {
        return txDateTime;
    }

    public void setTxDateTime(Date txDateTime) {
        this.txDateTime = txDateTime;
    }

    public String getTxType() {
        return txType;
    }

    public void setTxType(String txType) {
        this.txType = txType;
    }

    public Double getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(Double txAmount) {
        this.txAmount = txAmount;
    }
}
