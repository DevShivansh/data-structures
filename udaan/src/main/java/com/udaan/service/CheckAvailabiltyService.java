package com.udaan.service;

import com.udaan.entities.AvailableSeatPayload;

public interface CheckAvailabiltyService {

	public AvailableSeatPayload checkForAvaibleSeats(String screenName, String status);
}
