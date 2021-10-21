package com.example.kotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VariableKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // UI로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(R.layout.layout_variable)
    }
}
