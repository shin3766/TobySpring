package com.yoosup.springstudy.domain.user.ch5_service;

/*
정수형 상수 값으로 정의한 사용자 레벨

문제점 :: level의 타입이 인수형이기 때문에 다음처럼 다른 종류의 정보를 넣는 실수를 해도 컴파일러가 체크해주지못한다.
 */
public class User {
    private static final int BASIC = 1;
    private static final int SILVER = 2;
    private static final int GOLD = 3;

    int level;

    public void setLevel(int level) {
        this.level = level;
    }

}
