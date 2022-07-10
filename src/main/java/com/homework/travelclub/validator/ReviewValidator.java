package com.homework.travelclub.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.homework.travelclub.mapper.PlaceMapper;
import com.homework.travelclub.mapper.ReviewMapper;
import com.homework.travelclub.mapper.UserMapper;
import com.homework.travelclub.vo.ReviewRequest;

import lombok.RequiredArgsConstructor;

import static com.homework.travelclub.infrastructure.Constants.ADD;
import static com.homework.travelclub.infrastructure.Constants.REVIEW_TYPE;

@Service
@RequiredArgsConstructor 
public class ReviewValidator {
	private final UserMapper userMapper;
	private final PlaceMapper placeMapper;
	private final ReviewMapper reviewMapper;
	
	public void validate(ReviewRequest request) {
		// 타입 확인,
		if(!StringUtils.equals(REVIEW_TYPE, request.getType())) {
			throw new IllegalArgumentException("리뷰 타입이 아닙니다.");
		}
		
		// 리뷰 아이디가 없을 때,
		if(StringUtils.isBlank(request.getReviewId())) {
			throw new IllegalArgumentException("리뷰 아이디가 입력되지 않았습니다.");
		}
		// 해당 유저가 존재하지 않을 때,
		if(StringUtils.isBlank(request.getUserId()) || ! userMapper.checkUserId(request) ) {
			throw new IllegalArgumentException("유저가 존재하지 않습니다.");
		}
		
		// 해당 장소가 없을 때,
		if(StringUtils.isBlank(request.getPlaceId()) || ! placeMapper.checkPlaceId(request)) {
			throw new IllegalArgumentException("장소가 존재하지 않습니다.");
		}
		// content가 없을 때
		if(StringUtils.isBlank(request.getContent())) { 
			throw new IllegalArgumentException("컨텐츠가 존재하지 않습니다.");
		}
		
		// 리뷰 중복 체크하기
		if (StringUtils.equals(ADD, request.getAction())) {
			checkDuplication(request);
		}
		
		
	}
	
	// 리뷰 중복 체크하기
	private void checkDuplication(ReviewRequest request) {
		System.out.println(reviewMapper.checkDuplication(request));
		if(reviewMapper.checkDuplication(request)) {
			throw new IllegalArgumentException("이미 작성한 리뷰가 있습니다.");
		}
	}
	

}
