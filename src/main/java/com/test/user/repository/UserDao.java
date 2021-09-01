package com.test.user.repository;

import java.util.List;


import com.test.user.dto.User;


public interface UserDao {
    List<User> getUser();
    User updateUser(Integer id, User user);
    void deleteUser(int id);
    User saveUser(User user);
    public User getUser(int id);

}
