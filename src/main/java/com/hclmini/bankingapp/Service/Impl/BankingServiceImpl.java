package com.hclmini.bankingapp.Service.Impl;

import com.hclmini.bankingapp.Dto.AccountDto;
import com.hclmini.bankingapp.Dto.CustomerAccouDto;
import com.hclmini.bankingapp.Dto.CustomersDto;
import com.hclmini.bankingapp.Dto.TransactionDto;
import com.hclmini.bankingapp.Entity.*;
import com.hclmini.bankingapp.Repository.AccountRepository;
import com.hclmini.bankingapp.Repository.CustomerAccountRepo;
import com.hclmini.bankingapp.Repository.CustomerRepository;
import com.hclmini.bankingapp.Repository.TransactionRepos;
import com.hclmini.bankingapp.Service.BankingService;
import com.hclmini.bankingapp.Service.Helper.Bankinghelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private Bankinghelper bankinghelper;

    @Autowired
    private AccountRepository  accountRepository;

    @Autowired
    private CustomerAccountRepo customerAccountRepo;

    @Autowired
    private TransactionRepos transactionRepos;

    public BankingServiceImpl(CustomerRepository repository) {
        this.customerRepository=repository;
    }

    @Override
    public List<CustomersDto> findAll() {
        List<CustomersDto> allcustomersList=new ArrayList<>();
        Iterable<Customers> all = customerRepository.findAll();

        all.forEach(customers->{
            allcustomersList.add(bankinghelper.convertToCustomerDto(customers));
        });
        return allcustomersList;
    }

    @Override
    public ResponseEntity<Object> addCustomer(CustomersDto customer) {
        Customers thecustomers=bankinghelper.convertToCustomerEntity(customer);
        thecustomers.setCreadtedDateTime(new Date());
        customerRepository.save(thecustomers);

        return ResponseEntity.status(HttpStatus.CREATED).body("New Customer Created Successfully!!!");
    }

    @Override
    public CustomersDto getById(Long customerNumber) {
        Optional<Customers> customerOpt= customerRepository.findByCustomerNumber(customerNumber);
        if(customerOpt.isPresent()){
           return bankinghelper.convertToCustomerDto(customerOpt.get()) ;
        }
        return null;
    }

    @Override
    public ResponseEntity<Object> updateCustomers(CustomersDto customerdto, Long customerNumber) {
        Optional<Customers> byCustomerNumberopt = customerRepository.findByCustomerNumber(customerNumber);
        Customers customershelper = bankinghelper.convertToCustomerEntity(customerdto);
        if(byCustomerNumberopt.isPresent()){
            Customers managerdentity = byCustomerNumberopt.get();

            if(Optional.ofNullable(customershelper.getCustomercontacts()).isPresent()){
                Contacts customercontacts = managerdentity.getCustomercontacts();
                if(customercontacts!=null){
                    customercontacts.setEmailId(customershelper.getCustomercontacts().getEmailId());
                    customercontacts.setHomePhone(customershelper.getCustomercontacts().getHomePhone());
                    customercontacts.setWorkPhone(customershelper.getCustomercontacts().getWorkPhone());
                }else
                    managerdentity.setCustomercontacts(customershelper.getCustomercontacts());
            }

            if(Optional.ofNullable(customershelper.getCustomercreated()).isPresent()){
                Address customeraddress = managerdentity.getCustomercreated();
                if(customeraddress!=null){
                    customeraddress.setAddress1(customershelper.getCustomercreated().getAddress1());
                    customeraddress.setAddress2(customershelper.getCustomercreated().getAddress2());
                    customeraddress.setCity(customershelper.getCustomercreated().getCity());
                    customeraddress.setCountry(customershelper.getCustomercreated().getCountry());
                    customeraddress.setState(customershelper.getCustomercreated().getState());
                    customeraddress.setZip(customershelper.getCustomercreated().getZip());
                }else
                    managerdentity.setCustomercreated(customershelper.getCustomercreated());
            }

            managerdentity.setUpdateDateTime(new Date());
            managerdentity.setStatus(customershelper.getStatus());
            managerdentity.setFirstName(customershelper.getFirstName());
            managerdentity.setLastName(customershelper.getLastName());
            managerdentity.setMiddleName(customershelper.getMiddleName());
            managerdentity.setUpdateDateTime(new Date());

            customerRepository.save(managerdentity);
            return ResponseEntity.status(HttpStatus.OK).body("Customer Details Updated Successfully");

        }else
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Number Not Found!!!");
    }

    @Override
    public ResponseEntity<Object> deleteCustomers(Long customerNumber) {
        Optional<Customers> managedCustomerEntityOpt = customerRepository.findByCustomerNumber(customerNumber);

        if(managedCustomerEntityOpt.isPresent()) {
            Customers managedCustomerEntity = managedCustomerEntityOpt.get();
            customerRepository.delete(managedCustomerEntity);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success: Customer deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer does not exist.");
        }
    }

    @Override
    public ResponseEntity<Object> getbyAccountNumber(Long accountNumber) {
        Optional<Accounts> AccountNumberoptional = accountRepository.findByAccountNumber(accountNumber);
        if(AccountNumberoptional.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(bankinghelper.convertToAccountDto(AccountNumberoptional.get()));
        }else
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found with Customer AccountNumber");
    }

    @Override
    public ResponseEntity<Object> addAccount(AccountDto theaccountdto, Long customerNumber) {
        Optional<Customers> CustomerNumberoptional = customerRepository.findByCustomerNumber(customerNumber);
        if(CustomerNumberoptional.isPresent()){
            accountRepository.save(bankinghelper.convertToAccountEntity(theaccountdto));

            CostomerAccount c=new CostomerAccount();
            c.setAccountNumber(theaccountdto.getAccountNumber());

            c.setCustomerNumber(customerNumber);

                    customerAccountRepo.save(c);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("New Account Created Successfully");
    }

    @Override
    public ResponseEntity<Object> transferAmount(CustomerAccouDto customerAccouDto, Long customerNumber) {
       List<Accounts> accountentities=new ArrayList<>();
       Accounts fromaccountentity=null;
       Accounts toaccountentity=null;
        Optional<Customers> CustomerNumberoptional = customerRepository.findByCustomerNumber(customerNumber);

        if(CustomerNumberoptional.isPresent()){
            // get FROM ACCOUNT info
            Optional<Accounts> AccountNumberFromoptional = accountRepository.findByAccountNumber(customerAccouDto.getFromAccountNumber());

            if(AccountNumberFromoptional.isPresent()){
                fromaccountentity=AccountNumberFromoptional.get();
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("From Account Number"+customerAccouDto.getFromAccountNumber()+"Not Found");
            }


            Optional<Accounts> toAccountEntityOpt = accountRepository.findByAccountNumber(customerAccouDto.getToAccountNumber());
            if(toAccountEntityOpt.isPresent()){
                toaccountentity=toAccountEntityOpt.get();
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("To Account Number"+customerAccouDto.getToAccountNumber()+"Not Found");

            }

            if(fromaccountentity.getAccountBalance()<customerAccouDto.getTransferAmount()){
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Insufficent Funds!!");
            }else{
                fromaccountentity.setAccountBalance(fromaccountentity.getAccountBalance()-customerAccouDto.getTransferAmount());
                fromaccountentity.setUpdateDateTime(new Date());
                accountentities.add(fromaccountentity);

                toaccountentity.setAccountBalance(toaccountentity.getAccountBalance()+customerAccouDto.getTransferAmount());
                toaccountentity.setUpdateDateTime(new Date());
                accountentities.add(toaccountentity);

                accountRepository.saveAll(accountentities);

                Transactions fromTransaction=bankinghelper.createTransactions(customerAccouDto,
                        fromaccountentity.getAccountNumber(),"Debit");
                transactionRepos.save(fromTransaction);
                Transactions totransaction=bankinghelper.createTransactions(customerAccouDto,
                        toaccountentity.getAccountNumber(),"Credit");
                transactionRepos.save(totransaction);
            }
            return ResponseEntity.status(HttpStatus.OK).body("Successfully transfered for customer number"+customerNumber);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("customer id "+customerNumber+" not found");
        }

    }

    @Override
    public List<TransactionDto> getByTransationId(Long accountNumber) {
        List<TransactionDto> transactondto=new ArrayList<>();
        Optional<Accounts> OptonalAccountNumber = accountRepository.findByAccountNumber(accountNumber);
        if(OptonalAccountNumber.isPresent()){
            Optional<List<Transactions>> transactionentitesopt = transactionRepos.findByAccountNumber(accountNumber);
       if(transactionentitesopt.isPresent()){
           transactionentitesopt.get().forEach(
                   transaction->{
                       transactondto.add(bankinghelper.convertToTransactionDto(transaction));
                   }
           );
       }
        }
        return transactondto;
    }


}
