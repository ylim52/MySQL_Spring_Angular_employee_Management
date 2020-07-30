package com.bfs.main.service;

import com.bfs.main.dao.implementation.UserDao;
import com.bfs.main.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setApplicationWorkFlowDao(UserDao userDao){
        this.userDao = userDao;
    }

    public List<User> getAll(){
        return this.userDao.getAll();
    }

    public List<User> getByUsername(String username){
        List<User> users = userDao.findByUsername(username);
        return users;
    }

    public List<User> getByEmail(String email){
        List<User> users = userDao.findByEmail(email);
        return users;
    }

}
