package com.bfs.authentication.service;


import com.bfs.authentication.dao.ContactDao;
import com.bfs.authentication.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactService {

    private ContactDao contactDao;

    @Autowired
    public void setContactDao(ContactDao contactDao){
        this.contactDao = contactDao;
    }

    public List<Contact> getAll(){
        return this.contactDao.getContact();
    }

    public void addContact(Contact contact){
        this.contactDao.addContact(contact);
    }

    public void addNewContact(){
        this.contactDao.addNewContact();
    }

    public Contact getLast(){
        return this.contactDao.getLastKey();
    }
}
