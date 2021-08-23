package com.hclmini.bankingapp.Controller;

import com.hclmini.bankingapp.Dto.CustomersDto;
import com.hclmini.bankingapp.Service.BankingService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private BankingService bankingService;

    @GetMapping()
    public List<CustomersDto> getAllCustomers(){
        return bankingService.findAll();
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Object> addCustomer(@RequestBody CustomersDto customer) {
        return bankingService.addCustomer(customer);
    }
    @GetMapping("/{customerNumber}")
    public CustomersDto getBycustomerNum(@PathVariable Long customerNumber){
        return bankingService.getById(customerNumber);
    }
    @PutMapping("/{customerNumber}")
    public ResponseEntity<Object> updateCustomers(@RequestBody CustomersDto customerdto,
                                                  @PathVariable Long customerNumber){
        return bankingService.updateCustomers(customerdto,customerNumber);
    }

    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<Object> deleteCustomers(@PathVariable Long customerNumber){
        return bankingService.deleteCustomers(customerNumber);
    }

}
