package com.example.kotlinsample

import android.widget.Toast

fun toastShort(message:String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show()
}

fun toastLong(message: String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show()
}

// 코틀린에서는 함수가 꼭 클래스 내부에 있을 필요는 없다.