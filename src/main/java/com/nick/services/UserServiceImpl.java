package com.nick.services;

import com.nick.dao.UserDao;
import com.nick.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserDao userDao;


    @Override
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRegisterDate(LocalDateTime.now());
        userDao.addUser(user);
        user = userDao.findById(user.getId());
        return user;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
