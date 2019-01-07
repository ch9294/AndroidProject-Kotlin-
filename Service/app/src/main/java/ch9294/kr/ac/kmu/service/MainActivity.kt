package ch9294.kr.ac.kmu.service

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var service_intent: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            service_intent = Intent(this, ServiceClass1::class.java)
            // 서비스 가동
            startService(service_intent)
        }

        button2.setOnClickListener { v ->
            // 서비스 종료
            stopService(service_intent)
        }

        button3.setOnClickListener { v ->
            service_intent = Intent(this, ServiceClass2::class.java)
            startService(service_intent)
            finish()
        }

        button4.setOnClickListener { v ->
            service_intent = Intent(this, ServiceClass3::class.java)
            /*
            오레오 버전 이상부터는 포그라운드 서비스를 실행하기 위한 startForgroundService()가 있다.
             */
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // 포그라운드 서비스를 호출하게 되면 5초 이내에 반드시 Notification 메세지를 반드시 띄어 주어야 실행이
                // 중단되지 않는다.
                startForegroundService(service_intent)
            } else {
                //Toast.makeText(this,"오레오 버전이 아닙니다.",Toast.LENGTH_SHORT).show()
                startService(service_intent)
            }
            finish()
        }
    }
}
