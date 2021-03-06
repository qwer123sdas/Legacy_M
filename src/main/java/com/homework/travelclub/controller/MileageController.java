package com.homework.travelclub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homework.travelclub.service.MileageService;
import com.homework.travelclub.vo.MileageResponseVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor 
public class MileageController {
	private final MileageService service;
	
	@GetMapping("mileages/{userId}")
	public ResponseEntity<MileageResponseVO> showMileages(@PathVariable String userId, 
							    @RequestParam(name="page",defaultValue="0") int page) {
		
		MileageResponseVO response = service.selectMileageByUserId(userId, page);
		return ResponseEntity.ok().body(response);
		
	}
}
