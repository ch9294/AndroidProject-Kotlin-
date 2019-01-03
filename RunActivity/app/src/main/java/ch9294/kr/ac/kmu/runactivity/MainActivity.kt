package ch9294.kr.ac.kmu.runactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            /*
            intent를 만들어 안드로이드 os에게 실행 요청을 한다.
             */
            var intent = Intent(this, SecondActivity::class.java)
            intent.put
            startActivity(intent)
        }

        button3.setOnClickListener { v ->
            finish()
        }
    }
}
