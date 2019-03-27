package com.udaan.entities;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveSeat {

	private int[] A;
	private int[] B;
	private int[] D;
	private Map<String, int[]> seatMap ;
	
	public void intialiseMap() {
		seatMap = new HashMap<>();
		if(A!=null)
			seatMap.put("A", A);
		
		if(B!=null)
			seatMap.put("B", B);
		
		if(D!=null)
			seatMap.put("D", D);
	}
}
