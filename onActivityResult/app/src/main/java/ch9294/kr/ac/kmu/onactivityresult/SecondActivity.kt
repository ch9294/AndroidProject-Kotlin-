package ch9294.kr.ac.kmu.onactivityresult

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        /*
        setResult() 메소드를 통해서 해당 액티비티가 종료되면서 돌아가게 될 액티비티에
        결과 코드를 넘겨줄 수 있다.
        Activity 클래스에 결과 코드를 상수로 설정해 놓았다.
         */
        button.setOnClickListener { v ->
            setResult(RESULT_OK)
            finish()
        }
        button5.setOnClickListener { v ->
            setResult(RESULT_CANCELED)
            finish()
        }
        button6.setOnClickListener { v ->
            setResult(RESULT_FIRST_USER)
            finish()
        }
    }
}
