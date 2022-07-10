package com.homework.travelclub.vo;

import java.util.List;

import lombok.Data;

@Data
public class MileageResponse {
	private int sum;
	private List<MileageLog> logs;
	
	public MileageResponse(int sum, List<MileageLog> logs) {
		this.sum = sum;
		this.logs = logs;
	}
}
