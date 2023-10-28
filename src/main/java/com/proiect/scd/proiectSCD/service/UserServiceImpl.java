package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }
}
