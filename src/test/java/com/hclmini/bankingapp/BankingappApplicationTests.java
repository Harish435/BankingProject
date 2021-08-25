package com.hclmini.bankingapp;

import com.hclmini.bankingapp.Entity.Address;
import com.hclmini.bankingapp.Entity.Contacts;
import com.hclmini.bankingapp.Entity.Customers;
import com.hclmini.bankingapp.Repository.CustomerRepository;
import com.hclmini.bankingapp.Service.BankingService;
import com.hclmini.bankingapp.Service.Helper.Bankinghelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankingappApplicationTests {

    @Autowired
    private BankingService bankingService;
    @Autowired
    private Bankinghelper bankinghelper;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void getCustomersTests() {
        Customers c=new Customers();
        c.setId(101L);
       c.setFirstName("RAju");
        c.setMiddleName("m");
        c.setLastName("J");
        c.setCustomerNumber(101L);
        c.setStatus("Active");
        c.setUpdateDateTime(new Date());
        Contacts contacts=new Contacts(101L,"hh@gmail.com","88974521","789425631");
        Address address=new Address(101L,"hhnn jjkjj","tuiytjhg hjhj","xyz","MUM","56502","ind");
        c.setCustomercontacts(contacts);
        c.setCustomercreated(address);

        when(customerRepository.findAll()).thenReturn(Stream.of(c).collect(Collectors.toList()));
        assertEquals(1,bankingService.findAll().size());
    }

    @Test
    public void addCustomerTest(){
        Customers c=new Customers();
        c.setId(101L);
        c.setFirstName("RAju");
       c.setMiddleName("m");
       c.setLastName("J");
        c.setStatus("Active");
        c.setUpdateDateTime(new Date());
        Contacts contacts=new Contacts(101L,"hh@gmail.com","88974521","789425631");
        Address address=new Address(101L,"hhnn jjkjj","tuiytjhg hjhj","xyz","MUM","56502","ind");
        c.setCustomercontacts(contacts);
        c.setCustomercreated(address);

        when(customerRepository.save(c)).thenReturn(c);
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("New Customer Created Successfully!!!")
                ,bankingService.addCustomer(bankinghelper.convertToCustomerDto(c)));
    }

    @Test
    public void deleteCustomers(){
        Customers c=new Customers();
        c.setId(101L);
        c.setFirstName("RAju");
        c.setMiddleName("m");
        c.setLastName("J");
        c.setStatus("Active");
        c.setUpdateDateTime(new Date());
        Contacts contacts=new Contacts(101L,"hh@gmail.com","88974521","789425631");
        Address address=new Address(101L,"hhnn jjkjj","tuiytjhg hjhj","xyz","MUM","56502","ind");
        c.setCustomercontacts(contacts);
        c.setCustomercreated(address);

        bankingService.deleteCustomers(c.getCustomerNumber());
        verify(customerRepository,times(1)).findByCustomerNumber(c.getCustomerNumber());
    }

}
