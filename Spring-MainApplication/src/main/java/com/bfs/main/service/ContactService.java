package com.bfs.main.service;

import com.bfs.main.dao.implementation.AddressDao;
import com.bfs.main.dao.implementation.ContactDao;
import com.bfs.main.domain.Address;
import com.bfs.main.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactService {

    private ContactDao contactDao;

    @Autowired
    public void setApplicationWorkFlowDao(ContactDao contactDao){
        this.contactDao = contactDao;
    }

    public List<Contact> getAll(){
        return this.contactDao.getContact();
    }

    public Contact getContactById(int id) {
        return contactDao.getContactById(id);
    }
}
