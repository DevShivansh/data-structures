package com.udaan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDB {
	
	private int id;
	private int seatNo;
	private int screenId;
	private String row;
	private String status;
	private String aisle;

}
