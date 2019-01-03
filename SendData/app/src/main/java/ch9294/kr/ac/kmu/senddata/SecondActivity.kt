package ch9294.kr.ac.kmu.senddata

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getDoubleExtra("data2", 0.0)
        val data3 = intent.getBooleanExtra("data3", false)
        val data4 = intent.getStringExtra("data4")

        textView2.text = "data1 = ${data1}\n"
        textView2.append("data2 = ${data2}\n")
        textView2.append("data3 = ${data3}\n")
        textView2.append("data4 = ${data4}\n")
        button2.setOnClickListener { v ->

            var intent2 = Intent()
            intent2.putExtra("value1", 200)
            intent2.putExtra("value2", 22.22)
            intent2.putExtra("value3", true)
            intent2.putExtra("value4", "문자열2")
            setResult(Activity.RESULT_OK, intent2)
            finish()
        }
    }
}
