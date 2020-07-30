package com.bfs.authentication.service;


import com.bfs.authentication.dao.UserRoleDao;
import com.bfs.authentication.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserRoleService {

    private UserRoleDao userRoleDao;

    @Autowired
    public void setApplicationWorkFlowDao(UserRoleDao userRoleDao){
        this.userRoleDao = userRoleDao;
    }

    public List<UserRole> getAll(){
        return this.userRoleDao.getAll();
    }

    public List<UserRole> getByUserId(Integer ID){
        return this.userRoleDao.getByUserID(ID);
    }

    public void addUserRole(UserRole userRole){
        this.userRoleDao.addUserRole(userRole);
    }

}
