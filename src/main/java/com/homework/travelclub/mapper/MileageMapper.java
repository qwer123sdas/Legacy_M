package com.homework.travelclub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.homework.travelclub.vo.MileageLog;

@Mapper
public interface MileageMapper {
	// 각 유저의 마일리지 총합계산
	int selectSumMileageByUserId(String userId);
	
	// 리뷰 포인트 적립 & 수정 & 삭제
	void insertReviewPoint(MileageLog mileage);
	
	// 회원 로그 기록 가져오기(Page)
	//Page<MileageLog> findAll(Pageable pageable);
	
	// 회원로그 기록 가져오기(List)
	List<MileageLog> findAll(String userId);
}
