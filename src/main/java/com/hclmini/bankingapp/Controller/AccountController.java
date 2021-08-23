package com.hclmini.bankingapp.Controller;

import com.hclmini.bankingapp.Dto.AccountDto;
import com.hclmini.bankingapp.Dto.CustomerAccouDto;
import com.hclmini.bankingapp.Dto.TransactionDto;
import com.hclmini.bankingapp.Service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
   private BankingService bankingService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Object> getByAccountNumber(@PathVariable Long accountNumber){
        return bankingService.getbyAccountNumber(accountNumber);
    }

    @PostMapping("/{customerNumber}")
    public ResponseEntity<Object> addAcc(@RequestBody AccountDto theaccountdto,@PathVariable Long customerNumber){
        return bankingService.addAccount(theaccountdto,customerNumber);
    }
    @PutMapping("/transfer/{customerNumber}")
    public ResponseEntity<Object> transferDetails(@RequestBody CustomerAccouDto customerAccouDto
            ,@PathVariable Long customerNumber){
        return  bankingService.transferAmount(customerAccouDto,customerNumber);
    }
    @GetMapping("/transaction/{accountNumber}")
    public List<TransactionDto> getTransactionByAccNumber(@PathVariable Long accountNumber){
        return bankingService.getByTransationId(accountNumber);
    }

}
