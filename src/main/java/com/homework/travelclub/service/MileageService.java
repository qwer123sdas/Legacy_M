package com.homework.travelclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homework.travelclub.mapper.MileageMapper;
import com.homework.travelclub.vo.MileageLog;
import com.homework.travelclub.vo.MileageResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class MileageService {
	private final MileageMapper mapper;
	private final MileageCalculatorService calculator;
	
	// 회원 마일리지 확인
	public MileageResponse selectMileageByUserId(String userId, int page) {
		// 총 마일리지 계산
		int sum = calculator.calculateSumPoint(userId);
		// 마일리지 이력사항 가져오기
		List<MileageLog> logs = mapper.findAll(userId, page);
		
		return new MileageResponse(sum, logs);
	}
	

}
