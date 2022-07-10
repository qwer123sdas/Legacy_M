package com.homework.travelclub.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.homework.travelclub.vo.ReviewRequest;

@Mapper
public interface PlaceMapper {
	// 장소 글이 있는지 확인
	boolean checkPlaceId(ReviewRequest requestVO);


	

}
