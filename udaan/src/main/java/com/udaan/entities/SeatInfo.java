package com.udaan.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatInfo {
	
	private Row A;
	private Row B;
	private Row D;
	
	public void setRowsName() {
		A.setRow("A");
		B.setRow("B");
		D.setRow("D");
	}
	
}
