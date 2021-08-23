package com.hclmini.bankingapp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue
    private Long id;


    private String firstName;

    private String lastName;

    private String middleName;

    private Long customerNumber;

    private String status;

    @Temporal(TemporalType.TIME)
    private Date creadtedDateTime;

    @Temporal(TemporalType.TIME)
    private Date updateDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address customercreated;

    @OneToOne(cascade = CascadeType.ALL)
    private Contacts customercontacts;

    public Customers() {

    }

    public Customers(Long id, String firstName,
                      String lastName, String middleName,  Long customerNumber,
                     String status, Date creadtedDateTime, Date updateDateTime, Address customercreated,
                     Contacts customercontacts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.customerNumber = customerNumber;
        this.status = status;
        this.creadtedDateTime = creadtedDateTime;
        this.updateDateTime = updateDateTime;
        this.customercreated = customercreated;
        this.customercontacts = customercontacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreadtedDateTime() {
        return creadtedDateTime;
    }

    public void setCreadtedDateTime(Date creadtedDateTime) {
        this.creadtedDateTime = creadtedDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Address getCustomercreated() {
        return customercreated;
    }

    public void setCustomercreated(Address customercreated) {
        this.customercreated = customercreated;
    }

    public Contacts getCustomercontacts() {
        return customercontacts;
    }

    public void setCustomercontacts(Contacts customercontacts) {
        this.customercontacts = customercontacts;
    }
}
