package com.bfs.authentication.service;


import com.bfs.authentication.dao.ContactDao;
import com.bfs.authentication.dao.RoleDao;
import com.bfs.authentication.domain.Contact;
import com.bfs.authentication.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao){
        this.roleDao = roleDao;
    }

    public Role getLast(){
        return this.roleDao.getLastKey();
    }
}
