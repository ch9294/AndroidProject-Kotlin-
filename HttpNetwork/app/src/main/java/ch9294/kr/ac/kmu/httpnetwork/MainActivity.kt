package ch9294.kr.ac.kmu.httpnetwork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            NetworkThread().start()
        }
    }

    /*
    네트워크 처리는 반드시 쓰레드에서 해야 함.
     */
    inner class NetworkThread : Thread() {
        override fun run() {
            /*
            접속
             */
            val site = "http://google.com"
            val url = URL(site)
            val conn = url.openConnection()

            /*
            스트림 연결
             */
            var input = conn.getInputStream()
            var isr = InputStreamReader(input, "UTF-8")
            var buf = BufferedReader(isr)

            var str: String? = null
            var buf2 = StringBuffer()

            do {
                str = buf.readLine()
                if (str != null) {
                    buf2.append(str)
                }
            } while (str != null)

            var data = buf2.toString()

            runOnUiThread {
                textView.text = data
            }
        }
    }
}
