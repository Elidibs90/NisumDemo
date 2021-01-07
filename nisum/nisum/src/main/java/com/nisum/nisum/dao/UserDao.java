package com.nisum.nisum.dao;

import java.util.List;

import com.nisum.nisum.entity.User;




public interface UserDao {

    public List<User> findAll();

    public User findById(int id);

    public void save(User user);

    public void deleteById(int id);
}
