package ch9294.kr.ac.kmu.textview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var text2:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        코틀린 기반의 안드로이드 개발에서는 findViewBy 메소드를 이용해서 주소값을 받아 올 필요가 없다.
        XML 파일에서 만들어진 각각의 뷰의 id가 변수의 이름이 되어 객체가 자동으로 생성이 된다.
         */

        text2 = findViewById(R.id.text2)
//        text2?.setText("문자열10")
        text2?.text="문자열11"

        textView.text = "문자열3"
    }
}
