package com.udaan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udaan.entities.Row;
import com.udaan.entities.Screen;
import com.udaan.entities.ScreenDB;
import com.udaan.entities.SeatDB;
import com.udaan.repository.ScreenRepository;
import com.udaan.service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenRepository screenRepository;

	@Override
	public boolean addScreen(Screen screen) {

		//adding screen into screen table
		screenRepository.insertScreenRecord(screen);
		ScreenDB screenDB = screenRepository.findScreenByName(screen.getName());

		//adding seats in Seat table
		addRowSeatsInDb(screen.getSeatInfo().getA(), screenDB.getId());
		addRowSeatsInDb(screen.getSeatInfo().getB(), screenDB.getId());
		addRowSeatsInDb(screen.getSeatInfo().getD(), screenDB.getId());

		return true;
	}

	public void addRowSeatsInDb(Row row, int screenID) {
		for (int i = 0; i < row.getNumberOfSeats(); i++) {
			SeatDB seatDB = new SeatDB();
			seatDB.setScreenId(screenID);
			seatDB.setRow(row.getRow());
			seatDB.setAisle("" + row.getSeats()[i].getAisleSeat());
			seatDB.setSeatNo(row.getSeats()[i].getSeatNo());
			seatDB.setStatus("false");

			screenRepository.insertSeatRecord(seatDB);
		}
	}

}
