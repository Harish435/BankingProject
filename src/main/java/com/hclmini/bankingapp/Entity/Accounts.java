package com.hclmini.bankingapp.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Accounts {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ACCT_ID")
    private Long id;

    private Long accountNumber;

    @OneToOne(cascade=CascadeType.ALL)
    private BankDetails bankInformation;

    private String accountStatus;

    private String accountType;

    private Double accountBalance;

    @Temporal(TemporalType.TIME)
    private Date createDateTime;

    @Temporal(TemporalType.TIME)
    private Date updateDateTime;

    public Accounts() {
    }

    public Accounts(Long id, Long accountNumber, BankDetails bankInformation, String accountStatus,
                    String accountType, Double accountBalance,
                    Date createDateTime, Date updateDateTime) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.bankInformation = bankInformation;
        this.accountStatus = accountStatus;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
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

    public BankDetails getBankInformation() {
        return bankInformation;
    }

    public void setBankInformation(BankDetails bankInformation) {
        this.bankInformation = bankInformation;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
