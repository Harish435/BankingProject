package com.hclmini.bankingapp.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bank_details")
public class BankDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="BANK_ID")
    private Long id;

    private String branchName;

    private Integer branchCode;

    @OneToOne(cascade=CascadeType.ALL)
    private Address branchAddress;

    private Integer routingNumber;

    public BankDetails() {
    }

    public BankDetails(Long id, String branchName,
                       Integer branchCode, Address branchAddress, Integer routingNumber) {
        this.id = id;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.branchAddress = branchAddress;
        this.routingNumber = routingNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public Address getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Integer getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(Integer routingNumber) {
        this.routingNumber = routingNumber;
    }
}
