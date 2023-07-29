package com.MaterialTracker.Project.dao;

import com.MaterialTracker.Project.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int id);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password);

    boolean create(String username, String password, String fullname);

    User getBalanceByUserId(int id);

    List <User> getUsers();
}
