# 트래블 클럽 마일리지 적립 과제

## **기술 스택**
- JAVA 8
- Spring 5
- MySQL(8.0)
- JSP(MyBatis)

</br>

## **실행방법**

```
여기는 뭘 넣지

```
---
   
## **데이터 베이스 구조**

![ERD](./image/ERD2.jpg)


</br>

## **API**
### 포인트 적립요청
```
POST / events

Requset로 오는 데이터를 이용하여 리뷰를 추가/수정/삭제하고 이를 처리된 데이터를 각각의 Reivew, Photo, Point 테이블에 저장합니다.

필요한 데이터가 없거나 리뷰 중복 등, 검증이 필요한 경우, validator을 통해 runtime exception이 일어나도록 했습니다. Response는 모두 ResponseEntity를 통해 처리했습니다.

PK와 FK를 모두 주고 해당 id로만 스캔하였기 때문에, 전체 테이블 스캔이 일어나지 않도록 하였습니다.
```
```
응답 샘플 : 

add review!
modify review!
delete review!

이미 작성한 리뷰가 있습니다.
등등...
```

</br>

### 마일리지 합계 및 조회 페이징
```
GET / mileages/{userId}?page={pageNum}

입력되는 유저 아이디에 맞게 작성된 리뷰 포인트 합산값과 리뷰를 추가/수정/삭제하여 변화된 포인트 내역들을 보여줍니다.
```
```
응답 샘플 : 

{
    "sum": 0,
    "logs": [
        {
            "pointId": "24dd3cca-77d1-49ff-b0ec-f7d6afa61f0b",
            "point": -3,
            "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
            "reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
            "type": "A",
            "comment": "리뷰삭제",
            "inserted": "2022-07-10 16:14:26"
        },
        {
            "pointId": "54fe157b-16e3-4da9-873d-98847fe84c68",
            "point": 1,
            "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
            "reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
            "type": "A",
            "comment": "사진추가",
            "inserted": "2022-07-10 16:14:01"
        },
        {
            "pointId": "b47225ee-67c8-4d4b-99d2-43e7d362cf50",
            "point": -1,
            "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
            "reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
            "type": "A",
            "comment": "사진삭제",
            "inserted": "2022-07-10 16:13:46"
        },
        {
            "pointId": "7c217fd5-4ead-40c8-8cce-bfb0d642222a",
            "point": 1,
            "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
            "reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
            "type": "A",
            "comment": "내용추가",
            "inserted": "2022-07-10 16:13:22"
        },
        {
            "pointId": "9f119ea5-35d4-43c9-b100-7e62d406c15b",
            "point": 1,
            "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
            "reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
            "type": "A",
            "comment": "사진추가",
            "inserted": "2022-07-10 16:13:22"
        },
        {
            "pointId": "cfae6a21-1f8b-494c-be02-fff07a2eb22d",
            "point": 1,
            "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
            "reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
            "type": "A",
            "comment": "첫리뷰",
            "inserted": "2022-07-10 16:13:22"
        }
    ]
}
```
