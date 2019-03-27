package com.udaan.service;

import com.udaan.entities.ReserveSeatPayload;

public interface ReservationService {

	public boolean reserveSeats(ReserveSeatPayload payload);
}
