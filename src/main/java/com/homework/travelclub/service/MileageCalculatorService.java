package com.homework.travelclub.service;

import org.springframework.stereotype.Service;

import com.homework.travelclub.mapper.MileageMapper;
import com.homework.travelclub.vo.MileageLogVO;
import com.homework.travelclub.vo.ReviewRequestVO;

import lombok.RequiredArgsConstructor;
import static com.homework.travelclub.infrastructure.Constants.POINT_A;
import static com.homework.travelclub.infrastructure.Constants.POINT_D;
import static com.homework.travelclub.infrastructure.Constants.ADD_CONTENT;
import static com.homework.travelclub.infrastructure.Constants.ADD_PHOTO;
import static com.homework.travelclub.infrastructure.Constants.DELETE_PHOTO;
import static com.homework.travelclub.infrastructure.Constants.FIRST_REIVEW;
import static com.homework.travelclub.infrastructure.Constants.DELETE_REIVEW;

@Service
@RequiredArgsConstructor 
public class MileageCalculatorService { // 서비스
	private final MileageMapper mapper;
	
	// 총합 포인트 계산
	public int calculateSumPoint(String userId) {
		return mapper.selectSumMileageByUserId(userId);
	}
	
	
	// content 포인트 추가
	public void addContentPoint(ReviewRequestVO request) {
		MileageLogVO mileage = new MileageLogVO(1, ADD_CONTENT, POINT_A, request.getUserId(), request.getReviewId());
		mapper.insertReviewPoint(mileage);
	}
	
	
	// 사진 포인트 추가
	public void addPhotoPoint(ReviewRequestVO request) {
		MileageLogVO mileage = new MileageLogVO(1, ADD_PHOTO, POINT_A, request.getUserId(), request.getReviewId());
		mapper.insertReviewPoint(mileage);
	}
	// 사진을 0개로 수정하여, 포인트 -1 추가
	public void deletePhotoPoint(ReviewRequestVO request) {
		MileageLogVO mileage = new MileageLogVO(-1, DELETE_PHOTO, POINT_D, request.getUserId(), request.getReviewId());
		mapper.insertReviewPoint(mileage);
	}

	
	//첫번째 리뷰이므로 포인트 추가
	public void addFirstReviewPoint(ReviewRequestVO request) {
		MileageLogVO mileage = new MileageLogVO(1, FIRST_REIVEW, POINT_A, request.getUserId(), request.getReviewId());
		mapper.insertReviewPoint(mileage);
	}

	// 리뷰 삭제 시, 해당 장소의 리뷰의 총포인트를 마이너스로 추가
	public void deleteReviewPoint(ReviewRequestVO request) {
		int sum =calculateSumPoint(request.getUserId());
		MileageLogVO mileage = new MileageLogVO(-1 * sum, DELETE_REIVEW, POINT_D, request.getUserId(), request.getReviewId());
		mapper.insertReviewPoint(mileage);
	}
}
