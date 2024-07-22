package com.yoosup.springstudy.domain.user;

public enum Level {
    BASIC(1), SILVER(2), GOLD(3);

    private final int value;

    Level(int value) {
        this.value = value;
    }

    public int intValue() {     // 값을 가져오는 메서드
        return value;
    }

    public static Level valueOf(int value) {        // 값으로부터 level타입 오브젝트를 가져오도록 만든 스태틱 메서드
        switch(value) {
            case 1: return BASIC;
            case 2: return SILVER;
            case 3: return GOLD;
            default:throw new AssertionError("Unknown value: " + value);
        }
    }
}
