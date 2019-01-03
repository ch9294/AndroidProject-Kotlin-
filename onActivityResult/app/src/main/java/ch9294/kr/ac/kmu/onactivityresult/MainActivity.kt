package ch9294.kr.ac.kmu.onactivityresult

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 1
    val THRID_ACTIVITY = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener { v ->
            var intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            startActivityForResult(intent, SECOND_ACTIVITY)
        }

        button4.setOnClickListener { v ->
            var intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, THRID_ACTIVITY)
        }
    }

    /*
    startActivityForResult 메소드를 실행했을 때만 호출됨
    requestCode는 액티비티에서 다른 액티비티를 실행을 요청할 때 여러 액티비티를 구분하기 위해 사용
    resultCode는 실행 중인 액티비티가 종료되고 돌아올 때의 상태를 나타내어 주는 코드이다.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            SECOND_ACTIVITY -> {
                textView2.text = "두번째에서 돌아옴\n"
                when (resultCode) {
                    RESULT_OK -> textView2.append("RESULT_OK")
                    RESULT_CANCELED -> textView2.append("RESULT_CANCELED")
                    RESULT_FIRST_USER -> textView2.append("RESULT_FIRST_USER")
                }
            }
            THRID_ACTIVITY -> textView2.text = "세번째에서 돌아옴"
        }
    }
}
