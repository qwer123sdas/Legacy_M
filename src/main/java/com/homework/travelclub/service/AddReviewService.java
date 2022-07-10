package com.homework.travelclub.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homework.travelclub.mapper.ReviewMapper;
import com.homework.travelclub.validator.ReviewValidator;
import com.homework.travelclub.vo.ReviewRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class AddReviewService {
	private final AttachedPhotoService attechedPhotoService;
	private final ReviewValidator reviewValidator;
	private final MileageCalculatorService calcurator;
	private final ReviewMapper reviewMapper;
	
	
	// 리뷰 ADD
	@Transactional
	public void insertReview(ReviewRequest request) {
		// 해당 장소에 이미 작성한 리뷰가 있는지 확인, exception 처리
		// 유저가 있는지 없는지는 비지니스 로직
		reviewValidator.validate(request);
		
		// 첫 리뷰 작성인지 확인
		if(!reviewMapper.selectFirstReview(request.getPlaceId())) {
			// 1포인트 적립
			calcurator.addFirstReviewPoint(request);
		}

		
		// content 작성
		// 1포인트 적립
		calcurator.addContentPoint(request);
		// review 기록
		reviewMapper.insertReview(request);
		

		// 사진 작성
		if(attechedPhotoService.isSatisFiedAddPhoto(request)) {
			attechedPhotoService.insertAttachedPhoto(request);
		}
		
	}
	
	
	
	
	
	
	
}
