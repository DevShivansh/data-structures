package com.vedantu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vedantu.entities.Order;
import com.vedantu.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ApplicationController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping ( method = RequestMethod.GET, value = "/test")
    public ResponseEntity<String> showRunGroups(
        )
    {
        log.info( "It works!! " );
        return new ResponseEntity<String>( "Success" ,HttpStatus.OK );

    }

	@RequestMapping ( method = RequestMethod.GET, value = "/order")
    public ResponseEntity<Object> orderProduct(
    		@RequestParam ( value = "accountId", required = true) int accountId,
    		@RequestParam ( value = "productId", required = true) int productId)
    {
        log.info( "Order request received with Account ID : {} and Product ID : {}", accountId, productId );
        
        Order order = orderService.placeOrder(accountId, productId);
        if( order!= null) {
        	return new ResponseEntity<Object>( order ,HttpStatus.OK );	
        }else {
        	return new ResponseEntity<Object>( "Product is not available in inventory" ,HttpStatus.OK );
        }
        
        

    }


}
