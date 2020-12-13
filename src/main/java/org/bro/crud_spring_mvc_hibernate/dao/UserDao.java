package org.bro.crud_spring_mvc_hibernate.dao;

import org.bro.crud_spring_mvc_hibernate.models.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void editUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
