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
}
