package com.hclmini.bankingapp.Dto;


import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomersDto {
    @NotNull(message = "First Name Should Not Empty.")
    private String firstName;
    @NotNull(message = "Last Name Should Not Empty.")
    private String lastName;

    private String middleName;
    @NotNull(message = "customerNumber Should Not Empty.")
    private Long customerNumber;

    private String status;

    private AddressDto customerAddress;

    private ContactDto contactDetails;

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
}
