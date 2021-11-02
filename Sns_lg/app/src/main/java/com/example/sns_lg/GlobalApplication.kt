package com.example.sns_lg
import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application()  {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "fadec1cb3f96a15b93d2ecfaf2914b72")
    }
}