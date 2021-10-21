package com.example.test;

public class Car {
    // 클래스 내부에는 객체가 가져야할 속성 등을 정의할 수 있다. 이를테면 자동차의 가속도, 현재속도, 최고 속도 등이 있을 수 있다.
    // public은 접근지시자, 해당 클래스가 어디서든 접근이 가능하다는 의미, 캡슐화 (encapculation)을 지원하기 위해서 존재

    // 현재속도, 외부로부터 은닉된 데이터, 멤버변수 혹은 필드라고 불림
    private int currentSpeed = 0;

    // 최고속도
    private int maxSpeed = 100;

    // 가속도
    private int acceleraion = 3;

    // 브레이크 속도
    private int brakeSpeed = 4;

    // 생성자, 객체를 생성하는 특수한 메소드, class에 맞게 객체를 생성하기 위해
    public Car(int acceleration, int maxSpeed, int brakeSpeed) {
        this.acceleraion = acceleration;
        this.maxSpeed = maxSpeed;
        this.brakeSpeed = brakeSpeed;
    }

    // 클래스는 메소드를 이용해 다른 객체들과 상호작용이 가능하다.
    // 자동차 엑셀을 밟는 메소드, public 메소드를 통해 객체와 상호작용, 외부에서도 접근이 가능
    public void accelerationPedal() {
        // 페달을 밟을 때마다 가속도만큼 현재속도를 올린다. 최고속도 이상으로 가속되지는 않는다.
        currentSpeed = currentSpeed + acceleraion;
        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    // 자동차 브레이크 페달을 밟는다.
    public void brakePedal() {
        currentSpeed = currentSpeed - brakeSpeed;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public String getCurrentSpeedText() {
        return "현재속도는 " + this.currentSpeed + " km/h 입니다.";
    }
}
