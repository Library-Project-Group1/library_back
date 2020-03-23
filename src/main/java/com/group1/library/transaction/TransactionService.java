package com.group1.library.transaction;

import com.group1.library.product.Product;
import com.group1.library.product.ProductNotFoundException;
import com.group1.library.user.User;
import com.group1.library.user.UserNotFoundException;

public interface TransactionService {

    public void addTransaction(Transaction transaction, User user, Product product) throws TransactionNotSuccesfull;

    public Transaction findTransactionById(Long id) throws TransactionNotFound;

    public Iterable<Transaction> getTransactionByUser(User user) throws UserNotFoundException;

    public Iterable<Transaction> getTransactionByProduct(Product product) throws ProductNotFoundException;

    public Iterable<Transaction> getAll();
}
