package com.test.user.service;

import com.test.user.dto.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


public interface UserService {
    List<User> getUser();
    User updateUser(Integer id, User user);

    void deleteUser(int id);
    User saveUser(User user);
    public User getUser(int id);

}

