package com.group1.library.transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositry extends CrudRepository<Transaction,Long> {

}
