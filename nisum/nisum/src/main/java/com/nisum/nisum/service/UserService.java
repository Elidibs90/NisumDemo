package com.nisum.nisum.service;

import java.util.List;

import com.nisum.nisum.entity.User;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User save(User user);
    
    User update(User user, long id);

    User deleteById(long id);
}
