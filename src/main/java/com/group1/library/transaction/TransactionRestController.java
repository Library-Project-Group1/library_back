package com.group1.library.transaction;

import com.group1.library.product.Product;
import com.group1.library.product.ProductNotFoundException;
import com.group1.library.user.User;
import com.group1.library.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TransactionRestController {

    //ATTRIBUTES
    @Autowired
    private TransactionServiceImpl transactionService;

    //METHODS
    public void createTransaction(Transaction transaction, User user, Product product){
        try {
            this.transactionService.addTransaction(transaction, user, product);
        }catch (TransactionNotSuccesfull e){
            e.printStackTrace();
        }
    }

    public Transaction findTransactionById(Long id) {
        try{
            return this.transactionService.findTransactionById(id);
        }catch (TransactionNotFound e){
            e.printStackTrace();
            return null;
        }
    }

    public Iterable<Transaction> getTransactionByUser(User user) {
        try {
            return this.transactionService.getTransactionByUser(user);
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public Iterable<Transaction> getTransactionByProduct(Product product) {
        try {
            return this.transactionService.getTransactionByProduct(product);
        }catch (ProductNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public Iterable<Transaction> getAll() {
        return this.transactionService.getAll();
    }
}
