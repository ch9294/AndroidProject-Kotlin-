package ch9294.kr.ac.kmu.threadex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1.text = "텍스트를 표시하시오!"
        textView2.text = "텍스트를 표시하시오!"
        MyThread().start()
    }

    inner class MyThread : Thread() {
        override fun run() {
            while (true) {
                Log.d("Current Time", "${System.currentTimeMillis()}")
                textView2.text = "${"현재시간 : ${System.currentTimeMillis()}"}"
                SystemClock.sleep(500)
            }
        }
    }
}
