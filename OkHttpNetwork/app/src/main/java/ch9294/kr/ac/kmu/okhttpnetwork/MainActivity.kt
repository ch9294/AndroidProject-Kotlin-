package ch9294.kr.ac.kmu.okhttpnetwork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            var thread = HttpThread()
            thread.start()
        }
    }

    inner class HttpThread : Thread() {
        override fun run() {

            try {
                // 클라이언트 객체 생성
                val client = OkHttpClient()

                // 요청을 위한 객체를 생성
                val builder = Request.Builder()
//            val url = builder.url("http://google.com")

                // 서버 주소 입력
                val url = builder.url("http://13.125.170.17/okhttp.html")

                // 최종 요청 객체 생성
                var request = url.build()

                // 서버에 대한 요청과 응답을 처리하기 위한 콜백 객체 생성
                var callback1 = CallBack1()

                // 실행
                client.newCall(request).enqueue(callback1)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    inner class CallBack1 : Callback {
        // 서버와의 통신이 실패 했을때
        override fun onFailure(call: Call, e: IOException) {
            Log.d("okhttpTest", "통신 실패!")
        }

        // 서버와의 통신이 성공하여 원하는 데이터를 모두 가져왔을 때!!!
        override fun onResponse(call: Call, response: Response) {
            Log.d("okhttpTest", "통신 성공!")
            val result = response.body()?.string()
            Log.d("httpResponse", result)

//            runOnUiThread {
//                textView.text = result
//            }
        }
    }
}
