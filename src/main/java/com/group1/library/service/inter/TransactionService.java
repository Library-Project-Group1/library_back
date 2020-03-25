package com.group1.library.service.inter;

import com.group1.library.entity.Product;
import com.group1.library.entity.Transaction;
import com.group1.library.entity.User;

public interface TransactionService {

    public void addTransaction(Transaction transaction, User user, Product product);

    public void removeTransaction(Transaction transaction);

    public Transaction findTransactionById(Long id);

    public void updateTransaction(Transaction transaction);

    public Iterable<Transaction> getAll();
}
