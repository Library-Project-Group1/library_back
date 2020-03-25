package com.group1.library.repository;

import com.group1.library.entity.Product;
import com.group1.library.entity.Transaction;
import com.group1.library.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositry extends CrudRepository<Transaction,Long> {

    Iterable<Transaction> findTransactionByUser(User user);

    Iterable<Transaction> findTransactionByProduct(Product product);

}
