package com.hclmini.bankingapp.Dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BantDto {

    @NotNull
    private String branchName;

    @NotNull
    private Integer branchCode;

    private AddressDto branchAddress;

    private Integer routingNumber;

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

    public AddressDto getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(AddressDto branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Integer getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(Integer routingNumber) {
        this.routingNumber = routingNumber;
    }
}
