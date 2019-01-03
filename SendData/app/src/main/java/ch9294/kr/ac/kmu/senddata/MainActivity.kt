package ch9294.kr.ac.kmu.senddata

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SECOND = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)
            intent.putExtra("data1", true)
            intent.putExtra("data1", "문자열")

//            startActivity(intent)
            startActivityForResult(intent, SECOND)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /*
        다른 액티비티가 1개이기 때문에 굳이 요청코드로 구분할 필요는 없지만
        사용자가 뒤로가기 버튼을 사용할 수 있기 때문에 결과코드를 이용해서 구분해준다.
         */

        when (resultCode) {
            Activity.RESULT_OK -> {
                var value1 = data?.getIntExtra("value1", 0)
                var value2 = data?.getDoubleExtra("value2", 0.0)
                var value3 = data?.getBooleanExtra("value3", false)
                var value4 = data?.getStringExtra("value4")

                textView.text = "value1 = ${value1}\n"
                textView.append("value2 = ${value2}\n")
                textView.append("value3 = ${value3}\n")
                textView.append("value4 = ${value4}\n")
            }

            Activity.RESULT_CANCELED -> {

            }
        }
    }
}
