package com.udaan.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Row {

	private String row;
	private int numberOfSeats;
	private Seat[] seats;
	private int[] aisleSeats;

	public Row(int numberOfSeats, int[] aisleSeats) {
		this.numberOfSeats = numberOfSeats;
		this.seats = new Seat[numberOfSeats];
		this.aisleSeats = aisleSeats;
		
	}
	
	public void initializeSeats() {
		this.seats = new Seat[numberOfSeats];
		for(int i=0;i<numberOfSeats;i++) {
			seats[i] = new Seat(i,false);
		}
		
		for(int i=0;i<aisleSeats.length;i++) {
			seats[aisleSeats[i]].setAisleSeat(true);
		}
		
	}
}
