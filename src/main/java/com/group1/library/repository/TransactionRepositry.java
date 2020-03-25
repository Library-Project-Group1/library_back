package com.group1.library.repository;

import com.group1.library.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositry extends CrudRepository<Transaction,Long> {

}
