package com.homework.travelclub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.homework.travelclub.service.MileageService;
import com.homework.travelclub.vo.MileageResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor 
public class MileageController {
	private final MileageService service;
	
	@GetMapping("mileages/{userId}")
	public ResponseEntity<MileageResponse> showMileages(@PathVariable String userId) {
		//Pageable pageable = PageRequest.of(page, size, Sort.by("inserted").descending());
		//MileageResponse response = service.selectMileageByUserId(userId, pageable);
		
		MileageResponse response = service.selectMileageByUserId(userId);
		return ResponseEntity.ok().body(response);
	}
}
