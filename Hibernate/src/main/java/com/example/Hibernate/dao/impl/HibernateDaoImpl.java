package com.example.Hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Hibernate.dao.HibernateDAO;
import com.example.Hibernate.entities.User;


//import com.example.Hibernate.dao.HibernateDAO;

@Repository
public class HibernateDaoImpl implements HibernateDAO
{

    @Autowired
    SessionFactory sessionFactory;
  
  
    protected Session getCurrentSession(){
       return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<User> findByUserNameAndPassword(User user) {
        Session session = getCurrentSession();
        List<User> results = session.createQuery("from User where userName =? and password = ?")
                .setParameter(0, user.getUserName()).setParameter(1, user.getPassword()).list();
        return results;
    }
    
    
    
}
