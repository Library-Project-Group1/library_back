package com.group1.library.service.inter;

import com.group1.library.entity.Product;
import com.group1.library.exception.notfound.ProductNotFoundException;
import com.group1.library.entity.Transaction;
import com.group1.library.entity.User;
import com.group1.library.exception.notfound.TransactionNotFoundException;
import com.group1.library.exception.notfound.UserNotFoundException;
import com.group1.library.exception.notsuccesfull.TransactionNotSuccesfullException;


public interface TransactionService {

    public void addTransaction(Transaction transaction, User user, Product product) throws TransactionNotSuccesfullException, TransactionNotSuccesfullException;

    public Transaction findTransactionById(Long id) throws TransactionNotFoundException, TransactionNotFoundException;

    public Iterable<Transaction> getTransactionByUser(User user) throws UserNotFoundException;

    public Iterable<Transaction> getTransactionByProduct(Product product) throws ProductNotFoundException;

    public Iterable<Transaction> findAllTransactions();
}
