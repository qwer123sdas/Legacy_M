package com.homework.travelclub.vo;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class MileageLogVO {
	@Type(type = "uuid-char")
	private String pointId;
	
	private int point;

	private String userId;
	private String reviewId;

	private char type;
	private String comment;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime inserted;
	
	
	public MileageLogVO() {
		
	}
	public MileageLogVO(int point, String comment, char type, String userId, String reviewId) {
		this.pointId = UUID.randomUUID().toString();
		this.point = point;
		this.comment = comment;
		this.type = type;
		this.userId = userId;
		this.reviewId = reviewId;
	}
	

}
