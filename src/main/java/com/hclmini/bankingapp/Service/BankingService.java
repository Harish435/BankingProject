package com.hclmini.bankingapp.Service;


import com.hclmini.bankingapp.Dto.AccountDto;
import com.hclmini.bankingapp.Dto.CustomerAccouDto;
import com.hclmini.bankingapp.Dto.CustomersDto;
import com.hclmini.bankingapp.Dto.TransactionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BankingService {

    List<CustomersDto> findAll();

    ResponseEntity<Object> addCustomer(CustomersDto customer);

    CustomersDto getById(Long customerNumber);

    ResponseEntity<Object> updateCustomers(CustomersDto customerdto, Long customerNumber);

    ResponseEntity<Object> deleteCustomers(Long customerNumber);

    ResponseEntity<Object> getbyAccountNumber(Long accountNumber);


    ResponseEntity<Object> addAccount(AccountDto theaccountdto, Long customerNumber);

    ResponseEntity<Object> transferAmount(CustomerAccouDto customerAccouDto, Long customerNumber);

    List<TransactionDto> getByTransationId(Long accountNumber);
}
