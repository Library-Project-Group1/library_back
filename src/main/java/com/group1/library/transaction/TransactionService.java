package com.group1.library.transaction;

import com.group1.library.product.Product;
import com.group1.library.user.User;

public interface TransactionService {

    public void addTransaction(Transaction transaction, User user, Product product);

    public void removeTransaction(Transaction transaction);

    public Transaction findTransactionById(Long id);

    public void updateTransaction(Transaction transaction);

    public Iterable<Transaction> getAll();
}
