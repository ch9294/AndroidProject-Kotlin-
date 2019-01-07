package ch9294.kr.ac.kmu.broadcastreciever

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { v ->
            var intent = Intent(this, TestReceiver::class.java)
            sendBroadcast(intent)
        }
    }
}
