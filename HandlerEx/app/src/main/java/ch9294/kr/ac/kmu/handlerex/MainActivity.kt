package ch9294.kr.ac.kmu.handlerex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 메인 쓰레드의 한 작업이 5초 이상 걸리면 안된다.
    // 만약 그렇게 된다면 오류 발생!


    var handler : Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            var time = System.currentTimeMillis()
            textView1.text = "${time}"
        }

        handler = Handler()

//        while (true) {
//            SystemClock.sleep(200)
//            var time = System.currentTimeMillis()
//            textView2.text = "${time}"
//        }

        val thread = MyThread()
//        handler?.post(thread)
        handler?.postDelayed(thread,500)
    }


    inner class MyThread : Thread() {
        override fun run() {
            val time = System.currentTimeMillis()
            textView2.text = "Handler : ${time}"
            handler?.postDelayed(this,500)
        }
    }
}
