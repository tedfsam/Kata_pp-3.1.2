package com.kata.crud.pp312.service;

import com.kata.crud.pp312.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();

    public User getOneUser(int id);

    public void saveUser(User user);

    public void updateUser(int id, User user);
    public void deleteUser(int id);
}
