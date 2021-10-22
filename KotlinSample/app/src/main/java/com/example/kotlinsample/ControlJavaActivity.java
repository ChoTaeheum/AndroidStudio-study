package com.example.kotlinsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ControlJavaActivity extends AppCompatActivity {

    // 불필요한 findViewBuId 함수를 피하기 위해 UI요소를 멤버변수로 가지고 있는다.
    EditText numberField;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // UI로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(R.layout.layout_control);

        // UI 요소 멤버변수를 XML 레이아웃에서 findViewById 함수를 이용해 바인딩한다.
        numberField = findViewById(R.id.numberField);
        button = findViewById(R.id.button);

        // 버튼이 클릭되었을 때의 이벤트리스너를 설정한다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(numberField.getText().toString());

                // if, else if, else 문으로 2의 배수, 3의 배수를 체크해 서로 다른 토스트 메세지를 보여준다.
                if (number % 2 == 0) {
                    Toast.makeText(getApplicationContext(), "" + number + " 는 2의 배수입니다.", Toast.LENGTH_SHORT).show(); }

                else if (number % 3 == 0) {
                    Toast.makeText(getApplicationContext(), "" + number + " 는 3의 배수입니다.", Toast.LENGTH_SHORT).show(); }

                else {
                    Toast.makeText(getApplicationContext(), "" + number, Toast.LENGTH_SHORT).show(); }

                // switch 문으로 체크 후 버튼의 텍스트를 변경한다.
                switch (number) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        button.setText("실행 - 4");   // case 1~4 까지 같은 코드 실행
                        break;
                    case 9:
                        button.setText("실행 - 9");
                        break;
                    default:
                        button.setText("실행");
                        break;
                }
            }
        });
    }
}