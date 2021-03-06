package com.group1.library.restcontroller;

import com.group1.library.entity.Product;
import com.group1.library.entity.Transaction;
import com.group1.library.entity.User;
import com.group1.library.exception.notfound.ProductNotFoundException;
import com.group1.library.exception.notfound.TransactionNotFoundException;
import com.group1.library.exception.notfound.UserNotFoundException;
import com.group1.library.exception.notsuccesfull.TransactionNotSuccesfullException;
import com.group1.library.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiTransactions")
public class TransactionRestController {

    //ATTRIBUTES
    @Autowired
    private TransactionServiceImpl transactionService;

    //METHODS
    @PostMapping(value = "/createTransaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createTransaction(@RequestBody @Valid Transaction transaction, @RequestBody @Valid User user, @RequestBody @Valid Product product){
        try {
            this.transactionService.addTransaction(transaction, user, product);
        }catch (TransactionNotSuccesfullException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/transaction/{id}")
    public Transaction findTransactionById(@PathVariable("id") Long id) {
        try{
            return this.transactionService.findTransactionById(id);
        }catch (TransactionNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/transaction/user")
    public Iterable<Transaction> getTransactionByUser(@RequestBody @Valid User user) {
        try {
            return this.transactionService.getTransactionByUser(user);
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/transaction/product")
    public Iterable<Transaction> getTransactionByProduct(@RequestBody @Valid Product product) {
        try {
            return this.transactionService.getTransactionByProduct(product);
        }catch (ProductNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/allTransactions")
    public Iterable<Transaction> findAllransactions() {
        return this.transactionService.findAllTransactions();
    }
}
