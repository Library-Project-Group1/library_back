package com.group1.library.restcontroller;

import com.group1.library.product.Product;
import com.group1.library.product.ProductNotFoundException;
import com.group1.library.user.User;
import com.group1.library.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiTransaction")
public class TransactionRestController {

    //ATTRIBUTES
    @Autowired
    private TransactionServiceImpl transactionService;

    //METHODS
    @PostMapping(value = "/createTransaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createTransaction(@RequestBody @Valid Transaction transaction, @RequestBody @Valid User user, @RequestBody @Valid Product product){
        try {
            this.transactionService.addTransaction(transaction, user, product);
        }catch (TransactionNotSuccesfull e){
            e.printStackTrace();
        }
    }

    @GetMapping("/transaction/{id}")
    public Transaction findTransactionById(@PathVariable("id") Long id) {
        try{
            return this.transactionService.findTransactionById(id);
        }catch (TransactionNotFound e){
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

    @GetMapping("/allTransaction")
    public Iterable<Transaction> getAll() {
        return this.transactionService.getAll();
    }
}
