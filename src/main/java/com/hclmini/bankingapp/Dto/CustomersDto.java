package com.hclmini.bankingapp.Dto;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomersDto {

    @NotEmpty(message = "First Name Required!!")
    private String firstName;
    @NotEmpty(message = "Last Name Required!!")
    private String lastName;

    private String middleName;

    private Long customerNumber;

    @NotNull
    private String status;

    @Valid
    private AddressDto customerAddress;
    @Valid
    private ContactDto contactDetails;

    public CustomersDto() {
    }

    public CustomersDto(
                                String firstName,
            String lastName, String middleName,
            Long customerNumber, @NotNull String status, AddressDto customerAddress, ContactDto contactDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.customerNumber = customerNumber;
        this.status = status;
        this.customerAddress = customerAddress;
        this.contactDetails = contactDetails;
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

    public AddressDto getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(AddressDto customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ContactDto getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDto contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "CustomersDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", customerNumber=" + customerNumber +
                ", status='" + status + '\'' +
                ", customerAddress=" + customerAddress +
                ", contactDetails=" + contactDetails +
                '}';
    }
}
