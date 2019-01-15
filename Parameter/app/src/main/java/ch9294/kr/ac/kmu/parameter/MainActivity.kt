package ch9294.kr.ac.kmu.parameter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            val thread = NetworkThread()
            thread.start()
        }
    }

    inner class NetworkThread : Thread() {
        override fun run() {
            val client = OkHttpClient()
            val builder = Request.Builder()
            val url = builder.url("http://13.125.170.17/Basic.php")

//            val request = url.build()

            val bodyBuilder = FormBody.Builder()

            // 서버로 보내는 데이터는 무조건 문자열이다.
            bodyBuilder.add("data1", "문자열1")
            bodyBuilder.add("data2", "문자열2")
            bodyBuilder.add("data3", "문자열3")

            val body = bodyBuilder.build()
            val post = url.post(body)

            val request = post.build()

//            client.newCall(request).execute()
            client.newCall(request).enqueue(Callback1())
        }
    }

    inner class Callback1 : Callback {
        override fun onFailure(call: Call, e: IOException) {
            runOnUiThread {
                Toast.makeText(this@MainActivity, "연결에 실패했습니다.", Toast.LENGTH_SHORT)
            }
        }

        override fun onResponse(call: Call, response: Response) {
            val result = response.body()?.string()
            val obj = JSONObject(result)
            val val1 = obj.getString("value1")
            val val2 = obj.getString("value2")
            val val3 = obj.getString("value3")

            runOnUiThread {
                textView2.text = "val1 : ${val1}\n"
                textView2.append("val2 : ${val2}\n")
                textView2.append("val3 : ${val3}\n")
            }
        }
    }
}
