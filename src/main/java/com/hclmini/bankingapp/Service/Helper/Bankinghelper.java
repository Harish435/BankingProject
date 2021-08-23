package com.hclmini.bankingapp.Service.Helper;

import com.hclmini.bankingapp.Dto.*;
import com.hclmini.bankingapp.Entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bankinghelper {

    public CustomersDto convertToCustomerDto(Customers thecustomers){
     CustomersDto customersDto=new CustomersDto();
         customersDto.setContactDetails(convertToContactDto(thecustomers.getCustomercontacts()));
        customersDto.setCustomerAddress(convertToAddressDto(thecustomers.getCustomercreated()));
           BeanUtils.copyProperties(thecustomers,customersDto);

        return customersDto;

    }
    public Customers convertToCustomerEntity(CustomersDto thecustomersdto){
        Customers customers=new Customers();
      customers.setCustomercontacts(convertToContactEntity(thecustomersdto.getContactDetails()));
      customers.setCustomercreated(convertToAddressEntity(thecustomersdto.getCustomerAddress()));
        BeanUtils.copyProperties(thecustomersdto,customers);
        return customers;
    }
//contact
    public ContactDto convertToContactDto(Contacts thecontact){
        ContactDto contactDto=new ContactDto();
        BeanUtils.copyProperties(thecontact,contactDto);
        return contactDto;
    }

    public Contacts convertToContactEntity(ContactDto thecontactdto){
        Contacts contact=new Contacts();
        BeanUtils.copyProperties(thecontactdto,contact);
        return contact;
    }
//address
    public AddressDto convertToAddressDto(Address theaddd){
        AddressDto addressDto=new AddressDto();
        BeanUtils.copyProperties(theaddd,addressDto);
        return addressDto;
    }

    public Address convertToAddressEntity(AddressDto theaddressdto){
        Address address=new Address();
        BeanUtils.copyProperties(theaddressdto,address);
        return address;
    }

    public AccountDto convertToAccountDto(Accounts accounts) {
       AccountDto accountdto=new AccountDto();
       accountdto.setBankInformation(convertToBankDto(accounts.getBankInformation()));
        BeanUtils.copyProperties(accounts,accountdto);
        return accountdto;
    }

    public Accounts convertToAccountEntity(AccountDto accountDto){
        Accounts account=new Accounts();

        account.setBankInformation(convertToBankEntity(accountDto.getBankInformation()));
        BeanUtils.copyProperties(accountDto,account);
        return account;
    }

    public BantDto convertToBankDto(BankDetails bankDetails) {
        BantDto bantDto=new BantDto();
        bantDto.setBranchAddress(convertToAddressDto(bankDetails.getBranchAddress()));
        BeanUtils.copyProperties(bankDetails,bantDto);
        return bantDto;
    }

    public BankDetails convertToBankEntity(BantDto bankdto){
        BankDetails bankDetails=new BankDetails();
        bankDetails.setBranchAddress(convertToAddressEntity(bankdto.getBranchAddress()));
        BeanUtils.copyProperties(bankdto,bankDetails);
        return bankDetails;
    }

    public Transactions createTransactions(CustomerAccouDto customerAccouDto,
                                           Long accountNumber, String txType) {
        Transactions t=new Transactions();
        t.setAccountNumber(accountNumber);
        t.setTxAmount(customerAccouDto.getTransferAmount());
        t.setTxType(txType);
        t.setTxDateTime(new Date());
        return t;
    }

    public TransactionDto convertToTransactionDto(Transactions transaction) {
        TransactionDto transactionDto=new TransactionDto();
        BeanUtils.copyProperties(transaction,transactionDto);
        return transactionDto;
    }
}
