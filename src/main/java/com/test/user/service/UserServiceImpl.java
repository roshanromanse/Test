
package com.test.user.service;

import com.test.user.dto.User;
import com.test.user.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;


@Service("userService")
public class UserServiceImpl implements UserService {
	
    private UserDao userDao;
    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public List<User> getUser() {
        return userDao.getUser();
    }
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    public User saveUser(User user) {
    	return userDao.saveUser(user);
    }
    @Transactional
    public User updateUser(Integer id, User user) {
    	return userDao.updateUser(id, user);
    }

        @Override
        @Transactional
        public void deleteUser(int id) {
            userDao.deleteUser(id);
        }

       
}


