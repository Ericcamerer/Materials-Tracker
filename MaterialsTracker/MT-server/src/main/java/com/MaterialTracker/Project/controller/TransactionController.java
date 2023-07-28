package com.MaterialTracker.Project.controller;

import com.MaterialTracker.Project.dao.JdbcTransactionDao;
import com.MaterialTracker.Project.dao.UserDao;
import com.MaterialTracker.Project.model.Transaction;
import com.MaterialTracker.Project.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Controller for transactions.
 */
@RestController
public class TransactionController {
    private final UserDao userDao;

    private final JdbcTransactionDao jdbcTransactionDao;

    public TransactionController( UserDao userDao, JdbcTransactionDao jdbcTransactionDao) {
        this.userDao = userDao;
        this.jdbcTransactionDao = jdbcTransactionDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
    public void sendMoney(Principal principal, @Valid @RequestBody Transaction transaction) throws Exception {
      User userFrom = userDao.findByUsername(principal.getName());
      if(transaction.getAmount() > userFrom.getBalance()){
          throw new Exception("You cant send more money than you have!");
      }
      transaction.setFrom_id(userFrom.getId());
       jdbcTransactionDao.createTransaction(transaction);
    }

    @RequestMapping(path = "/transactions", method = RequestMethod.GET)
    public List<Transaction> getMyTransactions(Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());

        return jdbcTransactionDao.getTransactionsById(userId);

    }

    @RequestMapping(path = "/transactions/{id}", method = RequestMethod.GET)
    public Transaction getTransactionById(Principal principal, @PathVariable int id){
        User userFrom = userDao.findByUsername(principal.getName());
        int userId = userFrom.getId();
        Transaction transaction = jdbcTransactionDao.getSpecificTransaction(id, userId);
    if(transaction == null){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
    }else {
        return transaction;
    }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/requestMoney", method = RequestMethod.POST)
    public void requestMoney(Principal principal, @Valid @RequestBody Transaction transaction) throws Exception {
        User userFrom = userDao.findByUsername(principal.getName());
        if(transaction.getAmount() > userFrom.getBalance()){
            throw new Exception("You cant send more money than you have!");
        }
        transaction.setFrom_id(userFrom.getId());
        jdbcTransactionDao.createRequestTransaction(transaction);
    }

    @RequestMapping(path = "/transactions/pending", method = RequestMethod.GET)
    public List<Transaction> getMyPendingTransactions(Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());

        return jdbcTransactionDao.getPendingTransactionsById(userId, 2);

    }
    @RequestMapping(path = "/transactions/accept/{id}", method = RequestMethod.PUT)
    public void acceptPendingTransactions(Principal principal, @PathVariable int id, @RequestBody Transaction transaction){
        User userFrom = userDao.findByUsername(principal.getName());
        transaction.setFrom_id(userFrom.getId());

        jdbcTransactionDao.acceptPendingTransactionsById(transaction, id);
    }

}
