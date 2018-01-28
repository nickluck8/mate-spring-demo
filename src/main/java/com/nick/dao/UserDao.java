package com.nick.dao;

import com.nick.model.User;

public interface UserDao {
    User addUser(User user);

    User findById(Long id);
}
