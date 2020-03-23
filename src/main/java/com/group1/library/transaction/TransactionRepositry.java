package com.group1.library.transaction;

import com.group1.library.product.Product;
import com.group1.library.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositry extends CrudRepository<Transaction,Long> {

    Iterable<Transaction> findTransactionByUser(User user);

    Iterable<Transaction> findTransactionByProduct(Product product);

}
