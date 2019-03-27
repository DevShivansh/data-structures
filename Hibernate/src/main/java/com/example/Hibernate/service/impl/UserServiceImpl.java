package com.example.Hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Hibernate.dao.HibernateDAO;
import com.example.Hibernate.entities.User;
import com.example.Hibernate.service.UserService;


@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private HibernateDAO userDao;
    
    @Transactional
    @Override
    public User findUser(User login) {
        // TODO Auto-generated method stub
        List<User> results = userDao.findByUserNameAndPassword(login);
        if ( results.size() == 1 ) {
            return results.get(0);
        }
        return null;
    }
}
