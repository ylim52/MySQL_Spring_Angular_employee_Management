package com.bfs.authentication.service;

import com.bfs.authentication.dao.UserDao;
import com.bfs.authentication.domain.Employee;
import com.bfs.authentication.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getByUsername(String username){
        List<User> users = userDao.findByUsername(username);
        return users;
    }

    public List<User> getByEmail(String email){
        List<User> users = userDao.findByEmail(email);
        return users;
    }

    public List<User> getAll(){
        return this.userDao.getAll();
    }

    public void addUser(User user){
        userDao.addUser(user);
    }

    public User getLastKey(){
        return  userDao.getLastKey();
    }
}
