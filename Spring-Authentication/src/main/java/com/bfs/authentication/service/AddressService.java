package com.bfs.authentication.service;


import com.bfs.authentication.dao.AddressDao;
import com.bfs.authentication.domain.Address;
import com.bfs.authentication.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService {

    private AddressDao addressDao;

    @Autowired
    public void setApplicationWorkFlowDao(AddressDao addressDao){
        this.addressDao = addressDao;
    }

    public List<Address> getAll(){
        return this.addressDao.getAll();
    }

    public Employee updateAddress(Employee employee) {
        return addressDao.updateAddress(employee);
    }

    public void addAddress(Address address){
        this.addressDao.addAddress(address);
    }
}
