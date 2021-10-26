@file:JvmName("ToastUtil")   // 어노테이션 설정,클래스 이름을 지정할 수 있음
package com.example.kotlinsample

import android.widget.Toast

fun toastShort(message:String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show()
}

fun toastLong(message: String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show()
}

// 코틀린은 함수의 기본값을 지정 가능하다.
fun toast(message:String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MainApplication.getAppContext(), message, length).show()
}

// 코틀린에서는 함수가 꼭 클래스 내부에 있을 필요는 없다.
// 아직 Java 컴파일러는 코틀린의 '파라미터 기본값'을 처리하지 못한다.
// 하지만 어노테이션 기능을 통해 마치 Java에서 메소드 오버로딩 효과를 줄 수 있다.
// @JvmOverloads 구문