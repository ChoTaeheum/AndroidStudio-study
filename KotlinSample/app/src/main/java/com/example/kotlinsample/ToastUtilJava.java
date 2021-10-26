package com.example.kotlinsample;

import android.widget.Toast;

public class ToastUtilJava {
    // 짧은 토스트 메세지를 보여주는 함수
    public static void toastShort(String message) {
        Toast.makeText(MainApplication.getAppContext(),message, Toast.LENGTH_SHORT).show();
    }

    // 긴 토스트 메세지를 보여주는 함수
    public static void toastLong(String message) {   // static 메서드는 클래스의 인스턴스화 없이 호출 가능
        Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    // 파라미터에 따라 긴 토스트 메세지, 또는 짧은 토스트 메세지를 보여준다.
    public static void toast(String message, int length) {
        Toast.makeText(MainApplication.getAppContext(), message, length).show();
    }

    // 파라미터의 기본값을 사용하기 위해 메소드 오버로딩 (이름이 같아도 인자가 다르면 다르게 쓸 수 있음)
    // 하지만 이 방법은 파라미터의 개수가 늘어나면 굉장히 불편해짐 (여러번 오버로딩 되어야함)
    public static void toast(String message) {
        toast(message, Toast.LENGTH_SHORT);
    }
}