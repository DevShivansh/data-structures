package com.example.Hibernate.dao;

import java.util.List;

import com.example.Hibernate.entities.User;

public interface HibernateDAO
{

    List<User> findByUserNameAndPassword( User user );

}
