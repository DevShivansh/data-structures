package com.example.Hibernate;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Hibernate.entities.User;
import com.example.Hibernate.service.UserService;

public class Runner
{

    @Autowired
    private UserService userService;
    
    public void run() {
     
        User temp = new User();
        temp.setUserName( "shivansh@infrrd.ai" );
        temp.setPassword( "1234" );
        User user = userService.findUser( temp );
        System.out.println( user );
        
    }
}
