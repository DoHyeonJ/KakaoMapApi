# KakaoMapApi
Server to Server API

- 카카오맵 API를 Java를 사용한 Server to Server 호출 예제 ( 카테고리별 결과값 )

# 사용법

- application.properties 의 apikey.kakao 에 Kakao Rest API 키 설정
- KakaoMapApiApplication.java:16 의 search 메서드에 경도, 위도, 카테고리 코드, 검색범위(m단위) 순으로 파라미터 넘겨줌

- API 가이드 : https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category
