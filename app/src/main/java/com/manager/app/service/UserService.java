package com.manager.app.service;

import com.manager.app.model.User;

import java.util.List;


public interface UserService{

    int delete(List<User> users);

    User findUserById(Long id);

    User findUserByName(String name);

    List<User> getAllUsers();

    void insertUser(User record);

    boolean deleteUserById(Long id);
}
