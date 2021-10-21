package com.example.test;

import java.util.concurrent.ScheduledThreadPoolExecutor;

// Sports Car 클래스는 Car 클래스를 상속한다.
public class SportsCar extends Car{

    // 선루프가 열려있는지 상태를 나타내는 변수
    private boolean isOpenSunRoof = false;

    public SportsCar(int acceleration, int maxSpeed, int brakeSpeed) {
        super(acceleration, maxSpeed, brakeSpeed);
    }

    // 스포츠카의 선루프를 연다.
    public void openSunRoof() {
        isOpenSunRoof = true;
    }

    // 스포츠카의 선루프를 닫는다.
    public void closeSunRoof() {
        isOpenSunRoof = false;
    }

    // 스포츠카의 선루프 정보를 읽어온다.
    public String getSunRoofInfo() {
        if(isOpenSunRoof) {
            return "선루프를 열었더니 상쾌하다."; }
        else {
            return "선루프는 닫혀있다."; }
    }

    // 부모에게 받은 기능을 그대로 쓰지 않고 재정의 해서 쓰는 것을 오버라이드라고 한다.
    @Override
    public String getCurrentSpeedText() {
        return "스포츠카입니다. " + super.getCurrentSpeedText();
    }
}
