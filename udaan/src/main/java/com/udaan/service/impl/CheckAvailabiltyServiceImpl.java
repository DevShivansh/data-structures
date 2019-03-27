package com.udaan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udaan.entities.AvailableSeat;
import com.udaan.entities.AvailableSeatPayload;
import com.udaan.entities.ScreenDB;
import com.udaan.entities.SeatDB;
import com.udaan.repository.ScreenRepository;
import com.udaan.service.CheckAvailabiltyService;

@Service
public class CheckAvailabiltyServiceImpl implements CheckAvailabiltyService{

	@Autowired
	private ScreenRepository screenRepository;
	
	@Override
	public AvailableSeatPayload checkForAvaibleSeats(String screenName, String status) {
		// TODO Auto-generated method stub
		// fetching screen id with help of screen name
		ScreenDB screenDB = screenRepository.findScreenByName(screenName);
		List<SeatDB> freeSeatsRowA = screenRepository.findUnreservedSeats(screenDB.getId(),"A");
		List<SeatDB> freeSeatsRowB = screenRepository.findUnreservedSeats(screenDB.getId(),"B");
		List<SeatDB> freeSeatsRowC = screenRepository.findUnreservedSeats(screenDB.getId(),"D");
		int[] A = new int[freeSeatsRowA.size()];
		int[] B = new int[freeSeatsRowB.size()];
		int[] C = new int[freeSeatsRowC.size()];
		
		for(int i=0;i<A.length;i++) {
			A[i] = freeSeatsRowA.get(i).getSeatNo();
		}
		
		for(int i=0;i<B.length;i++) {
			B[i] = freeSeatsRowB.get(i).getSeatNo();
		}
		
		for(int i=0;i<C.length;i++) {
			C[i] = freeSeatsRowC.get(i).getSeatNo();
		}
		AvailableSeat availableSeat = new AvailableSeat(A, B, C);
		AvailableSeatPayload payload = new AvailableSeatPayload(availableSeat);
		
		return payload;
	}

}
