package com.homework.travelclub.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.homework.travelclub.vo.ReviewRequest;


@Mapper
public interface UserMapper {
	// 유저 존재하는지 확인
	boolean checkUserId(ReviewRequest requestVO);

}
