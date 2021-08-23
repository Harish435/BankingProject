package com.hclmini.bankingapp.Dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountDto {


    private Long accountNumber;

    private BantDto bankInformation;

    private String accountStatus;

    @NotNull(message = "Enter account Type.")
    private String accountType;

    private Double accountBalance;

    private Date accountCreated;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BantDto getBankInformation() {
        return bankInformation;
    }

    public void setBankInformation(BantDto bankInformation) {
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

    public Date getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(Date accountCreated) {
        this.accountCreated = accountCreated;
    }
}
