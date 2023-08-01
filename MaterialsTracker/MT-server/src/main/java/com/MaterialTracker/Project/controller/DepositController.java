package com.MaterialTracker.Project.controller;

import com.MaterialTracker.Project.dao.JdbcDepositDao;
import com.MaterialTracker.Project.dao.UserDao;
import com.MaterialTracker.Project.model.Deposit;
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
public class DepositController {
    private final UserDao userDao;

    private final JdbcDepositDao jdbcDepositDao;

    public DepositController(UserDao userDao, JdbcDepositDao jdbcDepositDao) {
        this.userDao = userDao;
        this.jdbcDepositDao = jdbcDepositDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public void newDeposit(Principal principal, @Valid @RequestBody Deposit deposit) {
      User userFrom = userDao.findByUsername(principal.getName());

      deposit.setId(userFrom.getId());
       jdbcDepositDao.createDeposit(deposit);
    }

    @RequestMapping(path = "/deposit/search", method = RequestMethod.GET)
    public List<Deposit> getMyDeposits(Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());

        return jdbcDepositDao.getDepositsById(userId);

    }

    @RequestMapping(path = "/deposits/{id}", method = RequestMethod.GET)
    public Deposit getDepositById(Principal principal, @PathVariable int id){
        User userFrom = userDao.findByUsername(principal.getName());
        int userId = userFrom.getId();
        Deposit deposit = jdbcDepositDao.getSpecificDeposit(id, userId);
    if(deposit == null){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
    }else {
        return deposit;
    }
    }


}
