package com.example.kotlinsample

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_control.*

class ControlKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_control)

        // 버튼이 클릭되었을 때의 이벤트 리스너를 설정한다.
        button.setOnClickListener {
            // numberField의 값을 읽어 int 형으로 변환한다.
            val number = numberField.text.toString().toInt()

            // if, else if, else 문으로 2의 배수, 3의 배수를 체크해 서로 다른 토스트 메세지를 보여준다.
            if (number % 2 == 0) {
                Toast.makeText(applicationContext, "${number} 는 2의 배수입니다.", Toast.LENGTH_SHORT).show() }
            else if (number % 3 == 0) {
                Toast.makeText(applicationContext, "${number} 는 3의 배수입니다.", Toast.LENGTH_SHORT).show() }
            else {
                Toast.makeText(applicationContext, "${number}", Toast.LENGTH_SHORT).show() }

            // 코틀린에서는 switch 문을 대체해 when 을 사용할 수 있다.
            when (number) {
                // case 1~4까지 같은 코드 실행
                in 1..4 -> button.text = "실행 - 4"
                9, 18 -> { button.text = "실행 - 9" }  // 9와 18 인 경우 같은 코드 실행
                else -> button.text = "실행"
            }
        }
    }
}