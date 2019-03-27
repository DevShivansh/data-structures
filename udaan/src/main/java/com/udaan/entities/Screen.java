package com.udaan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screen {
	
	private String name;
	private SeatInfo seatInfo;

}
