package ch9294.kr.ac.kmu.brapp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v->
            var intent = Intent()
            intent.setClassName("ch9294.kr.ac.kmu.broadcastreciever","ch9294.kr.ac.kmu.broadcastreciever.TestReceiver")
            sendBroadcast(intent)
        }
    }
}
