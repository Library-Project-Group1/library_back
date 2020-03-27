package com.group1.library.service.impl;

import com.group1.library.entity.Product;
import com.group1.library.entity.Transaction;
import com.group1.library.entity.User;
import com.group1.library.exception.notfound.ProductNotFoundException;
import com.group1.library.exception.notfound.TransactionNotFoundException;
import com.group1.library.exception.notfound.UserNotFoundException;
import com.group1.library.exception.notsuccesfull.TransactionNotSuccesfullException;
import com.group1.library.repository.ProductRepository;
import com.group1.library.repository.TransactionRepositry;
import com.group1.library.repository.UserRepository;
import com.group1.library.service.inter.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <code>Class TransactionServiceImpl</code> defines...
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    //ATTRIBUTES
    @Autowired
    private TransactionRepositry transactionRepositry;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addTransaction(Transaction transaction, User user, Product product) throws TransactionNotSuccesfullException {
        transaction.setUser(userRepository.getUserByEmail(user.getEmail()));
        transaction.setProduct(productRepository.getProductById(product.getId()));
        if (transaction.getUser() == null || transaction.getProduct() == null) {
            throw new TransactionNotSuccesfullException();
        } else {
            transactionRepositry.save(transaction);
        }
    }

    @Override
    public Transaction findTransactionById(Long id) throws TransactionNotFoundException {
        Optional<Transaction> optionalTransaction = this.transactionRepositry.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction transactionToFind = optionalTransaction.get();
            return transactionToFind;
        } else {
            throw new TransactionNotFoundException();
        }
    }

    @Override
    public Iterable<Transaction> getTransactionByUser(User user) throws UserNotFoundException {
        User userToFound = userRepository.getUserByEmail(user.getEmail());
        if (userToFound == null) {
            throw new UserNotFoundException();
        } else {
            return this.transactionRepositry.findTransactionByUser(userToFound);
        }
    }

    @Override
    public Iterable<Transaction> getTransactionByProduct(Product product) throws ProductNotFoundException {
        Product productToFound = productRepository.getProductById(product.getId());
        if (productToFound == null) {
            throw new ProductNotFoundException();
        } else {
            return this.transactionRepositry.findTransactionByProduct(product);
        }
    }

    @Override
    public Iterable<Transaction> findAllTransactions() {
        return (Iterable<Transaction>) this.transactionRepositry.findAll();
    }

}
