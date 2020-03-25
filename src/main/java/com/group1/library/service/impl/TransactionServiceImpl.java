package com.group1.library.service.impl;

import com.group1.library.entity.Product;
import com.group1.library.entity.Transaction;
import com.group1.library.repository.ProductRepository;
import com.group1.library.repository.TransactionRepositry;
import com.group1.library.entity.User;
import com.group1.library.repository.UserRepository;
import com.group1.library.service.inter.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    //ATTRIBUTES
    @Autowired
    private TransactionRepositry transactionRepositry;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    //METHODS
    @Override
    public void addTransaction(Transaction transaction, User user, Product product) {
        transaction.setUser(userRepository.getUserByEmail(user.getEmail()));
        transaction.setProduct(productRepository.getProductByTitle(product.getTitle()));
        transactionRepositry.save(transaction);

    }

    @Override
    public void removeTransaction(Transaction transaction) {

    }

    @Override
    public Transaction findTransactionById(Long id) {
        Optional<Transaction> optionalTransaction=this.transactionRepositry.findById(id);
        Transaction transactionToFind=optionalTransaction.get();
        return transactionToFind;
    }

    @Override
    public void updateTransaction(Transaction transaction) {

    }

    @Override
    public Iterable<Transaction> getAll() {
        return null;
    }



}
