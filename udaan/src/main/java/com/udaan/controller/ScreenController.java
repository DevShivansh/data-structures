package com.udaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udaan.entities.AvailableSeatPayload;
import com.udaan.entities.ReserveSeatPayload;
import com.udaan.entities.Screen;
import com.udaan.service.CheckAvailabiltyService;
import com.udaan.service.ReservationService;
import com.udaan.service.ScreenService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ScreenController {
	
	@Autowired
	private ScreenService screenService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private CheckAvailabiltyService checkAvailabiltyService;
	
	
	//RestController to reserve seat for a screen
	@RequestMapping(value = "/screens/{screenName}/reserve", method = RequestMethod.POST )
	public ResponseEntity<String> reserve(@PathVariable("screenName") String screenName,
			@RequestBody ReserveSeatPayload payload) {
		payload.setScreenName(screenName);
		payload.getSeats().intialiseMap();
		
		// check if seats are available. if yes, reserve the seat
		if (reservationService.reserveSeats(payload)) {
			log.info("Successfully reserved :" + payload);
			return new ResponseEntity<String>("successfully reserved",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Unable to reserve",HttpStatus.BAD_REQUEST);
	}

	//rest controller to add new screen
	@RequestMapping(value = "/screens" , method = RequestMethod.POST  )
	public ResponseEntity<String> addScreen(@RequestBody Screen screen){
		screen.getSeatInfo().getA().initializeSeats();
		screen.getSeatInfo().getB().initializeSeats();
		screen.getSeatInfo().getD().initializeSeats();
		screen.getSeatInfo().setRowsName();
		
		//adding screen into DB
		if( screenService.addScreen(screen)) {
			log.info("Screen added :" + screen);
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to save record",HttpStatus.BAD_REQUEST);
	}
	
	//rest controller to find unreserved seats
	@RequestMapping(value = "/screens/{screenName}/seats" , method  = RequestMethod.GET)
	public ResponseEntity<AvailableSeatPayload> viewUnreservedSeats(@PathVariable("screenName") String screenName,
			@RequestParam("status") String status){
		
		return new ResponseEntity<>(checkAvailabiltyService.checkForAvaibleSeats(screenName, status),HttpStatus.OK);
	}
}
