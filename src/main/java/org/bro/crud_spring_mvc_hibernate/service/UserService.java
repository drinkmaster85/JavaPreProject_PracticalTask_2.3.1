package org.bro.crud_spring_mvc_hibernate.service;

import org.bro.crud_spring_mvc_hibernate.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void editUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}