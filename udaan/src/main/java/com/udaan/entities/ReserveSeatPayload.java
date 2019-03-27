package com.udaan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveSeatPayload {

	private ReserveSeat seats;
	private String screenName;
}
