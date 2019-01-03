package ch9294.kr.ac.kmu.handlerex2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isRunning = false
    var handler: DisplayHandler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            var time = System.currentTimeMillis()
            textView1.text = "$time"
        }

        isRunning = true
        MyThread().start()

    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    inner class MyThread : Thread() {
        override fun run() {

            var a1 = 10
            var a2 = 20

            SystemClock.sleep(500)
            while (isRunning) {
                var msg2 = Message()
                msg2.what = 1
                msg2.arg1 = ++a1
                msg2.arg2 = ++a2
                msg2.obj = "안녕하세요"

                var time = System.currentTimeMillis()
                Log.d("text", "Thread : $time")
                handler?.sendMessage(msg2)
//
//                var msg = Message()
//                msg.what = 0
//                msg.obj = time


            }
        }
    }

    inner class DisplayHandler : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

            when (msg?.what) {
                1 -> textView2.text = "${msg.arg1} , ${msg.arg2}, ${msg.obj}"
                0 -> textView2.text = "Handler time : ${msg?.obj}"
            }
//            var time = System.currentTimeMillis()
//            textView2.text = "Handler time : ${msg?.obj}"
        }
    }
}
