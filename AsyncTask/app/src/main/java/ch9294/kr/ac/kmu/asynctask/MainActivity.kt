package ch9294.kr.ac.kmu.asynctask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            var time = System.currentTimeMillis()
            textView.text = "btn click : $time"
        }

        MyAsyncTask().execute(10, 20)
    }

    inner class MyAsyncTask : AsyncTask<Int, Long, String>() {
        /*
        doInBackground()가 호출되기 전에 호출됨(최초 한번만 호출됨)
        메인 쓰레드가 처리한다.(5초 이상x, 화면처리 o)
         */
        override fun onPreExecute() {
            textView2.text = "AsyncTask 가동"
        }

        /*
        새로운 쓰레드가 발생되어 일반 쓰레드 처리가 발생.(화면처리 불가능)
         */
        override fun doInBackground(vararg params: Int?): String {
            /*
            null을 허용하는 타입을 null을 허용하지 않는 타입의 변수에 대입하려면
            !!를 사용하여야한다.
             */
            var a1 = params[0]!!
            var a2 = params[1]!!

            for (idx in 0..9) {
                SystemClock.sleep(100)
                a1++
                a2++

                Log.d("test1","idx : $idx , $a1 , $a2")
            }
            return "문자열"
        }
    }
}
