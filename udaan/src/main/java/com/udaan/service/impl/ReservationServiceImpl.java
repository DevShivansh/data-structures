package com.udaan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udaan.entities.ReserveSeatPayload;
import com.udaan.entities.ScreenDB;
import com.udaan.entities.SeatDB;
import com.udaan.repository.ScreenRepository;
import com.udaan.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ScreenRepository screenRepository;

	@Override
	public boolean reserveSeats(ReserveSeatPayload payload) {
		
		// fetching screen id with help of screen name
		ScreenDB screenDB = screenRepository.findScreenByName(payload.getScreenName());
		
		Map<String, int[]> seatMap = payload.getSeats().getSeatMap();
		
		// check if seat is free , if yes, add record with returning true value else return false
		if (isFreeSeatAvail(seatMap, screenDB)) {
			return bookSeats(seatMap, screenDB);
		}

		return false;
	}
	
	public boolean bookSeats(Map<String, int[]> seatMap, ScreenDB screenDB) {
		
		for (Entry<String, int[]> entry : seatMap.entrySet()) {
			String key = entry.getKey();
			int[] seats = entry.getValue();
			
			for (int i = 0; i < seats.length; i++) {
				screenRepository.reserveSeat(screenDB.getId(), key, seats[i]);
			}
		}
		
		return true;
	}

	public boolean isFreeSeatAvail(Map<String, int[]> seatMap, ScreenDB screenDB) {
		for (Entry<String, int[]> entry : seatMap.entrySet()) {
			String key = entry.getKey();
			int[] seats = entry.getValue();
			List<SeatDB> freeSeats = screenRepository.findUnreservedSeats(screenDB.getId(), key);
			List<Integer> freeSeatsNums = new ArrayList<>();
			for (SeatDB seat : freeSeats) {
				freeSeatsNums.add(seat.getSeatNo());
			}
			for (int i = 0; i < seats.length; i++) {
				if (!freeSeatsNums.contains(seats[i]))
					return false;
			}
		}
		return true;
	}
}
