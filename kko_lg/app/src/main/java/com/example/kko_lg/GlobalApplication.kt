package com.example.kko_lg
import android.app.Application
import com.kakao.sdk.common.KakaoSdk


class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "af6239e1f5b54fe6468df83fda0d415e")
    }
}