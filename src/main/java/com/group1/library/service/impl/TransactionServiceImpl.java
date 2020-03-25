
package com.group1.library.entity.transaction;
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
    public void addTransaction(Transaction transaction, User user, Product product) throws TransactionNotSuccesfull {
        transaction.setUser(userRepository.getUserByEmail(user.getEmail()));
        transaction.setProduct(productRepository.getProductById(product.getId()));
        if(transaction.getUser()==null || transaction.getProduct()==null){
            throw  new TransactionNotSuccesfull();
        }else {
            transactionRepositry.save(transaction);
        }

    }

    @Override
    public Transaction findTransactionById(Long id) throws TransactionNotFound {
        Optional<Transaction> optionalTransaction=this.transactionRepositry.findById(id);
        if(optionalTransaction.isPresent()) {
            Transaction transactionToFind = optionalTransaction.get();
            return transactionToFind;
        }else {
            throw  new TransactionNotFound();
        }
    }

    @Override
    public Iterable<Transaction> getTransactionByUser(User user) throws UserNotFoundException {
        User userToFound=userRepository.getUserByEmail(user.getEmail());
        if (userToFound==null){
            throw new UserNotFoundException();
        }else {
            return this.transactionRepositry.findTransactionByUser(userToFound);
        }
    }

    @Override
    public Iterable<Transaction> getTransactionByProduct(Product product) throws ProductNotFoundException {
        Product productToFound=productRepository.getProductById(product.getId());
        if(productToFound==null){
            throw new ProductNotFoundException();
        }else {
            return this.transactionRepositry.findTransactionByProduct(product);
        }
    }

    @Override
    public Iterable<Transaction> findAllTransactions() {
        return (Iterable<Transaction>) this.transactionRepositry.findAll();
    }


}
